Openmore 基于SBM（SpringBoot+Mybatis）开源REST API服务
===============================
关于Openmore
------------
<p align="center">
    <a href="https://github.com/open-more" target="_blank">
        <img src="https://avatars0.githubusercontent.com/u/27731838?v=3&s=460" width="120" alt="Open More" />
    </a>
</p>
Openmore团队是目前北京的一家创业公司内里的几个主程自发组织的开源团队, 团队目标是将创业过程中技术团队遇到的技术经验进行开源分享, 本着更开放,更高效的原则帮助中国的移动开发者填坑,减少开发成本,同时吸收大家的意见与建议。

## 介绍
**springboot-template** 是基于SSM的J2EE项目快速开发脚手架，集成了最常用的框架,适用于`Restfull` 架构风格`Web Service`接口开发。

## 主要框架
* **SpringBoot2.0.0release**
* **thymeleaf**

## 工具框架
* **Spring-Test** 
* **Mybatis-Pagehelper5.0** 
* **Mybatis通用Mapper3** 
* **Druid1.1.9** 

## 开发工具
`Intellij Idea`
### 依赖管理工具
`Gradle`

## 使用
``` shell
# git clone https://gitee.com/openmore/springboot-template.git
```

## 接口安全（拦截器实现）
* 防止篡改，所有请求接口都带有sign签名，sign = md5(app_secret + nonce + method + uri + body(json) + timestamp)
* 防止重放攻击，Header里带有时间戳，超过时间差容忍范围(默认60秒)，拒绝访问
* 关键数据可加密，Header中encrypt=1时，接口数据进行AES128加密，隐藏明文发送数据
* Header里带有DEVICE_TOKEN，通过token来控制客户端访问，比如：互踢，拉黑机制。

Http Header请求参数如下：
* sign：签名（签名算法见下面）
* Content-Type：application/json
* timestamp：时间戳（秒）
* nonce：6位随机数
* app_key：App key
* encrypt：1表示内容加密，参数不存在或为其它值，表示内容不加密

## 签名算法
app_key表示分配给客户端的key，社个Key对应一个secret_key，签名时使用secret_key进行加密
```
sign = md5(secret_key + nonce + 请求方式（GET/PUT/POST/DELETE，必须大写）+ 请求接口URI（除域名后的URL） + body + timestamp)
```
### 例如：
```
GET http://api.openmore.org/user/123
secret_key = a92664b406ed5b18dd04cd59c6778519
nonce = 1A39CJ
timestamp = 1497723214
body = 空
拼接字符串为：a92664b406ed5b18dd04cd59c67785191A39CJGET/user/1231497723214
md5("a92664b406ed5b18dd04cd59c67785191A39CJGET/user/1231497723214") = 4E22D478672492EE8914E2314FE575AF 
```

## 快速开始
配置mysql数据库，修改`environment/dev/application.properties`文件。
```
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.driver=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://{YOUR_DB_URL}/{DB_NAME}?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8
spring.datasource.username={USER_NAME}
spring.datasource.password={PASSWORD}
```

配置redis数据库，修改`environment/dev/application.properties`文件。
```
# database name
spring.redis.database=0
# server host1
spring.redis.host=127.0.0.1
# server password
#spring.redis.password=
#connection port
spring.redis.port=6379
# pool settings ...
spring.redis.pool.max-idle=8
spring.redis.pool.min-idle=0
spring.redis.pool.max-active=8
spring.redis.pool.max-wait=-1
```
### 进入项目目录
```shell
# cd {PROJECT_ROOT}/
```
### 初始化环境为开发环境
```shell
# ./gradlew initEnv -Penv=dev
start initial environment
拷贝：environment/dev下的文件到src/main/resources/  DONE
:initEnv UP-TO-DATE
BUILD SUCCESSFUL
```

### 初始化数据库,将db/migration目录下sql迁移到本地数据库
```shell
# ./gradlew flywayMigrate
```

### 启动项目
```shell
# ./gradlew bootRun
```

### 通过MybatisGenerator根据DB表结构，生成Mapper文件和对应的entity
```shell
# ./gradlew mybatisGenerate
```
可以看到在dao包和entity包下出了自动生成的代码

## 关于分页
分页在所有的getAllByPageXX接口里，默认支持分页。
下面的例子请求分页数据：
```
GET http://localhost:9191/api/XXX/getAllByPage?page=1&pageSize=10
```
请求第1页，每页10条数据，每次请求后的response Body里包含有当前数据的分页信息pagination
##### Http Response Header
```
{
  "message": "ok",
  "code": 0,
  "data": [
    {
     ...
    }
  ],
  "pagination": {
    "page": 0,
    "limit": 0,
    "totalItem": 9,
    "totalPage": 0
  }
}
```
* page：当前第几页
* limit：每页多少条数据
* totalItem：共多少条数据
* totalPage：共多少页

## 查看在线restAPI文档
项目启动后，打开[http://localhost:9191/swagger-ui.html](http://localhost:9191/swagger-ui.html)即可查看api文档

## Druid查看SQL性能
项目启动后，打开[http://localhost:9191/druid/api.html](http://localhost:9191/druid/api.html)即可查看SQL性能，初始用户名和密码：root/123
如需修改：DruidStatViewServlet类里的配置


### 通过代码生成器生成DTO（POJO），Servcie， ServiceImpl，Controller及对应的文档
 * 浏览器打开[http://localhost:9191/dto/home](http://localhost:9191/dto/home)，进入Dto生成器界面
 * 输入包名，DTO的英文名，与DB Entity对应及DTO的中文和描述
 * 输入需要创建DTO的属性，type为Java的基本数据类型
 * 分别显示Show*按钮，查看生成的代码
 * 点击Create All Source，将代码自动生成在包名目录下

## 部署
### 启动项目，[http://locaohost:9191/](http://locaohost:9191/)
```shell
# ./gradlew build
```
### 调试启动
```shell
# ./gradlew bootRun
```

## 单元测试
安装Junit GeneratorV2.0插件，然后在要添加单元测试的方法上右键，选择Generate->Junit Test-> V4，自动生成单元测试代码，默认代码生成在src/java/test包下，我们需要修改这个路径，系统设置Other Settings，自己指定下路径即可。

## 执行测试
```
./gradlew test
```
如果测试失败的话，会在目录下生成测试报告：ssm-openmore-template/build/reports/tests/test/index.html

## 常见问题
* nested exception is org.apache.ibatis.type.TypeException: Could not set parameters for mapping
```
mybatis自动生成的Entity代码里没有通过@Id来注解出id主键字段来，导致在selectByPrimaryKey出错
解决方法：在id字段前加@Id注解 
```

问题
===============================

### org.springframework.beans.NotWritablePropertyException: Invalid property ‘mapperHelper’ of bean class
> 原因是：通用mapper不支持热部署，不支持devtool。
解决方法：在pom.xml屏蔽掉热部署就OK了。
## 执行测试
```
./gradlew test
```
如果测试失败的话，会在目录下生成测试报告：SRC_ROOT/build/reports/tests/test/index.html
