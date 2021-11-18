# SpringBoot基础篇

## 一.快速上手SpringBoot

### 1.SpringBoot入门程序开发

#### 1.官方定义

Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。

1. Spring程序缺点：

* 依赖设置繁琐

* 配置繁琐

2. SpringBoot程序优点：

* 起步依赖（简化依赖配置）

* 自动配置（简化常用工程相关配置）

* 辅助功能（内置服务器，……）

#### 2.四种方法创建SpringBoot初始程序

##### (1).IDEA联网版

①.创建新模块，选择Spring Initializr，并配置模块相关基础信息

![image-20211117200055518](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211117200055518.png)

②.选择当前模块需要使用的技术集  ![image-20211117202536468](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211117202536468.png)

③.开发控制器类

```java
 //Rest模式
    @RestController
    @RequestMapping("/index")
    public class BookController {
        @GetMapping
        public String getById(){
            System.out.println("springboot is running...");
            return "springboot is running...";
        }
    }
```

④.运行自动生成的Application类

![image-20211117203656578](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211117203656578.png)

⑤.观察程序的组成:

SpringBoot程序相比于传统的Spring程序的特点:

1. 不需要手动配置web3.0配置类和Spring/SpringMVC配置类
2. 使用勾选添加代替手工添加pom文件中的坐标

最简SpringBoot程序所包含的基础文件:

1. pom.xml文件

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
       <modelVersion>4.0.0</modelVersion>
       <parent>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-parent</artifactId>
           <version>2.5.6</version>
           <relativePath/> <!-- lookup parent from repository -->
       </parent>
       <groupId>com.yeyu</groupId>
       <artifactId>SpringBoot2_day_1</artifactId>
       <version>0.0.1-SNAPSHOT</version>
       <name>SpringBoot2_day_1</name>
       <description>SpringBoot2_day_1</description>
       <properties>
           <java.version>1.8</java.version>
       </properties>
       <dependencies>
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-web</artifactId>
           </dependency>
   
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-test</artifactId>
               <scope>test</scope>
           </dependency>
       </dependencies>
   
       <build>
           <plugins>
               <plugin>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-maven-plugin</artifactId>
               </plugin>
           </plugins>
       </build>
   
   </project>
   ```

2. Application类

   **运行SpringBoot程序通过运行Application程序入口进行**

   ```java
   @SpringBootApplication
   public class SpringBoot2Day1Application {
   
       public static void main(String[] args) {
           SpringApplication.run(SpringBoot2Day1Application.class, args);
       }
   
   }
   ```

**注意:基于IDEA开发SpringBoot程序需要确保全程联网且能够加载到程序框架结构**

##### (2).官网创建版

①.进入[SpringBoot官网中快速创建项目的页面](https://start.spring.io/)

![image-20211117225655670](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211117225655670.png)

②.创建项目之后会在浏览器中增加一个下载任务，下载我们创建的项目的压缩包

![image-20211117225903667](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211117225903667.png)

③.解压这个压缩包，即可得到我们刚刚创建的工程

![image-20211117230031942](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211117230031942.png)

注意:由于[SpringBoot官网中快速创建项目的页面](https://start.spring.io/)在国外，因此访问速度可能会很慢

##### (3).阿里云版

①.创建新模块，选择Spring Initializr，并配置项目中的Server URL为[阿里云仓库](https://start.aliyun.com)

![image-20211117230631691](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211117230631691.png)

②.选择当前模块需要使用的技术集

![image-20211117231037578](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211117231037578.png)

③. 其他做法同(1)

**注意:**

**1. 阿里云提供的坐标版本较低，如果需要使用高版本，进入工程后手工切换SpringBoot版本**

**2.阿里云提供的工程模板与Spring官网提供的工程模板略有不同**

**3.用阿里云创建SpringBoot项目也需要全程联网且能够加载到程序框架结构**

##### (4).手工创建版

①.手工创建一个Maven项目

![image-20211117232840963](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211117232840963.png)

(2).手工在pom.xml中导入坐标，继承spring-boot-starter-parent，添加依赖spring-boot-starter-web

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.6</version>
    </parent>
    <groupId>com.yeyu</groupId>
    <artifactId>SpringBoot2_day_1</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
</project>
```

(3).手工制作引导类

```java
package com.yeyu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    } 
}
```

**注意:手工创建SpringBoot项目只是在创建的时候不需要联网，在用Maven引入依赖的时候，所有的项目都是需要联网的，即不论以何种方式创建SpringBoot，最终都需要联网这一步骤。**



#### 3.入门案例解析

##### (1).parent

我们发现在每个SpringBoot工程的pom.xml文件中，都继承了parent这个模块。

```xml
 <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.6</version>
        <relativePath/> <!-- lookup parent from repository -->
 </parent>
```

这个模块是用来干什么的呢?让我们点进去看看，发现它又继承了另一个parent模块。

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.5.6</version>
</parent>
```

同样，继续进入这个模块，我们会发现在这里定义了一系列的常用坐标版本。

```xml
<properties> 
    <druid.version>1.1.16</druid.version> 
    <mybatis.version>3.5.6</mybatis.version> 
    <mysql.version>5.1.47</mysql.version> 
    <db2.version>1.2.3</db2.version> 
    <oracle.version>2.3.4</oracle.version> 
    <sybase.version>3.4.5</sybase.version> 
    <dbase.version>4.5.6</dbase.version> 
    <foxpro.version>5.6.7</foxpro.version> 
    <…….version>6.7.8</…….version> 
    ......
</properties>
```

同时这里还定义一系列的常用坐标组合。

```xml
<dependencyManagement>
    <dependency> 
        <groupId>com.alibaba</groupId> 
        <artifactId>druid</artifactId> 
        <version>${druid.version}</version>
	</dependency> 
    <dependency> 
        <groupId>org.mybatis</groupId> 
        <artifactId>mybatis</artifactId> 
        <version>${mybatis.version}</version>
	</dependency> 
    <dependency> 
        <groupId>mysql</groupId> 
        <artifactId>mysql-connector-java</artifactId> 
        <version>${mysql.version}</version>
	</dependency>
</dependencyManagement>
```

这使得我们在自己的SpringBoot项目中的pom.xml中添加依赖时，就不必考虑引入的依赖的版本问题，因为在这里直接给你定义好了要用哪个版本，不过这个坐标版本也遗漏了许多好用的依赖，例如mybatis-plus，durid.....，这些都需要我们手动添加依赖的版本。

```xml
 <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
 </dependency>
```

![image-20211118125818838](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211118125818838.png)

这个4.0.1就是parent中定义好的依赖版本，也是它认为最稳定的版本，是不会发生依赖冲突的版本。这样做避免了多个依赖使用相同技术时出现依赖版本冲突，节约了开发者的时间。

当然，每个不同的SpringBoot版本，其所定义的常用坐标版本也不一致。

我们打开使用阿里云创建的SpringBoot项目中的pom.xml文件，并没有发现继承了parent这个模块，但是它同样能做到之前的功能，这是因为它在这里直接引入了spring-boot-dependencies的依赖。所以继承parent的形式也可以采用引入依赖的形式实现效果。

```xml
 <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
 </dependencyManagement>
```

##### (2).starter

在parent中只是规定了一系列的常用坐标版本，并没有引入这些依赖，观察我们的项目中的pom.xml，也没有发现依赖的引入，只发现项目引入了一个spring-boot-starter-web(这是因为勾选了spring-web选项，如果不勾选，默认是spring-boot-starter,其实在spring-boot-starter-web也有spring-boot-starter，然后再加上了一些其他的web配置)，正是在这个starter中，定义了当前项目使用的所有依赖坐标，达到了减少依赖配置的目的。

```xml
 <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter</artifactId>
      <version>2.5.6</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-json</artifactId>
      <version>2.5.6</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-tomcat</artifactId>
      <version>2.5.6</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-web</artifactId>
      <version>5.3.12</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.3.12</version>
      <scope>compile</scope>
    </dependency>
 </dependencies>

```

打开其中的spring-boot-starter-tomcat验证。

```xml
  <dependencies>
    <dependency>
      <groupId>jakarta.annotation</groupId>
      <artifactId>jakarta.annotation-api</artifactId>
      <version>1.3.5</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>org.apache.tomcat.embed</groupId>
      <artifactId>tomcat-embed-core</artifactId>
      <version>9.0.54</version>
      <scope>compile</scope>
      <exclusions>
        <exclusion>
          <artifactId>tomcat-annotations-api</artifactId>
          <groupId>org.apache.tomcat</groupId>
        </exclusion>
      </exclusions>
    </dependency>
    <dependency>
      <groupId>org.apache.tomcat.embed</groupId>
      <artifactId>tomcat-embed-el</artifactId>
      <version>9.0.54</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>org.apache.tomcat.embed</groupId>
      <artifactId>tomcat-embed-websocket</artifactId>
      <version>9.0.54</version>
      <scope>compile</scope>
      <exclusions>
        <exclusion>
          <artifactId>tomcat-annotations-api</artifactId>
          <groupId>org.apache.tomcat</groupId>
        </exclusion>
      </exclusions>
    </dependency>
 </dependencies>
```

总结:

1. starter

* SpringBoot中常见项目名称，定义了当前项目使用的所有依赖坐标，以达到减少依赖配置的目的
* 开发SpringBoot程序需要导入坐标时通常导入对应的starter
* 每个不同的starter根据功能不同，通常包含多个依赖坐标

2. parent

* 所有SpringBoot项目要继承的项目，定义了若干个坐标版本号（依赖管理，而非依赖），以达到减少依赖冲突的目的

* spring-boot-starter-parent各版本间存在着诸多坐标版本不同

3. started和parent都是用来解决配置问题的

4. 实际开发

* 使用任意坐标时，仅书写GAV中的G和A，V由SpringBoot提供，除非SpringBoot未提供对应版本V 

* 如发生坐标错误，再指定Version（要小心版本冲突）

  

##### (3).引导类

* 启动方式:直接运行这个引导类的main()方法。

~~~java
@SpringBootApplication
public class SpringBoot2Day2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2Day2Application.class, args);
    }
}
~~~

* SpringBoot的引导类是Boot工程的执行入口，运行main方法就可以启动项目，但是此时未启动web服务器。

* SpringBoot工程运行后初始化Spring容器，扫描引导类所在包加载bean(所以如果没有把想要使用的类放在引导类所在的包下，会扫描不到无法加载)。

##### (4).内嵌Tomcat服务器

1.  内嵌Tomcat服务器是SpringBoot辅助功能之一

   让我们寻找一下Tomcat服务器在项目中的哪个位置

   1. 打开pom.xml，找到spring-boot-starter-web并进入。   

   ```xml
   <dependencies> 
       <dependency> 
           <groupId>org.springframework.boot</groupId> 
           <artifactId>spring-boot-starter-web</artifactId>
   	</dependency> 
   </dependencies>
   ```

   2. 找到spring-boot-starter-tomcat并进入。

   ```xml
   <dependency>
   	<groupId>org.springframework.boot</groupId> 
   	<artifactId>spring-boot-starter-tomcat</artifactId> 
   	<version>2.5.4</version>
   </dependency>
   ```

   3. 找到tomcat-embed-core，这个就是内嵌的tomcat服务器的核心依赖。

   ```xml
   <dependency> 
       <groupId>org.apache.tomcat.embed</groupId> 
       <artifactId>tomcat-embed-core</artifactId> 
       <version>9.0.52</version>
   </dependency>
   ```

2. 内嵌Tomcat工作原理是将Tomcat服务器作为对象运行，并将该对象交给Spring容器管理

3. 变更内嵌服务器思想是去除现有服务器，添加全新的服务器

   变更内嵌服务器只需要修改当前程序的pom.xml文件，使用maven依赖管理变更起步依赖项即可。

   Jetty比Tomcat更轻量级，可扩展性更强(相较于Tomcat)，谷歌应用引擎(GAE)已经全面切换为Jetty。

   ```xml
   <dependencies> 
       <dependency> 
           <groupId>org.springframework.boot</groupId> 
           <artifactId>spring-boot-starter-web</artifactId>
           <!--web起步依赖环境中，排除Tomcat起步依赖--> 
           <exclusions> 
               <exclusion> 
                   <groupId>org.springframework.boot</groupId> 
                   <artifactId>spring-boot-starter-tomcat</artifactId>
   			</exclusion>
   		</exclusions>
   	</dependency>
   	<!--添加Jetty起步依赖，版本由SpringBoot的starter控制--> 
       <dependency> 
           <groupId>org.springframework.boot</groupId> 
           <artifactId>spring-boot-starter-jetty</artifactId>
   	</dependency>
   </dependencies>
   ```

   内嵌服务器的种类

   *  tomcat(默认)                apache出品，粉丝多，应用面广，负载了若干较重的组件

   *  jetty                               更轻量级，负载性能远不及tomcat

   * undertow                       负载性能勉强跑赢tomcat

   

### 2.SpringBoot程序操作的细节

#### 1.隐藏文件/文件夹

在我们新创建的SpringBoot项目中有许多暂时没有用的文件/文件夹，我们就可以把它隐藏起来

![image-20211117234621845](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211117234621845.png)

(1).打开File-Settings-Editor-File Types中的Ignored Files and Folders

![image-20211117234940960](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211117234940960.png)

(2).输入要隐藏的文件名，支持*号通配符，回车确认添加

![image-20211117235654308](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211117235654308.png)

#### 2.复制工程

* 原则
  * 保留工程基础结构
  * 抹掉原始工程痕迹

* 步骤

  (1).在工作空间中复制对应工程，并修改工程名称

  (2).删除与Idea相关配置文件，仅保留src目录与pom.xml文件

  (3).修改pom.xml文件中的artifactId与新工程/模块名相同

  (4).删除name标签(可选)

  (5).保留备份工程供后期使用

#### 3.自动提示功能消失解决方案

步骤:

(1).Setting → Project Structure → Facets

(2).选中对应项目/工程

(3). Customize Spring Boot

(4).选择配置文件

## 二.SpringBoot基础配置

### 1.属性配置

#### 1.修改配置

* 修改服务器端口

  ```properties
  server.port=80
  ```

* 关闭运行日志图标(banner) 

  ```properties
  spring.main.banner-mode=off
  ```

* 设置日志级别

  ```properties
  logging.level.root=debug
  ```

#### 2.SpringBoot内置属性查询

* https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties

* 官方文档中参考文档第一项:Application Properties

#### 3.注意事项

* SpringBoot中导入对应starter后，才会提供对应的配置属性
* 书写SpringBoot配置建议采用关键字+提示形式进行书写，如遇到陌生配置，应上官网查询其含义

### 2.配置文件分类

#### 1.配置文件种类

SpringBoot提供了3种配置文件的格式。

SpringBoot默认配置文件application.properties，通过键值对配置对应属性

* application.properties(传统格式/默认格式)

  ```properties
  server.port=80
  ```

* application.yml(主流格式)

  ```yaml
  server:
    prot: 81
  ```

* application.yaml

  ```yaml
  server:
    prot: 82
  ```

#### 2.SpringBoot配置文件加载顺序

* SpringBoot项目中允许这三种格式的配置文件同时存在
* 配置文件间的加载优先级:application.properties > application.yml>application.yaml
* 不同配置文件中的相同配置按照加载优先级相互覆盖，不同配置文件中的不同配置全部保留

### 3.yaml文件

#### 1.yaml介绍

YAML(YAML Ain't Markup Language)，一种数据序列化格式

* 优点：
  * 容易阅读
  *  容易与脚本语言交互
  *  以数据为核心，重数据轻格式

* YAML文件扩展名
  * .yml(主流)
  * .yaml

#### 2.yaml语法规则

* 属性名大小写敏感，String类型的属性值大小写敏感，boolean类型的属性值大小写不敏感(最终都会转为小写)

* 属性层级关系使用多行描述，每行结尾使用冒号结束

* 使用缩进表示层级关系，同层级左侧对齐，只允许使用空格（不允许使用Tab键）

* 属性值前面添加空格（属性名与属性值之间使用冒号+空格作为分隔）

* #表示注释

* 核心规则：**数据前面要加空格与冒号隔开**

  ```yaml
  enterprise:
    name: yeyu
    age: 16
    tel: 4006184000
  #我是注释 #注释支持嵌套 ####只有第一个#会解析成注释
  ```

* 字面值表示方式

  ```yaml
  boolean: TRUE #TRUE,true,True,FALSE,false，False均可
  float: 3.14 #6.8523015e+5 #支持科学计数法
  int: 123 #0b1010_0111_0100_1010_1110 #支持二进制、八进制、十六进制
  null: ~ #使用~表示null #注意:使用null这个属性名之后会报错，错误信息是[main] ERROR 
          #org.springframework.boot.SpringApplication - Application run failed
          #java.lang.NullPointerException: null
  string: HelloWorld #字符串可以直接书写
  string2: "Hello World" #可以使用双引号包裹特殊字符
  date: 2018-02-17 #日期必须使用yyyy-MM-dd格式
  datetime: 2018-02-17T15:02:31+08:00 #时间和日期之间使用T连接，最后使用+代表时区
  ```

* 数组表示方式:在属性名书写位置的下方使用减号作为数据开始符号，每行书写一个数据，减号与数据间空格分隔

  ```yaml
  subject: #自身是数组
    - Java
    - 前端
    - 大数据
  enterprise: #属性是数组
    name: yeyu
    age: 16
    subjects:
      - Java
      - 前端
      - 大数据
  likes: [王者荣耀,刺激战场] #数组书写缩略格式
  ```

  ```yaml
  users1: #对象数组格式
    - name: Tom
      age: 4
    - name: Jerry
      age: 5
  users2: #对象数组格式二
    -
      name: Tom
      age: 4
    -
      name: Jerry
      age: 5 
  users3: [ { name:Tom , age:4 } , { name:Jerry , age:5 } ] #对象数组缩略格式
  ```

### 4.yaml数据读取

* 使用@Value配合SpEL读取单个数据，属性名引用方式：${属性名}

* 如果数据存在多层级，依次书写层级名称即可$，属性名引用方式：{一级属性名.二级属性名……}

  * application.yml中的内容:

    ```yaml
    lesson: SpringBoot
    
    server:
      port: 8081
      
    enterprise:
      name: yeyu
      age: 16
      tel: 4006184000
      subject:
        - java
        - cpp
        - python
    ```

  * 控制器类中的内容:

    ```java
    @RestController
    @RequestMapping("/index")
    public class HelloController {
        @Value("${lesson}")
        private String lessonName;
        
        @Value("${server.port}")
        private int port;
        
        @Value("${enterprise.subject[1]}")
        private String subject;
        
        @GetMapping
        public String getById() {
            System.out.println(lessonName+port+subject);
            return "springboot is running...";
        }
    }
    ```

* 在配置文件中可以使用属性名引用方式引用属性

  application.yml中的内容:

  ```yaml
  baseDir: /usr/local/fire
  center:
    dataDir: ${baseDir}/data
    tmpDir: ${baseDir}/tmp
    logDir: ${baseDir}/log
    msgDir: ${baseDir}/msgDir
  ```

* 如果属性中出现特殊字符，可以使用双引号包裹起来作为字符解析

  application.yml中的内容:

  ```yaml
  lesson1: "Spring\tboot\nlesson"
  lesson2: Spring\tboot\nlesson
  ```

  运行之后的输出结果:

  ![image-20211118175520147](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211118175520147.png)

* 封装全部数据到Environment对象

  步骤:

  1. 使用Environment对象封装全部配置信息
  2. 使用@Autowired自动装配数据到Environment对象中
  3. 使用Environment对象的getProperty(String key)方法获取配置信息

  * application.yml中的内容:

    ````yaml
    lesson: SpringBoot
    
    server:
      port: 8081
      
    enterprise:
      name: yeyu
      age: 16
      tel: 4006184000
      subject:
        - java
        - cpp
        - python
    ````

  * 控制器类中的内容:

    ```java
    @RestController
    @RequestMapping("/index")
    public class HelloController {
        @Autowired
        private Environment environment;
        @GetMapping
        public String getById() {
            System.out.println(environment.getProperty("lesson"));
            System.out.println(environment.getProperty("enterprise.name"));
            System.out.println(environment.getProperty("enterprise.subject[0]"));
            return "springboot is running...";
        }
    }
    ```

* 自定义对象封装指定数据

   步骤:

  1. 使用@ConfigurationProperties注解绑定配置信息到封装类中
  2. 需要获取的属性要加上get()和set()方法，而且封装类属性的名字要与绑定的配置信息的属性名一致，这样才能能获取到对应的属性值
  3. 封装类需要定义为Spring管理的bean，否则无法进行属性注入

  * application.yml中的内容:

  ```yaml
  enterprise:
    name: yeyu
    age: 16
    tel: 4006184000
    subject:
      - java
      - cpp
      - python
  ```

  * 封装类中的内容:

  ```java
  @Component
  @ConfigurationProperties(prefix = "enterprise")
  public class Enterprise {
      private String name;
      private String age;
      private String tel;
      private String[] subject;
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public String getAge() {
          return age;
      }
  
      public void setAge(String age) {
          this.age = age;
      }
  
      public String getTel() {
          return tel;
      }
  
      public void setTel(String tel) {
          this.tel = tel;
      }
  
      public String[] getSubject() {
          return subject;
      }
  
      public void setSubject(String[] subject) {
          this.subject = subject;
      }
  
      @Override
      public String toString() {
          return "bean{" +
                  "name='" + name + '\'' +
                  ", age='" + age + '\'' +
                  ", tel='" + tel + '\'' +
                  ", subject=" + Arrays.toString(subject) +
                  '}';
      }
  }
  ```

  * 控制器类中的内容:

  ```java
  @RestController
  @RequestMapping("/index")
  public class HelloController {
      @Autowired
      private Enterprise enterprise;
      @GetMapping
      public String getById() {
          System.out.println(enterprise.toString());
          return "springboot is running...";
      }
  }
  ```

  作用:在SpringBoot程序中已经定义好了诸如DataSource的封装类，我们只需要在application.yml中配置它们的配置信息即可改变类的信息。

  ![image-20211118200232438](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211118200232438.png)

## 三.SpringBoot整合第三方技术

### 1.整合JUnit

1. 导入测试对应的starter(创建初始SpringBoot项目时自动导入)

   ```xml
     <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-test</artifactId>
               <scope>test</scope>
     </dependency>
   ```

2. 测试类使用@SpringBootTest修饰

   * 名称：@SpringBootTest

   * 类型：测试类注解

   * 位置：测试类定义上方

   * 作用：设置JUnit加载的SpringBoot启动类
   * 相关属性:
     * classes：设置SpringBoot启动类
     * 注意:**如果测试类在SpringBoot启动类的包或子包中，可以省略classes的设定，无需指定引导类，若测试类不存在于引导类所在的包或子包中则需要通过classes属性指定引导类**

3. 使用自动装配的形式添加要测试的对象

   ```java
   @SpringBootTest
   class SpringBoot2Day1ApplicationTests {
       @Autowired
       private BookService bookService;
       @Test
       void contextLoads() {
           bookService.test();
       }
   }
   ```

### 2.整合MyBatis

* 核心配置：数据库连接相关信息(连什么？连谁？什么权限)

* 映射配置：SQL映射(XML/注解)

步骤:

1. 创建新模块，选择Spring初始化，并配置模块相关基础信息

   ![image-20211118204710824](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211118204710824.png)

2. 选择当前模块需要使用的技术集(MyBatis和MySQL），也就是导入MyBatis和MySQL对应的starter

   ![image-20211118204813399](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211118204815454.png)

3. 修改配置文件后缀名为.yml，并在配置文件中设置数据源参数(数据库连接相关信息转换成配置)

   ```yaml
   spring:
     datasource:
       driver-class-name: com.mysql.cj.jdbc.Driver
       url: jdbc:mysql://localhost:3306/ssm_db?serverTimezone=UTC
       username: root
       password: xxxxxx
   ```

4. 定义数据层接口与映射配置，数据库SQL映射需要添加@Mapper被容器识别到，产生自动代理的对象

   ```java
   @Repository
   @Mapper
   public interface BookDao {
       @Select("select * from tbl_book where id = #{id}")
       public Book getById(Integer id);
   }
   ```

5. 测试类中注入dao接口，测试功能

   ```java
   @SpringBootTest
   class SpringBoot2Day3ApplicationTests {
       @Autowired
       private BookDao bookDao;
       @Test
       void contextLoads() {
           Book book = bookDao.getById(5);
           System.out.println(book);
       }
   }
   ```

### 3.整合MyBatis-Plus

MyBatis-Plus与MyBatis区别

* 导入坐标不同

* 数据层实现简化

步骤:

1. 创建新模块，选择Spring初始化，并配置模块相关基础信息

![image-20211118204710824](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211118204710824.png)

2. 选择当前模块需要使用的技术集，只需要选择MySQL驱动，不需要导入Mybatis-Plus技术集(因为官网中没有收录Mybatis-Plus的技术集，只有阿里云中包括了Mybatis-Plus的技术集)

![image-20211118212636042](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211118212636042.png)

3. 手动添加SpringBoot整合MyBatis-Plus的坐标，可以通过mvnrepository获取，由于SpringBoot中未收录MyBatis-Plus的坐标版本，需要指定对应的Version

   ```xml
   <dependency> 
       <groupId>com.baomidou</groupId> 
       <artifactId>mybatis-plus-boot-starter</artifactId> 
       <version>3.4.3</version>
   </dependency>
   ```

4. 修改配置文件后缀名为.yml，并在配置文件中设置数据源参数(数据库连接相关信息转换成配置)，并设置Mybatis-Plus相关的配置

   ```yaml
   spring:
     datasource:
       driver-class-name: com.mysql.cj.jdbc.Driver
       url: jdbc:mysql://localhost:3306/ssm_db?serverTimezone=UTC
       username: root
       password: xxxxxx
   #设置Mybatis-Plus相关的配置
   mybatis-plus:
     global-config:
       db-config:
         table-prefix: tbl_
   ```

5. 定义数据层接口与映射配置，继承BaseMapper

   ```java
   @Repository
   @Mapper
   public interface BookDao extends BaseMapper<Book> {
   }
   ```

   6. 测试类中注入dao接口，测试功能

      ```java
      @SpringBootTest
      class SpringBoot2Day4ApplicationTests {
          @Autowired
          private BookDao bookDao;
          @Test
          void contextLoads() {
              Book book = bookDao.getById(5);
              System.out.println(book);
          }
      }
      ```

### 4.整合Druid

步骤:

1. 与整合MyBatis步骤基本相同

2. 额外工作:

   * 导入Druid对应的starter

     ```xml
     <dependency> 
         <groupId>com.alibaba</groupId> 
         <artifactId>druid-spring-boot-starter</artifactId> 
         <version>1.2.6</version>
     </dependency>
     ```

   * 变更Druid的配置方式

     * 通用的数据库连接池的配置

       ```yaml
       spring:
         datasource:
           driver-class-name: com.mysql.cj.jdbc.Driver
           url: jdbc:mysql://localhost:3306/ssm_db?serverTimezone=UTC
           username: root
           password: xxxxxx
           type: com.alibaba.druid.pool.DruidDataSource
       ```

     * Durid特有的数据库连接池的配置

       ```yaml
       spring:
         datasource:
           druid:
             driver-class-name: com.mysql.cj.jdbc.Driver
             url: jdbc:mysql://localhost:3306/ssm_db?serverTimezone=UTC
             username: root
             password: xxxxxx
       ```

### 5.整合任意第三方技术

* 导入对应的starter

* 根据提供的配置格式，配置非默认值对应的配置项，或直接采用默认配置

## 四.基于SpringBoot的SSMP整合案例





