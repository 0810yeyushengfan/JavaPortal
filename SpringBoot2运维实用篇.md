# SpringBoot2运维实用篇

## 一.打包与运行

### 1.程序为什么要打包?

因为如果只是在idea中运行我们的程序的话，一旦idea关闭，程序所对应的网址就无法访问了，不符合用户能够随时访问程序的需求，而SpringBoot工程可以基于java环境下独立运行jar文件启动服务，因此需要将程序打包成jar文件后放在服务器中运行，只要服务器不停止，网址就可以一直访问。

### 2.程序打包与运行(Windows版)

#### 1.步骤

1. 对项目打包(执行Maven构建指令package)

   ![image-20211120214817861](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211120214817861.png)

2. 找到打包好的程序jar包

   ![image-20211120214941840](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211120214941840.png)

3. 在cmd中运行程序(执行启动指令)

   启动指令为java –jar 工程名.jar

   ![image-20211120215233891](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211120215233891.png)

#### 2.注意事项

(1).jar支持命令行启动需要依赖maven插件支持，请确认打包时是否具有SpringBoot对应的maven插件

```xml
<build> 
    <plugins> 
        <plugin> 
            <groupId>org.springframework.boot</groupId> 
            <artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
	</plugins>
</build>
```

如果没有此插件，在执行打包命令时就会报错。

![image-20211120220109852](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211120220109852.png)

原因是普通工程和基于spring-boot-maven-plugin打包的工程的jar包中的文件组成有着本质区别，在j两个工程的jar包的META-INF的目录下，都有一个MANIFEST.MF的文件，打开它观察区别。

这是普通工程的文件内容:

```
Manifest-Version: 1.0
Implementation-Title: SpringBoot2_ssmp
Implementation-Version: 0.0.1-SNAPSHOT
Build-Jdk-Spec: 1.8
Created-By: Maven Jar Plugin 3.2.0
```

这是基于spring-boot-maven-plugin打包的工程的文件内容:

```
Manifest-Version: 1.0
Spring-Boot-Classpath-Index: BOOT-INF/classpath.idx
Implementation-Title: SpringBoot2_ssmp
Implementation-Version: 0.0.1-SNAPSHOT
Spring-Boot-Layers-Index: BOOT-INF/layers.idx
Start-Class: com.yeyu.springboot2_ssmp.SpringBoot2SsmpApplication
Spring-Boot-Classes: BOOT-INF/classes/
Spring-Boot-Lib: BOOT-INF/lib/
Build-Jdk-Spec: 1.8
Spring-Boot-Version: 2.5.7
Created-By: Maven Jar Plugin 3.2.0
Main-Class: org.springframework.boot.loader.JarLauncher
```

普通工程的文件内容中缺少了两个关键的关键的语句:

Main-Class: org.springframework.boot.loader.JarLauncher===>SpringBoot项目的主启动类，执行之后会调用程序的启动类

Start-Class: com.yeyu.springboot2_ssmp.SpringBoot2SsmpApplication===>IDEA工程中自己定义的启动类名

而且基于spring-boot-maven-plugin打包的工程还比普通工程多了两个目录。

![image-20211120231933527](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211120231933527.png)

分别是org目录和lib目录，org目录中包含了SpringBoot对应的一些设定的要求，上面刚刚提到的SpringBoot项目的主启动类JarLauncher就在这里，lib目录下包含了SpringBoot项目所需要的所有依赖的jar包。所以SpringBoot程序能够独立的运行依赖于把所有的程序都放在classes目录中，所有的依赖都放在lib中，把独立运行SpringBoot的工具都放在org目录下。而支持SpringBoot运行的核心是MANIFEST.MF文件。

(2).Windonws端口被占用

如果我们指定运行SpringBoot程序的端口被占用，运行SpringBoot程序时就会报错，此处以80端口为例。

![image-20211120220531932](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211120220531932.png)

此时我们要执行netstat -ano命令查询端口，由于这个命令是查询所有端口，输出的信息过多，不方便我们查找，因此也可以使用netstat -ano | findstr "端口号"来查询指定端口。

![image-20211120220812281](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211120220812281.png)

我们查找到80端口被进程号PID为37128的进程占用，我们可以使用taskkill /F /PID "进程PID号"直接杀死该进程，也可以通过tasklist |findstr "进程PID号"查询到任务名称后，执行taskkill -f -t -im "任务名称"杀死该任务，两者的区别是一个任务不一定只占用一个端口号，前者只是释放了一个端口号，后者是释放了占用该端口号的任务所占用的所有端口号。此处以taskkill /F /PID "进程PID号"直接杀死该进程为例(推荐使用这种方法，更加安全)。

![image-20211120221842145](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211120221842145.png)

此时程序就能够正常运行了。

![image-20211120221913348](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211120221913348.png)

(3).运行项目时会自动执行测试功能

如果我们想跳过这个测试功能的执行，可以执行下面的操作。

![image-20211120223359092](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211120223359092.png)

点击之后我们看到项目生命周期中的test已经被划去，这就证明测试功能已经被跳过。

![image-20211120223534242](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211120223534242.png)



### 3.程序运行(Linux版)

* 基于Linux(Ubuntu20.04) 

* 安装JDK，且版本不低于打包时使用的JDK版本(我安装的jdk8)

* 安装包保存在/usr/local/自定义目录中或$HOME下 

* 其他操作参照Windows版进行

  * 上传安装包

    ![image-20211121122724260](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121122724260.png)

  * 执行jar命令:java –jar 工程名.jar

    ![image-20211121122829227](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121122829227.png)

    这里我踩了一个坑，因为我们的项目访问的是80端口，而Liunx系统规定1024及以下的端口普通用户是不能访问的，因此只有用root用户才能正常运行此项目，当我们用普通用户试图运行此项目时，会出现以下错误。

    ![image-20211121123351065](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121123351065.png)

    还可以执行nohup java -jar 工程名.jar > server.log 2>&1 &命令在后台运行该工程，并将产生的日志放在server.log文件下。

    ![image-20211121200916100](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121200916100.png)

    它将会返回给你该项目的进程PID号。

    你可以通过执行cat server.log命令展示该工程产生的日志信息。

    ![image-20211121201056324](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121201056324.png)

    也可以通过kill -9 进程PID号终止该工程，并通过ps -ef | gerp "java -jar"命令查看该工程是否真正终止。

    ![image-20211121201301319](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121201301319.png)

### 4.Linux运行环境的配置

#### 1.JDK的安装

Java JDK在Linux系统中有两个版本，一个是开源版本Openjdk，还有一个是oracle官方版本jdk，此处我们以安装Openjdk为例。

(1).更新软件包列表:

```shell
sudo apt-get update
```

(2).安装openjdk-8-jdk:

```shell
sudo apt-get install openjdk-8-jdk
```

(3).查看java版本，看看是否安装成功:

```shell
java -version
```

如果出现下面的语句，证明安装成功:

![image-20211121142923908](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121142923908.png)

本部分主要借鉴于[这篇博客](https://blog.csdn.net/zbj18314469395/article/details/86064849)

#### 2.MySQL的安装

本部分主要借鉴于[这篇博客](https://blog.csdn.net/weixin_44129085/article/details/104481986)

由于已经安装过一次了，不能再演示一遍，直接看这个图文结合的博客就行了

#### 3.建立本地与MySQL的连接

本部分主要借鉴于[这篇博客](https://blog.csdn.net/weixin_42361018/article/details/116731575)

原因同上，不再演示。

但是注意在运行之前需要先将SpringBoot项目中的application.yml文件中有关数据库连接的内容进行修改

```yaml
server:
  port: 80
spring:
  datasource:
    druid:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://47.94.15.150:3306/ssm_db?serverTimezone=UTC
      username: root
      password: root
mybatis-plus:
  global-config:
    db-config:
      table-prefix: tbl_
      id-type: auto
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

并且用数据库连接工具在Linux的MySQL数据库中执行下列SQL语句插入数据

```mysql
CREATE TABLE tbl_book(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
type VARCHAR(20),
name VARCHAR(50),
description VARCHAR(255));

INSERT INTO tbl_book
VALUES (1,"计算机理论","Spring实战 第5版","Spring入门经典教程，深入理解Spring原理技术内幕");
INSERT INTO tbl_book
VALUES (2,"计算机理论","Spring实战 5核心原理与30个类手写实战","十年沉淀之作，手写Spring精华思想");
INSERT INTO tbl_book
VALUES (3,"计算机理论","Spring 5 设计模式","深入Spring源码剖析Spring源码中蕴含的10大设计模式");
INSERT INTO tbl_book
VALUES (4,"计算机理论","Spring MVC+Mybatis开发从入门到项目实战","全方位解析面向Web应用的轻量级框架，带你称为Spring MVC开发高手");
INSERT INTO tbl_book
VALUES (5,"计算机理论","轻量级Java Web企业应用实战","源码级剖析Spring框架，适合已掌握Java基础的读者");
INSERT INTO tbl_book
VALUES (6,"计算机理论","Java核心技术 卷I 基础知识(原书第11版)","Core Java第11版，Jolt大奖获奖作品，针对Java SE9、10、11全面更新");
INSERT INTO tbl_book
VALUES (7,"计算机理论","深入理解Java虚拟机","5个维度全面剖析JVM，大厂面试知识点全覆盖");
INSERT INTO tbl_book
VALUES (8,"计算机理论","Java编程思想(第4版)","Java学习必读经典，殿堂级著作!赢得了全球程序员的广泛赞誉");
INSERT INTO tbl_book
VALUES (9,"计算机理论","零基础学Java(全彩版)","零基础自学编程的入门图书，由浅入深，详解Java语言的编程思想和核心技术");
INSERT INTO tbl_book
VALUES (10,"市场营销","直播就该这么做:主播沟通实战指南","李子柒、李佳琦、薇娅成长为网红的秘密都在书中");
INSERT INTO tbl_book
VALUES (11,"市场营销","直播销讲实战一本通","和秋叶一起学系列网络营销书籍");
INSERT INTO tbl_book
VALUES (12,"市场营销","直播带货:淘宝、天猫直播从新手到高手","一本教你如何玩转直播的书，10堂课轻松实现带货月入3W+");
```

## 二.配置高级

 ### 1.临时属性设置

#### 1.运行环境

* 使用jar命令启动SpringBoot工程时可以使用临时属性替换配置文件中的属性

* 临时属性添加方式：java –jar 工程名.jar –-属性名=值

  如果我们想在8081端口运行该程序，只需要执行如下语句，要注意一点，此时需要写的属性名不再是我们在application.yml文件下写的那个格式，而是应该写在一开始学习的时候写的application.properties里面的那个格式。

  ```shell
  java -jar SpringBoot2_ssmp-0.0.1-SNAPSHOT.jar --server.port=8081
  ```

  我们看到，此时项目的端口就被临时改为了之前我们设置的8081

  ![image-20211121180328726](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121180328726.png)

* 多个临时属性之间使用空格分隔

  执行如下面所示形式的代码就能使用多个临时属性

  ```shell
  java -jar SpringBoot2_ssmp-0.0.1-SNAPSHOT.jar --server.port=8081 --spring.datasource.druid.password=root
  ```

* 临时属性必须是当前SpringBoot工程支持的属性，否则设置无效

#### 2.开发环境

##### (1).命令带参数

带属性启动SpringBoot程序，为程序添加运行属性。

![image-20211121182142091](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121182142091.png)

这个操作的本质就是在图形化界面为SpringBoot项目的启动类即SpringBoot2SsmpApplication类的main方法中的args参数赋值，转化成通过编程形式带参数启动SpringBoot程序，并为程序添加运行参数。当然你也可以直接用命令行为SpringBoot程序的args参数赋值，传递启动属性。

![image-20211121202604934](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121202604934.png)

##### (2).编程带参数

启动SpringBoot程序时，可以选择是否使用命令行属性为SpringBoot程序传递启动属性。

通过编程形式带参数启动SpringBoot程序，为程序添加运行参数。

修改SpringBoot2SsmpApplication中的代码

```java
@SpringBootApplication
public class SpringBoot2SsmpApplication {
    public static void main(String[] args) {
        String[] arg = new String[1];
        arg[0] = "--server.port=8080";
        SpringApplication.run(SpringBoot2SsmpApplication.class, arg);
    }
}
```

在真正运行的时候，我们可能要阻止用户使用临时参数覆盖SpringBoot程序的配置，选择不携带参数启动SpringBoot程序，断开读取外部参数的入口，提高程序的安全性。

修改SpringBoot2SsmpApplication中的代码

```java
@SpringBootApplication
public class SpringBoot2SsmpApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2SsmpApplication.class);
    }
}
```

#### 3.原因

查看[官网文档的属性加载优先顺序部分]([Core Features (spring.io)](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config))

![image-20211121181212918](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121181212918.png)

由图知，我们在项目中配置的属性位于第3点，在命令行中追加的参数位于第11点，后者的优先级高于前者，所以能够采用命令行追加参数的形式给项目设置临时属性

### 2.配置文件分类

#### 1.配置文件分类 

* 1级:工程路径config目录中配置文件**[最高]**:常用于运维经理整体调控，例如file:config/application.yml
* 2级:工程路径配置文件:常用于运维人员配置涉密线上环境，例如file:application.yml
* 3级:项目类路径config目录中配置文件:常用于项目经理整体调控，例如classpath:config/application.yml
* 4级:项目类路径配置文件**[最低]**:常用于开发人员本机开发与测试，例如classpath:application.yml

工程路径文件指的是与项目文件夹或者项目打包后的jar包同级的文件，工程路径config目录中文件指的是与项目文件夹或者项目打包后的jar包同级的config目录之下的文件，注意只要工程路径配置文件/工程路径config目录和项目文件夹或者项目打包后的jar包同级，这俩文件/文件夹不论在哪个位置存储，即使存储的文件夹中的内容只有他俩，也是能够正常生效的。

#### 2.作用

* 多层级配置文件间的属性采用叠加并覆盖的形式作用于程序
* 1级与2级留做系统打包后设置通用属性，1级常用于运维经理进行线上整体项目部署方案调控
* 3级与4级用于系统开发阶段设置通用属性，3级常用于项目经理进行整体项目属性调控

### 3.自定义配置文件

#### 1.方法

* 通过启动参数加载配置文件(无需书写配置文件扩展名)

  填写--spring.config.name=自定义配置文件名后，重启项目即可成功加载自定义配置文件，不需要写出配置文件拓展名，properties与yml文件格式均支持。

  ![image-20211121220406110](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121220406110.png)

* 通过启动参数加载指定文件路径下的配置文件

  填写--spring.config.location=自定义配置文件的位置后(可以使用classpath:代表项目类路径)，重启项目即可成功加载自定义配置文件，需要写出配置文件拓展名，properties与yml文件格式均支持。

  ![image-20211121220517657](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121220517657.png)

* 通过启动参数加载指定文件路径下的配置文件时可以加载多个配置

  可以通过,(逗号)将多个配置文件的文件路径隔开来加载多个配置，当多个配置文件配置了相同属性的时候，后配置的即在启动参数指定文件路径的后面的文件覆盖先配置的即在启动参数指定文件路径的前面的文件，配置了不同属性则都保留。

  ![image-20211121221534523](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121221534523.png)

  注意:多配置文件常用于将配置进行分类，进行独立管理，或将可选配置单独制作便于上线更新维护

#### 2.说明

* 单服务器项目：使用自定义配置文件需求较低

* 多服务器项目：使用自定义配置文件需求较高，将所有配置放置在一个目录中，统一管理

* 基于SpringCloud技术，所有的服务器将不再设置配置文件，而是通过配置中心进行设定，动态加载配置信息

## 三.多环境开发

### 1.多环境开发(YAML版)

#### 1.单配置文件格式

* 多环境开发需要设置若干种常用环境，例如开发、生产、测试环境

  适用于下图的场景中:

  ![image-20211121230821792](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211121230821792.png)

* yaml格式中设置多环境使用---区分环境设置边界

* 每种环境的区别在于加载的配置属性不同

* 启用某种环境时需要指定启动时使用该环境

*  主配置文件中设置公共配置(全局)

* 环境分类配置文件中常用于设置冲突属性(局部)

```yaml
#启动指定环境
spring:
  profiles:
    active: pro
#三个环境通用的配置设定写在这里
---
#设置生产环境
spring:
  profiles: pro
#生产环境具体参数设定
server:
  port: 80
---
#设置开发环境
spring:
  profiles: dev
#生产环境具体参数设定
server:
  port: 81
---
#设置测试环境
spring:
  profiles: test
#测试环境具体参数设定
server:
  port: 82
```

上面的设置环境的格式已经过时，推荐使用下面的格式

```yaml
#启动指定环境
spring:
  profiles:
    active: pro
#三个环境通用的配置设定写在这里
---
#设置生产环境
spring:
  config:
    activate:
      on-profile: pro
#生产环境具体参数设定
server:
  port: 80
```

#### 2.多配置文件格式

![image-20211122100401891](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211122100401891.png)

把多个环境的配置都写在一个配置文件中会暴露配置的具体信息，可以使用多配置文件的格式解决这个问题。

* 可以使用独立配置文件定义环境属性

* 独立配置文件便于线上系统维护更新并保障系统安全性

(1).主启动配置文件application.yml

```yaml
spring:
  profiles:
    active: dev
```

(2).环境分类配置文件application-dev.yml

```yaml
server:
  port: 81
```

(3).环境分类配置文件application-pro.yml

```yaml
server:
  port: 82
```

(4).环境分类配置文件application-test.yml

```yaml
server:
  port: 83
```

**注意:环境分类配置文件的名称必须是application-环境名称.yml**

#### 3.多配置文件格式拆分版

* 根据功能对配置文件中的信息进行拆分，并制作成独立的配置文件，命名规则如下
  * application-devDB.yml
  * application-devRedis.yml
  * application-devMVC.yml

* 使用include属性在激活指定环境的情况下，同时对多个环境进行加载使其生效，多个环境间使用逗号分隔

* 当主环境dev与其他环境有相同属性时，主环境属性生效(即主环境dev默认是最后加载的)；其他环境中有相同属性时，最后加载的环境(即最后配置的环境)属性生效

  ```yaml
  spring:
    profiles:
      active: dev
      include: devDB,devRedis,devMVC
  ```

* 从Spring2.4版开始使用group属性替代include属性，降低了配置书写量

* 使用group属性定义多种主环境与子环境的包含关系

* 多环境开发使用group属性设置配置文件分组，便于线上维护管理

* 当主环境dev与其他环境有相同属性时，其他环境属性生效(即主环境dev默认是最先加载的)；其他环境中有相同属性时，最后加载的环境(即最后配置的环境)属性生效

  ```yaml
  spring:
    profiles:
      active: dev
      group:
        "dev": devDB,devRedis,devMVC
        "pro": proDB,proRedis,proMVC
        "test": testDB,testRedis,testMVC
  ```

### 2.多环境开发(Properties版)

properties文件与yml文件不同，properties文件的多环境配置仅支持多文件格式。

(1).主启动配置文件application.properties

```properties
spring.profiles.active=dev
```

(2).环境分类配置文件application-dev.properties

```properties
server.port=81
```

(3).环境分类配置文件application-pro.properties

```properties
server.port=82
```

(4).环境分类配置文件application-test.properties

```properties
server.port=83
```

### 3.多环境开发控制

此处主要讨论Maven与SpringBoot多环境冲突现象的解决方案

#### 1.原则

* 当Maven与SpringBoot同时对多环境进行控制时，以Maven为主(因为SpringBoot项目依赖于Maven，没有Maven就不可以启动项目(在排除Gradle的前提下))，SpringBoot使用@..@占位符读取Maven对应的配置属性值
* 基于SpringBoot读取Maven配置属性的前提下，如果在IDEA下测试工程时，pom.xml的每次更新都需要手动compile才可以生效

#### 2.步骤

(1).Maven中设置多环境属性

```xml
<profiles>
    <profile>
        <id>dev_env</id>
        <properties>
            <profile.active>dev</profile.active>
        </properties>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
    </profile>
    <profile>
        <id>pro_env</id>
        <properties>
            <profile.active>pro</profile.active>
        </properties>
    </profile>
    <profile>
        <id>test_env</id>
        <properties>
            <profile.active>test</profile.active>
        </properties>
    </profile>
</profiles>
```

(2).SpringBoot中引用Maven属性

```yaml
spring:
  profiles:
    active: @profile.active@
```

(3).执行Maven打包指令，并在生成的boot打包文件.jar文件中查看对应信息

```yaml
spring:
  profiles:
    active: dev
```

## 四.日志

### 1.日志基础

#### 1.日志(log)作用

* 编程期调试代码

* 运营期记录信息
  * 记录日常运营重要信息(峰值流量、平均响应时长……
  * 记录应用报错信息(错误堆栈)
  * 记录运维过程数据(扩容、宕机、报警……)

#### 2.日志级别

* TRACE:运行堆栈信息，使用率低
* DEBUG:程序员调试代码使用
* INFO:记录运维过程数据
* WARN:记录运维过程报警数据
* ERROR:记录错误堆栈信息
* FATAL:灾难信息如系统错误信息，出现和记录次数极少，一般IDE如IDEA都会把它合并计入ERROR

#### 3.代码中使用日志工具记录日志

##### (1).添加日志记录操作

```java
@RestController
@RequestMapping("/books")
public class BookController {
    //需要引入org.slf4j.Logger而不是java.util.logging.Logger
    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    @GetMapping
    public void getAll() {
        log.debug("debug ...");
        log.info("info ...");
        log.warn("warn ...");
        log.error("error ...");
        System.out.println("SpringBoot2 is running!");
    }
}
```

##### (2).设置日志输出级别

既可以通过命令行进行设置

![image-20211122111455043](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211122111455043.png)

也可以通过配置文件进行设置

```yaml
# 开启debug模式，输出调试信息，常用于检查系统运行状况
debug: true
# 设置日志级别，root表示根节点，即整体应用日志级别
logging:
  level:
    root: debug
```

##### (3).设置日志组

设置日志组控制指定包对应的日志输出级别，也可以直接控制指定包对应的日志输出级别

```yaml
logging:
  #设置日志组
  group:
    #自定义组名，设置当前组中所包含的包
    ebank: com.yeyu.springboot2_day_12.controller
  level:
    root: warn
  #为对应组设置日志级别
  ebank: debug
  #为对应包设置日志级别
  com.yeyu.springbooy2_day_12.controller: debug
```

#### 4.优化日志对象创建代码

使用lombok提供的注解@Slf4j简化开发，减少日志对象的声明操作

首先要在pom.xml中引入lombok依赖

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```

然后对想要添加日志对象的类使用@Slf4j注解即可，lombok会自动为这个类创建一个叫做log的日志对象

```java
@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {
    //需要引入org.slf4j.Logger而不是java.util.logging.Logger
    //private static final Logger log = LoggerFactory.getLogger(BookController.class);
    @GetMapping
    public void getAll() {
        log.debug("debug ...");
        log.info("info ...");
        log.warn("warn ...");
        log.error("error ...");
        System.out.println("SpringBoot2 is running!");
    }
}
```

#### 5.总结

* 日志用于记录开发调试与运维过程消息
* 日志的级别共6种，通常使用4种即可，分别是DEBUG，INFO，WARN，ERROR
* 可以通过日志组或代码包的形式进行日志显示级别的控制

### 2.日志输出格式控制

#### 1.日志输出格式

![image-20211122112729648](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211122112729648.png)

* PID:进程ID，用于表明当前操作所处的进程，当多服务同时记录日志时，该值可用于协助程序员调试程序

* 所属类/接口名:当前显示信息为SpringBoot重写后的信息，名称过长时简化包名书写为首字母，甚至直接删除

#### 2.日志输出格式设置规则

* 设置日志输出格式

  * %d：日期

  * %m：消息

  * %n：换行

  ```yaml
  logging:
  	pattern:
  		console: "%d - %m%n"
  ```

  日志中显示的信息:

  ![image-20211122113536638](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211122113536638.png)

* 模仿IDEA的日志输出格式

  * %clr{}:设置颜色，后面可以加一个字符串用来指定颜色，不加则使用默认颜色，cyan是青色
  * %p:日志级别
  * %t:所属线程名，前面加数字代表一共占用那么多位置，不足会用空格在线程名前面补全，超过则失效
  * %c:所属类/接口名，前面的-(减号)代表用来补全的空格从后面开始补全，.(点)表示最多只显示这个多位置
  
  ```yaml
  logging:
  	pattern:
  		console: "%d %clr(%p) --- [%16t] %clr(%-40.40c){cyan} : %m %n"
  ```
  
  日志中显示的信息:
  
  ![image-20211122113650492](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211122113650492.png)

### 3.日志文件

#### 1.日志记录到文件

这样原本只打印在控制台上的日志信息也会被发送到文件中，达到备份日志记录的目的，提高了运维维护项目的效率。

```yaml
#在服务器未停止时，只有日志文件到达一定多的数量时，才会发送到我们设置的位置即server.log文件内
logging:
  file:
    name: server.log
```

日志文件打印到哪里了呢?

![image-20211122124623133](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211122124623133.png)

日志文件就在这里。![image-20211122124704033](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211122124704033.png)

打开就能看到对应的日志记录。

![image-20211122124756132](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211122124756132.png)

#### 2.日志文件格式设置

为了解决日志记录一直积累在一个日志文件中，导致日志文件过大查阅日志记录困难的问题，能够对日志文件格式进行详细的设置，这里把它设成滚动日志的格式，当文件超过我们规定的大小时，就会再新建一个滚动日志文件，将日志记录放在新建的滚动日志文件中，以此类推，一直新建。

```yaml
logging:
  #日志文件也必须设定，因为一开始的日志记录都是先放在这里的，等超过指定大小才会剪切到滚动日志文件中
  file:
    name: server.log
  logback:
    rollingpolicy:
      #规定大小
      max-file-size: 3KB
      #规定文件名称
      #%d是日期，%i是滚动日志循环的变量
      file-name-pattern: server.%d{yyyy-MM-dd}.%i.log
```

寻找日志文件位置的操作同上

这就是刚刚生成的滚动日志。

![image-20211122125959999](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20211122125959999.png)