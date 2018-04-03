测试
===============================

## 单元测试
安装Junit GeneratorV2.0插件，然后在要添加单元测试的方法上右键，选择Generate->Junit Test-> V4，自动生成单元测试代码，默认代码生成在src/java/test包下，我们需要修改这个路径，Preference -> Other Settings，自己指定下路径即可。

## 执行测试
```
./gradlew test
```
如果测试失败的话，会在目录下生成测试报告：SRC_ROOT/build/reports/tests/test/index.html
