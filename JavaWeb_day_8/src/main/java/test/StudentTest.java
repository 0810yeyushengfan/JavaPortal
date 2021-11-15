package test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import pojo.Student;

import java.util.List;
/*
dom4j编程步骤:
第一步:先加载xml文件，创建Document对象
第二步:通过Document对象拿到根元素对象
第三步:通过根元素.elements(标签名)，可以返回一个集合，这个集合里放着所有你指定的标签名的元素对象
第四步:找到你想要修改、删除的子元素，进行相应在的操作
第五步:保存到硬盘上
 */

public class StudentTest {
    @Test
    public void test1() throws Exception {
        //需要分四步操作:
        //第一步:通过创建SAXReader对象来读取xml文件，获取Document对象
        //第二步:通过Document对象拿到XML的根元素对象
        //第三步:通过根元素对象获取所有的student标签对象
        //第四步:遍历每个student标签对象。然后获取到student标签对象内的每一个元素，再通过getText()方法拿到起始标签和结束标签之间的文本内容
        try {
            //创建解析器
            SAXReader reader = new SAXReader();
            //通过解析器将文件解析为Document
            Document document = reader.read("src/students.xml");
            //通过document对象获取根元素
            Element element = document.getRootElement();
            //通过根元素获取所有的子元素
            List<Element> elements = element.elements();
            for (Element e : elements) {
                //获取属性值
                String id = e.attributeValue("id");
                //获取文本值
                //间接获取
                Element nameElement =e.element("name");
                String name=nameElement.getText();
                //直接获取
                String age = e.elementText("age");
                String gender = e.elementText("gender");
                Student stu = new Student(id, name, age, gender);
                System.out.println(stu);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
