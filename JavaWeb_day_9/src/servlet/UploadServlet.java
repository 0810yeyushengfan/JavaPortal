package servlet;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/*
两个jar包中常用的类(导入的jar包是commons的):
1.ServletFileUpload类:用于解析上传的数据
1.1.public static final boolean isMultipartContent(HttpServletRequest request):
如果上传的数据是多段的形式，返回true，只有多段的数据才是文件上传的
1.2.public ServletFileUpload():
空参构造器
1.3.public ServletFileUpload(FileItemFactory fileItemFactory):
参数为工厂实现类的构造器
1.4.public List parseRequest(HttpServletRequest request):
解析上传的数据，返回包含每一个表单项的List集合
2.FileItem类:表示每一个表单项
2.1.public boolean isFormField():
如果当前表单项是普通表单项返回true，文件类型返回false
2.2.public String getFieldName():
获取当前表单项的name属性值
2.3.public String getString():
获取当前表单项的value属性值，参数为”UTF-8”可解决乱码问题
2.4.public String getName():
获取上传的文件名
2.5.public void write(File file):
将上传的文件写到参数File所指向的硬盘位置
 */
public class UploadServlet extends HttpServlet {
    //用来处理上传的数据
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.先判断上传的数据是否多段数据（只有是多段的数据，才是文件上传的）
        if (ServletFileUpload.isMultipartContent(req)) {
            //2.创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //3.创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                //4.解析上传的数据，得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //5.循环判断每一个表单项是普通类型还是上传的文件
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        //普通表单项
                        System.out.println("表单项的name属性值:" + fileItem.getFieldName());
                        //参数UTF-8.解决乱码问题
                        System.out.println("表单项的value属性值:" + fileItem.getString("UTF-8"));
                    } else {
                        //上传的文件
                        System.out.println("表单项的name属性值:" + fileItem.getFieldName());
                        System.out.println("上传的文件名:" + fileItem.getName());
                        fileItem.write(new File("e:\\" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
