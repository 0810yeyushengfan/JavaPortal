package com.yeyu.spring5.bean;

public class Orders2 {
        //无参数构造
        public Orders2() {
            System.out.println("第一步:执行无参数构造创建bean实例");
        }

        private String name;
        public void setName(String name) {
            this.name = name;
            System.out.println("第二步:调用set方法设置属性值");
        }

        //创建执行的初始化的方法
        public void initMethod() {
            System.out.println("第三步:执行初始化的方法");
        }

        //创建执行的销毁的方法
        public void destroyMethod() {
            System.out.println("第五步:执行销毁的方法");
        }
}
