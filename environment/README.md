# environment
## 介绍
该目录下存放和环境相关的配置文件，在部署环境时，根据执行gradle initEnv时指定的env环境参数，决定会将哪些环境下的配置文件拷贝到resource/properties目录下作为项目部署文件
 
 ```shell
  # ./gradlew initEnv -Penv=xx
 ```
环境初始化时可以指定env, test，prod，分别表示，开发环境，测试环境和生产环境
 
* env.properties：本地环境配置，在部署时覆盖resource/properties目录下env.properties文件
* jdbc.properties：jdbc数据库配置，在部署时覆盖resource/properties目录下jdbc.properties文件

### 我们强烈建议你在配置环境时按照如下规则：
* 和环境无关的通用配置放到resource/properties/common.properties里
* 和环境相关的配置放到本目录下对应环境的env.properties里
* 如果有自己定义的配置文件，也按照上述规则操作
