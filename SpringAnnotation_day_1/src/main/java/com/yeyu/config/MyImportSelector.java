package com.yeyu.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    //返回值就是要导入到容器中的组件的全类名
    //AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.yeyu.bean.Blue","com.yeyu.bean.Yellow"};
        //方法不能返回null，返回null会报空指针异常
        //return null;
    }
}
