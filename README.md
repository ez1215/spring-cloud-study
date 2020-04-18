# spring-cloud-study

## 前言

　　`spring-cloud-study`项目是一个spring cloud 学习demo。

## 项目介绍

　　基于Spring Cloud + Mybatis Plus +Seata分布式事务架构

### 组织结构

```
spring-cloud-study
├── cloud-common -- 定义了公共类
├── cloud-config -- spring cloud config的配置管理
├── cloud-eureka -- 服务注册中心
├── cloud-gateway -- 网关
├── cloud-goods -- 商品模块，提供商品相关内容，如库存
├── cloud-order -- 订单模块，用于下单
├── cloud-pay -- 支付模块
├── cloud-search -- 搜索（暂时没实现）
├── cloud-user -- 用户模块 
├── Script -- Mysql脚本
```

#### 技术选型:
技术 | 名称 | 官网
----|------|----
Spring Cloud | 框架  | [https://spring.io/projects/spring-cloud](https://spring.io/projects/spring-cloud)
Seata | 分布式事务框架  | [http://seata.io](http://seata.io)
MyBatis Plus| ORM框架  | [https://mp.baomidou.com/](https://mp.baomidou.com/)
Zipkin | 分布式链路跟踪  | [https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/](https://dl.bintray.com/openzipkin/maven/io/zipkin/java/zipkin-server/)
sc-config | 配置仓库  | [https://github.com/ez1215/sc-config](https://github.com/ez1215/sc-config)


#### 开发工具:
- MySql: 数据库
- IntelliJ IDEA: 开发IDE

#### 开发环境：
- Jdk8
- Mysql8.0.18
