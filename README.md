### xs-rancher
x-rancher api for rancher2.1

#### Links
- [spring api](https://docs.spring.io/spring/docs/current/javadoc-api/)
- [spring github](https://github.com/spring-projects/spring-boot)
- [spring tutorial](https://www.baeldung.com)
- [spring example](https://github.com/yidao620c/SpringBootBucket)
- [java code example](https://www.programcreek.com)

#### RestClient https
- 异常：javax.net.ssl.SSLException: Received fatal alert: protocol_version
    - Application: System.setProperty("https.protocols", "TLSv1.2") 或 System.setProperty("jdk.tls.client.protocols", "TLSv1.2")
    - VM参数: -Dhttps.protocols=TLSv1.2 或 -Djdk.tls.client.protocols=TLSv1.2
    - 在SSl构建工厂类中将允许的都添加至列表中
    
#### Debug https连接
Application: System.setProperty("javax.net.debug", "all")

