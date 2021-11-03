package test4;
public class Bank {
    private Customer[] customers;//可以存放多个客户的数组
    private int numberOfCustomer;//记录客户个数
    public Bank()
    {
        customers=new Customer[10];
    }
    //添加客户
    public void addCustomer(String f,String l)
    {
        Customer cust=new Customer(f,l);
        //customers[numberOfCustomer]=cust;
        //numberOfCustomer++;
        //或
        customers[numberOfCustomer++]=cust;
    }
    //获取客户个数
    public int getNumberOfCustomer()
    {
        return numberOfCustomer;
    }
    //获取指定位置上的客户
    public Customer getCustomer(int index)
    {
        //return customers[index];这样写不太合适,可能会报异常
        if(index>=0&&index<numberOfCustomer)
        {
            return customers[index];
        }
        return null;//或者抛个异常
    }
}
