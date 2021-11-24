package com.yeyu.config;

//public class MyTypeFilter implements TypeFilter {
//
//    //metadataReader:读取到的当前正在扫描的类的信息
//    //metadataReaderFactory:可以获取到其他任何类的信息的工厂
//    @Override
//    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
//        //获取前正在扫描的类的注解信息
//        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
//        //获取当前正在扫描的类的类信息
//        ClassMetadata classMetadata = metadataReader.getClassMetadata();
//        //获取当前正在扫描的类的资源(比如类的路径)
//        Resource resource = metadataReader.getResource();
//        //获取当前正在扫描的类的类名
//        String className = classMetadata.getClassName();
//        System.out.println("当前正在扫描的类的类名为:" + className);
//        //自定义过滤规则，如果类名中包含"er"返回true，表示可以被IOC容器排除/加载(因为使用的是excludeFilters属性，此处为排除，includeFilters属性反之)，不包含"er"返回false，表示不能被IOC容器加载/排除(因为使用的是excludeFilters属性，此处为加载，includeFilters属性反之)
//        if (className.contains("er")) {
//            return true;
//        }
//        return false;
//    }
//}
