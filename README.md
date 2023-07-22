@[TOC]
# openFeign
- 使用openFeign在进行json数据参数传送时要注意添加@RequestBody。

否则报错:Json格式数据key必须用双引号。
- json 解析需要有无参构造器![在这里插入图片描述](https://img-blog.csdnimg.cn/137061345720498aa647e1da7846ac75.png)
# spring
[transactional 不生效的情景](https://blog.csdn.net/duan196_118/article/details/105534351)
# nacos
![在这里插入图片描述](https://img-blog.csdnimg.cn/e75aa64e4bab490389da1ca20cbcc5dd.png)

若服务无法注册到nacos 则说明因引入

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```


