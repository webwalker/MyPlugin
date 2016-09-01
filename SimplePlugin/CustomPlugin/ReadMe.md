resources\META-INF.gradle-plugins目录设定的webwalker.properties文件名为之后apply plugin 'webwalker'时使用，
两者一致，指向对应的插件名称

编译发布：
gradle uploadArchives

测试运行：
gradle customTask
gradle customTask1
gradle customTask2

note:保留groovy目录、Java目录位置