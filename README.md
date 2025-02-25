# 草莓大棚实时数据异常监测系统

![系统界面](/about/a.png "系统界面")

## 一、项目概述
草莓大棚实时数据异常监测系统是一个用于监测草莓大棚内 环境参数（如温度、湿
度、光照、CO2浓度等）的实时数据，并及时检测和报警异常情况的系统。该系统旨
在帮助种植户及时发现和处理环境异常，确保草莓的健康生长。

## 二、系统功能
数据采集：通过传感器实时采集大棚内的环境参数。
数据传输：将采集到的数据传输到后端服务器。
数据存储：将数据存储在数据库中，便于历史数据查询和分析。
异常检测：实时分析数据，检测异常情况并发出警报。
用户界面：提供直观的用户界面，展示实时数据和异常警报。
报警通知：通过短信或邮件通知种植户异常情况。

![系统功能模块](/about/h.png)

## 三、技术栈

![架构图](/about/g.png)

### 主要技术
前端：Vue.js  
后端：Spring Boot、MyBatis  
数据库：MySQL  
数据仓库：Hive、Hadoop  
传感器：温湿度传感器、光照传感器、CO2浓度传感器  
通信协议：MQTT  

### 术语定义
#### B/S:   
B/S结构（Browser/Server，浏览器/服务器模式），是WEB兴起后的一种网络结构模式，WEB浏览器是客户端最主要的应用软件。这种模式统一了客户端，将系统功能实现的核心部分集中到服务器上，简化了系统的开发、维护和使用。客户机上只要安装一个浏览器，如Netscape、Navigator或Internet Explorer，服务器安装SQL Server、Oracle、MYSQL等数据库。浏览器通过Web Server 同数据库进行数据交互。

#### IOC:   
控制反转,有2种实现方式,DI(依赖注入)和DL(依赖查找).

#### 服务器（软件）或服务器端：  
服务器管理软件是一套处理硬件、操作系统及应用软件等不同层级|软件管理及升级、系统资源管理、性能维护和监控配置|的程序。服务器端，从广义上讲，服务器是指网络中能对其他机器提供某些服务的计算机系统（如果一个PC对服务器端外提供ftp服务，也可以叫服务器）。

#### SSM框架：  
Spring + Spring MVC + MyBatis的缩写，Spring的用途不仅限于服务器端的开发。从简单性、可测试性和松耦合的角度而言，任何Java应用都可以从Spring中受益。简单来说，Spring是一个轻量级的控制反转（IoC）和面向切面（AOP）的容器框架。

#### MQTT：  
是一个基于客户端-服务器的消息发布/订阅传输协议。MQTT协议是轻量、简单、开放和易于实现的，这些特点使它适用范围非常广泛。在很多情况下，包括受限的环境中，如：机器与机器（M2M）通信和物联网（IoT）。其在，通过卫星链路通信传感器、偶尔拨号的医疗设备、智能家居、及一些小型化设备中已广泛使用。

#### Echarts：  
全称 Apache ECharts，是一个使用 JavaScript 实现的开源可视化库，可以流畅地运行在 PC 和移动设备上，兼容多种浏览器，如 IE8/9/10/11、Chrome、Firefox、Safari 等。该库被广泛用于创建直观、交互性强、可高度个性化定制的数据可视化图表。它提供了丰富的可视化类型，包括常规的折线图、柱状图、散点图、饼图、K线图，以及用于地理数据可视化的地图、热力图、线图等。此外，它还支持自定义系列，允许用户将数据映射到几乎任何想要的图形。

#### Spring  
Spring是一个开源框架，Spring是于2003 年兴起的一个轻量级的Java 开发框架，由Rod Johnson 在其著作Expert One-On-One J2EE Development and Design中阐述的部分理念和原型衍生而来。它是为了解决企业应用开发的复杂性而创建的。Spring使用基本的JavaBean来完成以前只可能由EJB完成的事情。然而，Spring的用途不仅限于服务器端的开发。从简单性、可测试性和松耦合的角度而言，任何Java应用都可以从Spring中受益。 简单来说，Spring是一个轻量级的控制反转（IoC）和面向切面（AOP）的容器框架。

#### Mybatis  
MyBatis本是apache的一个开源项目iBatis,2010年这个项目由apache software foundation 迁移到了google code，并且改名为MyBatis 。MyBatis是一个基于Java的持久层框架。iBATIS提供的持久层框架包括SQL Maps和Data Access Objects（DAO）MyBatis 消除了几乎所有的JDBC代码和参数的手工设置以及结果集的检索。MyBatis 使用简单的 XML或注解用于配置和原始映射，将接口和 Java 的POJOs（Plain Old Java Objects，普通的 Java对象）映射成数据库中的记录。

#### Spring Boot  
Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者。SpringBoot基于Spring4.0设计，不仅继承了Spring框架原有的优秀特性，而且还通过简化配置来进一步简化了Spring应用的整个搭建和开发过程。另外SpringBoot通过集成大量的框架使得依赖包的版本冲突，以及引用的不稳定性等问题得到了很好的解决。

#### Maven  
Maven项目对象模型(POM)，可以通过一小段描述信息来管理项目 的构建，报告和文档的项目管理工具软件。Maven 除了以程序构建能力为特色之外，还提供高级项目管理工具。由于 Maven 的缺省构建规则有较高的可重用性，所以常常用两三行 Maven 构建脚本就可以构建简单的项目。由于 Maven 的面向项目的方法，许多 Apache Jakarta 项目发文时使用 Maven，而且公司项目采用 Maven 的比例在持续增长。Maven这个单词来自意第绪语（犹太语），意为知识的积累，最初在Jakata Turbine项目中用来简化构建过程。当时有一些项目（有各自Ant build文件），仅有细微的差别，而JAR文件都由CVS来维护。于是希望有一种标准化的方式构建项目，一个清晰的方式定义项目的组成，一个容易的方式发布项目的信息，以及一种简单的方式在多个项目中共享JARs。

#### layui  
layui（谐音：类 UI) 是一套开源的 Web UI 解决方案，采用自身经典的模块化规范，并遵循原生 HTML/CSS/JS 的开发方式。主要面向的是全层次的前后端开发者，极易上手，开箱即用，非常适合网页界面的快速开发。

#### Elementui  
Element，一套为开发者、设计师和产品经理准备的基于 Vue 2.0 的桌面端组件库，官网： https://element.eleme.cn/#/zh-CN。

#### EMQX  
EMQX是一款完全开源，高度可伸缩，高可用的分布式 MQTT 消息服务器，同时也支持 CoAP/LwM2M一站式 IoT 协议接入。EMQX是 5G 时代万物互联的消息引擎，适用于 IoT、M2M 和移动应用程序，可处理千万级别的并发客户端。

#### Echarts  
Echarts是一个基于JavaScript的数据可视化图表库，旨在提供直观、交互性强且可高度个性化定制的图表解决方案。Echarts提供了丰富的图表类型，且被设计成能够在PC和移动设备上流畅运行，兼容多种浏览器。官网：Apache ECharts

## 四、系统架构

![总体设计](/about/f.png)

### 前端
用户界面：使用Vue.js构建，提供实时数据展示和异常警报功能。  
数据请求：通过HTTP请求与后端API交互，获取实时数据和警报信息。  

### 后端
API接口：使用Spring Boot构建，提供数据采集、存储和异常检测的API。  
数据处理：实时处理传感器数据，检测异常并生成警报。  
数据库操作：与MySQL数据库交互，存储和查询数据。  

### 数据库
MySQL：存储传感器数据和警报记录。

数据表：  
users：存储用户信息。  
exception：存储异常记录。  
strawberry_house：存储大棚内的环境参数信息。  
svr_prediction：存储预测数据。

### 数据仓库
Hive：将大量历史数据存储在数据仓库中，可用于数据可视化和分析。  
Hadoop：用于数据仓库的分布式文件系统。

### 传感器
温湿度传感器：采集大棚内的温度和湿度数据。  
光照传感器：采集大棚内的光照强度数据。  
CO2浓度传感器：采集大棚内的CO2浓度数据。  

## 五、安装与部署
### 环境要求
操作系统：Linux/Windows  
所需组件及对应版本：  
jdk	1.8  
mysql	8.0  
maven	3.6.3  
kafka	2.4.1  
flink	1.12.1  
scala	2.12  
canal	1.1.4  
hadoop	3.3.1  
zookeeper	3.6.3  
mqtt	5.3.2  
FineBI	6.0  
RuoYi	3.3.0  
Echarts	5.5.0  

## 六、快速开始
1.克隆项目：  
git clone https://github.com/logxiaoming/strawberry_project.git  

2.安装后端依赖

3.安装前端依赖

4.配置数据库

5.启动后端服务

6.启动前端服务

7.安装并启动MQTT Broker，如Mosquitto。  

8.配置传感器设备，使其连接到MQTT Broker。

## 七、使用说明
### 用户界面
登录：访问http://localhost:8080，使用默认账号admin和密码password登录。  
实时数据：查看大棚内的实时环境数据。  
异常警报：查看和处理异常警报信息。  
历史数据：查询历史环境数据和警报记录。  

### 报警通知
短信通知：系统通过短信服务提供商发送警报短信。  
邮件通知：系统通过SMTP服务器发送警报邮件。  

### 常见问题
数据不更新  
确保传感器设备正常工作，并且网络连接稳定。  
检查后端服务是否正常运行，查看日志文件。  

报警不发送  
检查短信和邮件服务配置是否正确。  
确保用户设置了正确的联系方式。  

## 八、贡献指南
欢迎贡献代码和提出改进建议。请遵循以下步骤：

Fork 本项目。  
创建新的分支：git checkout -b feature/your-feature-name  
提交您的更改：git commit -m 'Add some feature'  
推送到分支：git push origin feature/your-feature-name  
提交Pull Request  

## 许可证
本项目采用MIT许可证，详情请参见LICENSE文件。  