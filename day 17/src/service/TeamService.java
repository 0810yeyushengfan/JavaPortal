package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;

/**
 * 功能：关于开发团队成员的管理：添加、删除等。
 * 说明：
 * counter为静态变量，用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。（提示：应使用增1的方式）
 * MAX_MEMBER：表示开发团队最大成员数
 * team数组：用来保存当前团队中的各成员对象
 * total：记录团队成员的实际人数
 */
public class TeamService {
    private static int counter = 1;//给memberId赋值使用
    private final int MAX_MEMBER = 5;//限制开发团队的人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
    private int total;//记录开发团队中实际的人数

    public TeamService() {
        super();
    }

    /**
     * getTeam()方法：返回当前团队的所有对象
     * 返回：包含所有成员对象的数组，数组大小与成员人数一致
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * addMember(e: Employee)方法：向团队中添加成员
     * 参数：待添加成员的对象
     * 异常：添加失败， TeamException中包含了失败原因
     */
    public void addMember(Employee e) throws TeamExpection {
        //成员已满，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamExpection("成员已满，无法添加");
        }
        // 该成员不是开发人员，无法添加
        if (!(e instanceof Programmer)) {
            throw new TeamExpection("该成员不是开发人员，无法添加");
        }
        //该员工已在本开发团队中
        if (isExist(e)) {
            throw new TeamExpection("该员工已在本开发团队中");
        }
        //该员工已是某团队成员
        //该员正在休假，无法添加
        Programmer p = (Programmer) e;//一定不会出现ClassCastException
        if ("BUSY".equals(p.getStatus().getNAME()))
            throw new TeamExpection("该员工已是某团队成员");
        else if ("VOCATION".equals(p.getStatus().getNAME())) {
            throw new TeamExpection("该员正在休假，无法添加");
        }

        //获取team已有成员中架构师，设计师和程序员的人数
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }
        //团队中至多只能有一名架构师
        //团队中至多只能有两名设计师
        // 团队中至多只能有三名程序员
        if (p instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamExpection("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamExpection("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamExpection("团队中至多只能有三名程序员");
            }
        }
        //将p添加到现有的team中
        team[total++]=p;
        //p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberID(counter++);
    }

    /**
     * 判断指定的员工是否已经存在于现有的开发团队中
     */
    private boolean isExist(Employee e) {
        boolean flag = false;
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == e.getId()) {
                flag = true;
            }
        }
        return flag;
    }
    /**
     * removeMember(memberId: int)方法：从团队中删除成员
     * 参数：待删除成员的memberId
     * 异常：找不到指定memberId的员工，删除失败
     */
    public void removeMerber(int merberId) throws TeamExpection {
        int i=0;
        for(;i<total;i++){
            if(team[i].getMemberID()==merberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        //未找到指定memberId的情况
        if(i==total){
            throw new TeamExpection("找不到指定memberId的员工，删除失败");
        }
        //后一个元素覆盖前一个元素，实现删除操作
        for(int j=i+1;j<total;j++){
            team[j-1]=team[j];
        }
        //写法一:
//        team[total-1]=null;
//        total--;
        //写法二:
        team[--total]=null;
    }

}
