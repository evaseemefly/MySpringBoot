# 我的springboot项目

## 目录结构

目录结构如下所示
com.example.myproject 目录下：

Application.java，建议放到根目录下面，是项目的启动类，  
Spring Boot 项目只能有一个 main() 方法；  
```aidl
myproject
 +-src
    +- main
         +- java
              +- com.example.myproject
                    +- comm             <= 目录建议放置公共的类，如全局的配置文件、工具类等
                    +- model            <=目录主要用于实体（Entity）与数据访问层（Repository）
                    +- repository       <=层主要是数据库访问层代码
                    +- service          <=层主要是业务类代码
                    +- web              <=层负责页面访问控制
                    +- Application.java
         +- resources
              +- mybatis
                    +- mybatis          <= 
                        +-mybatis-config.xml    <= mybatis的公共属性配置，主要是为java类型设置一个短名称。
              +- static
              +- templates
              +- application.properties <= 一些配置放在此处 
    +- test
 +-pom.xml
```
