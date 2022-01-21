# ElasticSerarch概述

Elaticsearch，简称es，es是一个开源的**高扩展**的**分布式全文搜索引擎**，它可以近乎**实时的存储**，**检索数据**；本身扩展性很好，可以扩展到上百台服务器，处理PB级别的数据。es也是用java开发并使用Lucene作为核心来实现所有的搜索功能，但是他的目的是通过简单的**RESTful API**来隐藏Lucene的复杂性，从而让全文搜索变得简单。

据国际权威的数据库产品评测机构DB Engines的统计，在2016年1月，ElasticSearch已经超过Solr等，称为排名第一的搜索引擎类应用。

## 谁在使用：

1、维基百科，类似百度百科，全文检索，高亮，搜索推荐

2、The Guardian（国外新闻网站），类似搜狐新闻， 用户行文日志（点击，浏览，收藏，评论）+社交网络数据、数据分析等

3、Stack Overflow，IT问题，程序的报错，提交上去，有人会跟你讨论何回答，全文检索，搜索相关问题的答案，程序报错了，就会将报错信息粘贴到里面去，搜索有没有对应的答案。

4、GitHub，搜索上千亿行代码

5、电商网站，检索商品

6、日志数据分析，logstash采集日志，ES进行u发杂的数据分析 ，ELK技术，elasticsearch+logstash+kibana

## ES和solr的差别

### Elasticsearch简介

Elasticsearch是一个实时分布式搜索和分析引擎。他让你以前所未有的速度处理大数据称为可能。

它用于**全文搜索**、**结构化搜索**、**分析**以及将这三者混合使用：

维基百科使用Elasticsearch提供全文搜索并高亮关键字，以及输入实时搜索（search-asyou-type）和搜索纠错（did-you-mean）等搜索建议功能。

英国卫报使用Elasticsearch结合用户日志和社交网络数据提供给他们的编辑以实时的反馈，以便及时了解公众对新发表的文章的回应。

StackOverflow结合全文搜索与地理位置查询，以及more-like-this功能来找到相关的问题和答案。

Github是以哦那个Elasticsearch检索1300亿行代码。

但是Elasticsearch不仅用于大型企业，它还让像DataDog以及Klout这样的创业公司将最初的想法变成可扩展的解决方案。Elasticsearch可以在你笔记本上运行，也可以在数以百计的服务器上处理PB级别的数据。

Elasticsearch是一个基于Apache Lucene（TM）的开源搜索引擎。 无论在开源还是专有领域，Lucene可以被认为是迄今为止最先进、性能最好的、功能最全的搜索引擎库。

但是，Lucene只是一个库。想要使用它，你必须使用java来作为开发语言并将其直接集成到你的应用中，更糟糕的是，Lucen非长复杂，你需要深处了解检索的相关知识来理解它是如何工作的。

Elasticsearch也是用java开发并使用Lucene作为其核心来实现所有搜索引擎和搜索的功能，但是他的目的是通过简单的RESTful API来隐藏Lucene的复杂性，从而让全文所搜索变得简单。

### Solr简介

Solr是Apache下的一个顶级开源项目，采用java开发，他是基于Lucene的全文搜索服务器。solr提供了比Lucene更为功夫的查询语言，同时实现了可配置、可扩展，并对索引、搜索性能进行了优化

Solr可以独立运行，运行在Jetty、Tomcat等这些Servlet容器中，Solr索引的实现方法很简单，用POST方法向Solr服务器发送一个描述FieId及其内容的XML文档，Solr根据xml文档添加、删除、更新索引。Solr搜索只需要发送HTTP GET请求，然后对Solr返回Xml、json等格式的查询结果进行解析，组织页面布局。Solr不提供构建UI的功能，Solr提供了一个管理界面，通过管理界面可以查询Solr的配置和运行情况。

Solr是基于lucene开发企业级搜索服务器，实际上就是封装lucne。

Solr是要给独立的企业级搜索应用服务器，他对外提供类似于Web-service的API接口。用户可以通过http请求，向搜索引擎服务器提交一定格式的文件，生成索引；也可以通过提出查找请求，并得到返回结果。

### Lucene简介

Lucene是apache软件基金会4 jakarta项目组的一个子项目，是要给开源代码的全文检索引擎工具包，但它不是要给完整的全文检索引擎，而是要给全文检索引擎的架构，提供了完整的查阅引擎和索引引擎，部分文本分析引擎（英语与德语两种西方语言）。起完整的全文检索引擎。Lucene是一套用于全文检索和搜寻的开源程式库，由Apache软件基金会支持和提供。Lucene提供了一个简单却强大的应用程式接口，能够做全文索引的搜寻。在java开发环境里Lucene是一个成熟的免费开源工具。就其本身而言，Lucene是当前以及最近几年最受欢迎的免费java信息检索程序库。然们经常提到信息检索程序库，虽然与搜索引擎有关。但不应该将信息检索程序库与搜索引擎相混淆。

Lucene是一个全文检索引擎的架构。那什么是全文搜索引擎？
全文搜索引擎是名副其实的搜索的搜索引擎，国外具代表性的由Google、Fast/AlltheWeb、AltaVista、Inktomi、Teoma、WiseNut等。国内著名的有百度 。他们都是通过互联网提取的各个网站的信息（以网页文字为主）而建立的数据库中，检索与用户查询条件匹配的相关记录，然后按一定的排序后顺序将结果返回给用户，因此他们是真正的搜索引擎。

从搜索结果来源的角度，全文所有引擎又可细分两种，一种是拥有自己的检索程序（Indexer），俗称“蜘蛛”（Spider）程序或“机器人”（Robot）程序，并自建网页数据库，搜索结果直接从自身的数据库中调用，如上面提到的7家引擎；另一种则是租用其他引擎的数据库，并按自定的格式排列搜索结果，如Lycos引擎。

### Elasticsearch和Solr比较

![image-20220111185639861](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220111185647.png)

![image-20220111185704060](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220111185704.png)

![image-20220111185727749](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220111185727.png)

![image-20220111185810507](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220111185810.png)



### ElasticSearch VS Solr总结

1、ES基本是开箱即用，非常简单，Solr安装略微复杂

2、Solr利用Zookeeper进行分布式管理，而Elasticsearch自身带有分布式协调管理功能。

3、Solr支持更多格式的数据，比如json、xml、csv，而Elasticsearch仅支持json文件格式。

4、Solr官方提供的功能更多，而Elasticsearch本身更注重于核心功能，高级功能多有第三方插件提供，例如图形化界面需要kibana友好支撑

5、Solr查询快，但更新索引时慢（及插入删除慢），用于电商等查询多的应用

* ES建立索引快（即查询慢），即实时性查询快，用于facebook新浪等搜索。
* Solr是传统搜索应用的有力解决方案，但Elasticsearch更适用于新兴的实时搜索应用。

6、Solr比较成熟，有一个更大，更成熟的用户、开发和贡献者社区，而Elasticsearch相对开发维护者较少，更新太快，学习使用成本较高。

# ElasticSearch安装

## 文件目录

![image-20220117140301634](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220117140308.png)

```
bin 启动文件
config 配置文件
	log4j2 日志配置文件
	jvm.options  java虚拟机相关配置
	elasticsearch.yml	elasticsearch的配置文件
lib	相关jar包
modules	功能模块
logs	日志
plugins	插件

```



## 配置跨域文问题

打开elasticsearch.yml添加

```yaml
http.cors.enabled: true
http.cros.allow-origin: "*"
```

## 安装Kibana

![image-20220117141645612](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220117141645.png)

### 启动

![image-20220117150046602](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220117150053.png)

### 汉化

修改kibanna的config目录下的ymal配置文件

![image-20220117150520943](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220117150521.png)

重启

![image-20220117150730069](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220117150730.png)

# ES核心概念

> 概述

es是如何去存储数据，数据结构是什么，又是如何实现搜索的呢？

==集群、节点、索引、类型、文档、分片、映射是什么?==

> elasticeasrch是面向文档，关系型数据库和selasticsearch客观的对比！一切都是JSON

| Relational DB    | Elasticsearch |
| ---------------- | ------------- |
| 数据库(database) | 索引(indices) |
| 表(tables)       | types         |
| 行(rows)         | documents     |
| 字段(columns)    | fields        |

elaticsearch(集群)中可以包含多个索引(数据库)，每个索引中可以包含多个类型(表)，每个类型下又包含多个文档(行)，每个文档中又包含多个字段(列)

### 物理设计

elasticsearch在后台把每个**索引分成多个分片**，每份分片可以在集群中的不同服务器间迁移

### 逻辑设计

一个索引类型中，包含多个文档，比如说文档1，文档2。当我们索引一篇文档时，可以通过这样的一个顺序找到它：索引-类型-文档ID，通过这个组合我们就能索引到某个具体的文档。注意：ID不必是整数，实际上它是个字符串。

> 文档

之间说elasticsearch是面向文档的，那么就意味着索引和搜索数据的最小单位是文档，elaticsearch中，文档有几个重要属性：

* 自我包含，一篇文档同时包含字段和对用的值，也就是同时包含key:value
* 可以是层次性的，一个文档中包含子文档，复杂的逻辑实体就是这么来的
* 灵活的结构，文档不依赖预先定义的模式，我们知道关系型数据库中，要提前定义字段才能使用，在elasticsearch中，对于字段是非常灵活的，有时候，我们可以忽略该字段，或者动态的添加要给新的字段。

尽管我们可以随意的新增或者忽略某个字段，但是，每个字段的类型非常重要，比如要给年龄字段类型，可以是字符串也可以是整型。因为elasticsearch会保存字段和类型之间的映射及其他的设置。这种映射具体到每种类型，这就是为什么在elasticsearch中，类型有时候也称为映射类型。

> 类型

类型是文档的逻辑容器，就像关系型数据库一样，表格是行的容器。类型中对于字段的定义称为映射，比如name映射为字符串类型。我们说文档是无模式的，他们不需要拥有映射中所定义的所有字段，比如新增一个字段，那么elasticsearch是怎么做的呢？

elasticsearch会自动地将新字段加入映射，但是这个字段的不确定它是什么类型，elasticsearch就开始猜，如果这个值是18，那么elasticsearch会认为他是整型，但是elasticsearch也可能猜不对，所以最安全的方式是提前定义好所需要地映射，这点跟关系型数据库殊途同归了，先定义好字段，然后再使用。

> 索引

索引是映射类型的容器，elasticsearch中的索引是一个非常大的文档集合。索引存储了映射类型的字段和其他设置。然后他们被存储到了各个分片上了。我们来研究下分片是如何工作的。

### 物理设计：节点和分片 如何工作

一个集群只好有一个节点，而一个节点就是一个elasticsearch进程，节点可以有多个索引默认的，如果你创建索引，那么索引将会由5个分片（primary shard，又称主分片）构成的，每个主分片会有一个副本（replica shard，又称复制分片）

![image-20220117163850290](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220117163850.png)

上图是一个有3个节点的集群，可以看到主分片和对应的复制分片都不会在同一个节点内，这样有利于某个节点挂掉了，数据也不至于丢失。实际上，一个分片是要给Lucene索引，一个包含倒排索引的文件目录，倒排索引的结构使得elasticsearch在不扫描全部文档的情况下，就能告诉你哪些文档包含特定的关键字。

> 倒排索引

elasticsearch使用的是一种称为倒排索引的结构，采用Lucene倒排索引作为底层。这种结构适用于快速的全文搜索，一个索引由文档中所有不重复的列表构成，对于每一个词，都有一个包含他的文档列表。例如，现在有两个文档，每个文档包含如下内容：

```
study every day ,good good uo to forever #文档1的内容
to farever , study every day , goo goo up #文档2的内容
```

为了创建倒排索引，我们首先要将每个文档拆分成独立的词（或称为词条或者tokens），然后创建一个包含所有不重复的词条的排序列表，然后列出每个词条出现在哪个文档：

![image-20220117164639387](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220117164639.png)

现在是视图搜索 to forever，只需要查看包含每个词条的文档

![image-20220117164804636](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220117164804.png)

两个文档都匹配，但是第一个文档比第二个匹配程度更高。如果没有别的条件，现在，这两个包含关键字的问你大概都将返回。再来看要给实例，比如我们通过博客标签来搜索博客文章。那么倒排所哟i你列表就是这样的结构：

![image-20220117165001377](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220117165001.png)

如果要搜索包含python标签的文章，那相对于查找所有原始数据而言，查找倒排索引后的数据将会快的多。只需要查看标签这一栏，然后获取相关的文章ID即可。

elasticsearch的索引和Lucene的索引对比

在elasticsearch中，索引这个词配频繁使用，这就是术语的使用。在elasticsearch中，索引被分为多个分片，每个分片是要给Lucene的索引。所以一个elasticsearch索引是由多个Lucene索引组成的。

# IK分词器

> 什么是IK分词器

分词：即把一段中文或者别的划分成一个个的关键字，我们在搜索时候会把自己的信息进行分词，会把数据库中或者索引库中的数据进行分词，然后进行要给匹配操作，默认的中文分词是将每个字看成一个词，比如“我爱中国”会被分为“我”、“爱”、“中”、“国”，这显然是不符合要求的，所以我们要安装中文分词器IK来解决这个问题

如果使用中文，推荐使用ik分词器

IK提供了两种分词算法：ik_smart和ik_max_word，其中ik_smart为最小切分，ik_max_word为最细粒度划分

> 查看不同分词效果

其中il_smart为最小切分

![image-20220120204845955](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120212511.png)

ik_max_word为最细粒度划分，穷尽词库的可能

![image-20220120205029389](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120212552.png)

> ik分词器增加自己的配置

当我们输入“我喜欢钢铁侠”，发现“钢铁侠”被拆分开了，这就会在搜索的时候出现不准确的信息

![image-20220120205727154](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120212627.png)

所以我们需要在ik文件夹中自定义一个字典，并且注入到xml中

![image-20220120205602796](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120212658.png)

重启ES

![image-20220120210615045](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120212729.png)

再次测试“我爱钢铁侠”

![image-20220120210715672](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120212846.png)

以后，我们需要自己配置分词，就在自定义的dic文件中进行配置即可！

# Rest风格说明



一种软件架构风格，而不是标准，只是提供了一组设计原则和约束条件。它主要用于客户端和服务器交互类的软件。基于这个风格设计的软件可以更简洁，更有层次，更易于实现缓存等机制。

基本Rest命令说明：

| method |                   url地址                   |          描述          |
| :----: | :-----------------------------------------: | :--------------------: |
|  PUT   |     lcoalhost:9200/索引名称/类型/文档id     | 创建文档（指定文档id） |
|  POST  |        lcoalhost:9200/索引名称/类型         | 创建文档（随机文档id） |
|  POST  | lcoalhost:9200/索引名称/类型/文档id/_update |        修改文档        |
| DELETE |     lcoalhost:9200/索引名称/类型/文档id     |        删除文档        |
|  GET   |     lcoalhost:9200/索引名称/类型/文档id     |   查询文档通过文档id   |
|  POST  |    lcoalhost:9200/索引名称/类型/_search     |      查询所有数据      |

> 基础测试

1、创建一个索引

```bash
PUT /索引名/~类型名~/文档id
{请求体}
```



![image-20220120213209020](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120214843.png)

完成了自动增加索引

![image-20220120220425729](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120220432.png)



> 字段数据类型

* 字符串类型
  * text、**keyword**
    * text：支持分词、全文检索、支持模糊、精确查询，不支持聚合，排序操作；text类型的最大支持的字符长度无限制，适合大字段存储；
    * keyword：不进行分词，直接索引、支持模糊、支持精确匹配，支持聚合、排序操作。keyword类型的最大支持长度为——32766个UTF-8类型的字符，可以通过设置ignore_above只当支持特殊字符，超过给定长度后的数据不被索引，无法通过term精确匹配检索返回结果。
* 数值型
  * long、Integer、short、byte、double、float、**half float**、**scaled float**
* 日期类型
  * date
* 布尔类型
  * boolean
* 二进制类型
  * binary
* 等等……

# 关于索引的基本操作



> 指定字段的类型

![image-20220120221755209](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120221755.png)



> 获得规则

![image-20220120221904536](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120221904.png)

> 查看默认的信息

![image-20220120222214512](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120222214.png)

![image-20220120222303359](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120222303.png)

如果自己的文档字段没有指定类型，那么es就会给我们默认配置字段类型



扩展：通过elasticsearch索引情况，通过GET _cat/  可以获得es的当前的很多信息

![image-20220120222701992](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120222702.png)

> 修改  提交还是使用PUT即可，然后覆盖

![image-20220120223004439](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120223004.png)

现在的方法：

![image-20220120223350495](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120223350.png)

> 删除索引

通过DELETE命令实现删除，根据你的请求来判断是删除索引还是删除文档记录

![image-20220120223558858](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120223558.png)



# 关于文档的基本操作

> 基本操作

1、添加一条数据

```java
PUT /mrlqq/user/1
{
  "name":"钢铁侠",
  "age": "22",
  "desc":"有钱有智慧",
  "tags":["超级英雄","富豪","聪明"]
}
```

![image-20220120230305003](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120230305.png)

2、获取数据GET

![image-20220120230704847](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120230704.png)

3、更新数据 PUT

put会覆盖原始数据，若执行put是没有完整的修改全部属性，会导致原始数据内容丢失，也就是意味着，put同名的数据，会删除原始的数据，然后重新创作你当前的数属性

![image-20220120230859481](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120230859.png)

4、POST  _update，推荐使用这种更新方式

这种方式只影响你要修改的数据，不会影响到其他的属性

![image-20220120231242797](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120231242.png)

简单的搜索

```
GET mrlqq/user/1
```

> 简单的条件查询

![image-20220120232009373](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120232009.png)

> 复杂操作查询 select（排序、分页、高亮、模糊查询、精准查询）

![image-20220120232521021](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120232521.png)

![image-20220120233206298](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120233206.png)

> 结果过滤

![image-20220120233425501](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120233425.png)

我们之后使用java操作es，所有的方法和对象就是这里面的key

> 排序

![image-20220120235824938](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220120235825.png)

> 分页查询

![image-20220121000030226](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121000030.png)

> 布尔值查询

must，所有的条件都要符合（and）

![image-20220121000459890](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121000459.png)

should，符合部分条件（or）

![image-20220121000751586](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121000751.png)

must_not，不符合条件的(not)

![image-20220121000915004](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121000915.png)

> 过滤器 filter

![image-20220121001525229](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121001525.png)

> 匹配多个条件

![image-20220121002049659](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121002049.png)

> 精确查询

term查询是直接通过倒排索引指定的词条进行精确查找的

关于分词：

term，直接查询精确的

match，会使用分词器解析（先分文档，然后再通过分析的文档进行查询）

**两个类型 text keyword**

text可以被分词器解析，可以被拆分

keyword不会被分词器解析，作为一个整体

> 多个值匹配的精确查询

![image-20220121004043528](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121004043.png)

> 高亮显示

![image-20220121004449407](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121004449.png)

自定义高亮

![image-20220121004837449](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121004837.png)



# 集成SpringBoot

> 创建空的spirngboot项目，添加不要的组件以及elasticsearch组件，需要注意的是，我们自己需要定义es的版本依赖，以保证es依赖与本地es的版本相同

![image-20220121152214262](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121155411.png)

> 具体的API测试

1、创建索引

```java
// 测试索引的创建 Request
@Test
void TestCreateIndex() throws IOException {
    // 1、创建索引请求
    CreateIndexRequest request = new CreateIndexRequest("mrlqq_index");
    // 2、客户端执行请求 IndicesClient ，请求后获得响应
    CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);

    System.out.println("createIndexResponse = " + createIndexResponse);

}
```

2、判断索引是否存在

```java
// 测试获得索引，判断其是否存在
@Test
void testExistIndex() throws IOException {
    GetIndexRequest request = new GetIndexRequest("mrlqq_index");
    boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
    System.out.println("exists = " + exists);
}
```

3、删除索引

```java
// 测试删除索引
@Test
void testDeleteIndex() throws IOException {
    DeleteIndexRequest request = new DeleteIndexRequest("mrlqq_index");
    // 删除
    AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
    System.out.println("delete = " + delete.isAcknowledged());
}
```

4、创建文档

```java
// 测试添加文档
@Test
void testAddDocument() throws IOException {
    // 创建对象
    User user = new User("钢铁侠", 22);
    // 创建请求
    IndexRequest request = new IndexRequest("mrlqq_index");

    // 规则 put/mrlqq_index/_doc/1
    request.id("1");
    request.timeout(TimeValue.timeValueSeconds(1));
    request.timeout("1s");

    // 将我们的数据放入请求 json
    request.source(JSON.toJSONString(user), XContentType.JSON);

    // 客户端发送请求
    IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
    System.out.println(indexResponse.toString());
    System.out.println(indexResponse.status()); // 对应我们命令的返回状态 CREATED


}
```

5、crud文档

```java
// 获取文档，判断是否存在
@Test
void testIsExists() throws IOException {
    GetRequest getRequest = new GetRequest("mrlqq_index","1");
    // 不获取返回的_source的上下文
    getRequest.fetchSourceContext(new FetchSourceContext(false));
    getRequest.storedFields("_none_");

    boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
    System.out.println(exists);
}

// 获取文档信息
@Test
void testGetDocument() throws IOException {
    GetRequest getRequest = new GetRequest("mrlqq_index", "1");
    GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
    // 打印文档内容
    System.out.println("getResponse.getSourceAsString() = " + getResponse.getSourceAsString());
    System.out.println("getResponse = " + getResponse);
}

// 更新文档信息
@Test
void testUpdateRequest() throws IOException {
    UpdateRequest updateRequest = new UpdateRequest("mrlqq_index", "1");
    updateRequest.timeout("1s");

    User user = new User("钢铁侠123", 28);
    updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);

    UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
    System.out.println("updateResponse.status() = " + updateResponse.status());
}

// 删除文档记录
@Test
void testDeleteRequest() throws IOException{
    DeleteRequest Request = new DeleteRequest("mrlqq_index", "1");
    Request.timeout("1s");

    DeleteResponse deleteResponse = client.delete(Request, RequestOptions.DEFAULT);
    System.out.println("deleteResponse.status() = " + deleteResponse.status());
}

// 批量插入数据
    @Test
    void testBulkRequest() throws IOException{
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("20s");

        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("钢铁侠1", 22));
        userList.add(new User("钢铁侠1", 22));
        userList.add(new User("钢铁侠1", 22));
        userList.add(new User("钢铁侠1", 22));
        userList.add(new User("钢铁侠1", 22));
        userList.add(new User("钢铁侠1", 22));

        // 批量处理请求
        for (int i = 0; i < userList.size(); i++) {
            // 批量更新和批量和删除，就在这里修改对应的请求就可以
            bulkRequest.add(new IndexRequest("mrlqq_index")
                    .id(String.valueOf(i+1))
                    .source(JSON.toJSONString(userList.get(i)), XContentType.JSON));
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        // 是否失败，false：表示成功没有失败
        System.out.println("bulkResponse.hasFailures() = " + bulkResponse.hasFailures());

    }

```

6、条件查询

```java
// 查询
// SearchRequest 搜索请求
// SearchSourceBuilder 条件构造
// HighlightBuilder 构建高亮
//
//   QueryBuilders 搜索条件构建器
//          termQueryBuilder 构建精确查询
//          matchQueryBuilder 构建匹配查询
@Test
void testSearch() throws IOException {
    SearchRequest searchRequest = new SearchRequest("mrlqq_index");
    // 构建搜索条件
    SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

    // 查询条件，我们可以使用QueryBuilders工具来实现
    // QueryBuilders.termQuery 精确查询
    // QueryBuilders.matchAllQuery 匹配所有
    TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "钢铁侠1");
    MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "钢铁");
    //MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();

    sourceBuilder.query(matchQueryBuilder);
    sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

    searchRequest.source(sourceBuilder);

    SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
    System.out.println(JSON.toJSONString(searchResponse.getHits()));
    System.out.println("++++++++++++++++++++++++++++");
    for (SearchHit documentFields : searchResponse.getHits().getHits()) {
        System.out.println("documentFields.getSourceAsMap() = " + documentFields.getSourceAsMap());
    }
}
```



# 实战

![image-20220121191742769](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121191808.png)

## 爬虫

> 数据来源问题，可以从数据库获取，消息队列中获取，都可以称为数据源，还可以用爬虫

爬取数据：（获取请求返回的页面信息，筛选出我们想要的数据就可以）使用Jsoup

通过使用jsoup可以爬取到页面中想要数据

首先创建实体类

```java
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private String title;
    private String img;
    private String price;
}
```

封装为方法

```java
public class HtmlParseUtil {
    public static void main(String[] args) throws IOException {
        // 获取请求 https://search.jd.com/Search?keyword=java
        // 前提，需要联网
        String url = "https://search.jd.com/Search?keyword=java";
        // 解析网页 (jsoup返回Document就是Document对象)
        Document document = Jsoup.parse(new URL(url), 30000);
        // 所以再js中可以使用的方法， 这里都能用！
        Element element = document.getElementById("J_goodsList");
        
        // 获取所有的li元素
        Elements elements = element.getElementsByTag("li");
        // 获取元素中的内容 这里的el，就是每个li标签了
        for (Element el : elements) {
            // 关于这种图片特别多的网站，所有的图片都是延迟加载的
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();

            System.out.println("===================================");
            System.out.println("img = " + img);
            System.out.println("price = " + price);
            System.out.println("title = " + title);
        }

    }
}
```

结果

```bash
===================================
img = //img11.360buyimg.com/n1/s200x200_jfs/t1/70233/19/16850/243662/6142a043E0e5f28d9/d7ee7d164b8eb156.jpg
price = ￥63.00
title = 零基础学Java（全彩版）手把手教学，赠源码、习题、技术答疑
===================================
img = //img13.360buyimg.com/n1/s200x200_jfs/t1/186038/9/7947/120952/60bdd993E41eea7e2/48ab930455d7381b.jpg
price = ￥60.30
title = Java从入门到精通（第6版）（软件开发视频大讲堂） Java入门经典，销售12年，80万Java程序员选择，210集教学视频+211个应用示例+151个编程训练+94个综合训练+在线答疑，Java核心技术　团购电话4006186622
===================================
img = //img10.360buyimg.com/n1/s200x200_jfs/t1/146172/4/7453/357315/5f5099a8E331a2969/e8c60e5068541c7d.jpg
price = ￥298.00
title = Java核心技术 第11版 套装共2册 CoreJava从入门到精通套装，与Java编程思想、EffectiveJava、深入理解Java虚拟机堪称：Java四大名著 100册以上团购优惠联系电话4006186622
===================================
img = //img14.360buyimg.com/n1/s200x200_jfs/t1/28526/24/4598/165510/5c3433c7Ea1da5694/eb0bb43a326e8709.jpg
price = ￥119.00
title = Effective Java中文版（原书第3版） Java之父力荐；Jolt大奖获奖作品升级；与Java核心技术、Java编程思想、深入理解Java虚拟机堪称Java四大名著。正版图书双色印刷，阅读体验更佳 100册以上团购优惠联系电话4006186622
===================================
img = //img13.360buyimg.com/n1/s200x200_jfs/t1/102900/26/2632/158701/5dd601a5E9ed34588/596e136d4a144cae.jpg
price = ￥149.00
title = Java核心技术 卷I 基础知识（原书第11版） CoreJava第11版，Jolt大奖获奖作品，与Java编程思想、EffectiveJava、深入理解Java虚拟机堪称：Java四大名著 100册以上团购优惠联系电话4006186622
===================================

```

## 后端代码

ContentService.java

包含调用上文的解析方法，向es中添加数据、普通搜索方法、以及在此基础上的高亮搜索方法

```java
@Service
public class ContentService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    // 1、解析数据放入es索引中
    public Boolean parseContent(String keywords) throws IOException{
        List<Content> contents = new HtmlParseUtil().parseJD(keywords);
        // 把查询到数据放入es中
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m");
        for (int i = 0; i < contents.size(); i++) {
            bulkRequest.add(new IndexRequest("jd_goods")
                    .source(JSON.toJSONString(contents.get(i)), XContentType.JSON));
        }

        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !bulk.hasFailures();
    }

    // 2、获取这些数据 实现搜索功能
    public List<Map<String, Object>> searchPage(String keyword, int pageNo, int pageSize) throws IOException {
        if (pageNo<=1){
            pageNo = 1;
        }

        // 条件搜索
        SearchRequest searchRequest = new SearchRequest("jd_goods");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 分页
        sourceBuilder.from(pageNo);
        sourceBuilder.size(pageSize);

        // 精准匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", keyword);
        sourceBuilder.query(termQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // 执行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        // 解析结果
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit documentFields : searchResponse.getHits().getHits()) {
            list.add(documentFields.getSourceAsMap());
        }
        return list;
    }

    // 3、获取这些数据 实现搜索高亮功能
    public List<Map<String, Object>> searchPageHighlight(String keyword, int pageNo, int pageSize) throws IOException {
        if (pageNo<=1){
            pageNo = 1;
        }

        // 条件搜索
        SearchRequest searchRequest = new SearchRequest("jd_goods");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 分页
        sourceBuilder.from(pageNo);
        sourceBuilder.size(pageSize);

        // 精准匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", keyword);
        sourceBuilder.query(termQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // 高亮显示
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");
        // 多个高亮显示，设置false，只高亮目标字段的第一个匹配的字符
        highlightBuilder.requireFieldMatch(false);
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");
        sourceBuilder.highlighter(highlightBuilder);

        // 执行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        // 解析结果
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {

            // 解析高亮的字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField title = highlightFields.get("title");
            // 这是原来的结果
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            // 解析置换高亮的字段  将原来的字段换为我们高亮的字段即可
            if (title!=null){
                Text[] fragments = title.getFragments();
                String newTitle = "";
                for (Text fragment : fragments) {
                    newTitle += fragment;
                }
                // 替换原来的高亮字段
                sourceAsMap.put("title",newTitle);
            }
            list.add(sourceAsMap);
        }
        return list;
    }

}
```

 ContentController

```java
@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("/parse/{keywords}")
    public boolean parse(@PathVariable("keywords") String keywords) throws IOException {
        return  contentService.parseContent(keywords);
    }

    @GetMapping("/search/{keywords}/{pageNo}/{pageSize}")
    public List<Map<String, Object>> search(@PathVariable("keywords") String keywords,
                                            @PathVariable("pageNo") int pageNo,
                                            @PathVariable("pageSize") int pageSize) throws IOException {
        if (pageNo<=0){
            pageNo = 1;
        }

        // 高亮搜索
        return contentService.searchPageHighlight(keywords,pageNo,pageSize);
    }
}
```

前后端分离使用Vue开发，需要下载并引入Vue.min.js和axios.js

> 如果安装了node.js，可以按如下步骤下载

```bash
npm install vue
npm install axios
```

![image-20220121214223706](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121214233.png)

引入js

```html
<script th:src="@{/js/vue.min.js}"></script>
<script th:src="@{/js/axios.min.js}"></script>
```

修改后的index

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8"/>
    <title>ES仿京东实战</title>
    <link rel="stylesheet" th:href="@{/css/style.css}"/>

</head>

<body class="pg">
<div class="page" id="app">
    <div id="mallPage" class=" mallist tmall- page-not-market ">

        <!-- 头部搜索 -->
        <div id="header" class=" header-list-app">
            <div class="headerLayout">
                <div class="headerCon ">
                    <!-- Logo-->
                    <h1 id="mallLogo">
                        <img th:src="@{/images/jdlogo.png}" alt="">
                    </h1>

                    <div class="header-extra">

                        <!--搜索-->
                        <div id="mallSearch" class="mall-search">
                            <form name="searchTop" class="mallSearch-form clearfix">
                                <fieldset>
                                    <legend>天猫搜索</legend>
                                    <div class="mallSearch-input clearfix">
                                        <div class="s-combobox" id="s-combobox-685">
                                            <div class="s-combobox-input-wrap">
                                                <input v-model="keyword" type="text" autocomplete="off" value="dd" id="mq"
                                                       class="s-combobox-input" aria-haspopup="true">
                                            </div>
                                        </div>
                                        <button type="submit" @click.prevent="searchKey" id="searchbtn">搜索</button>
                                    </div>
                                </fieldset>
                            </form>
                            <ul class="relKeyTop">
                                <li><a>狂神说Java</a></li>
                                <li><a>狂神说前端</a></li>
                                <li><a>狂神说Linux</a></li>
                                <li><a>狂神说大数据</a></li>
                                <li><a>狂神聊理财</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 商品详情页面 -->
        <div id="content">
            <div class="main">
                <!-- 品牌分类 -->
                <form class="navAttrsForm">
                    <div class="attrs j_NavAttrs" style="display:block">
                        <div class="brandAttr j_nav_brand">
                            <div class="j_Brand attr">
                                <div class="attrKey">
                                    品牌
                                </div>
                                <div class="attrValues">
                                    <ul class="av-collapse row-2">
                                        <li><a href="#"> 品牌名 </a></li>
                                        <li><a href="#"> Java </a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <!-- 排序规则 -->
                <div class="filter clearfix">
                    <a class="fSort fSort-cur">综合<i class="f-ico-arrow-d"></i></a>
                    <a class="fSort">人气<i class="f-ico-arrow-d"></i></a>
                    <a class="fSort">新品<i class="f-ico-arrow-d"></i></a>
                    <a class="fSort">销量<i class="f-ico-arrow-d"></i></a>
                    <a class="fSort">价格<i class="f-ico-triangle-mt"></i><i class="f-ico-triangle-mb"></i></a>
                </div>

                <!-- 商品详情 -->
                <div class="view grid-nosku">

                    <div class="product" v-for="result in results">
                        <div class="product-iWrap">
                            <!--商品封面-->
                            <div class="productImg-wrap">
                                <a class="productImg">
                                    <img :src="result.img">
                                </a>
                            </div>
                            <!--价格-->
                            <p class="productPrice">
                                <em>{{result.price}}</em>
                            </p>
                            <!--标题-->
                            <p class="productTitle">
                                <a v-html="result.title"> </a>
                            </p>
                            <!-- 店铺名 -->
                            <div class="productShop">
                                <span>店铺： 店铺名 </span>
                            </div>
                            <!-- 成交信息 -->
                            <p class="productStatus">
                                <span>月成交<em>999笔</em></span>
                                <span>评价 <a>3</a></span>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 前端使用vue，使用先后端分离 -->
<script th:src="@{/js/axios.min.js}"></script>
<script th:src="@{/js/vue.min.js}"></script>
<script>

    new Vue({
        el:'#app',
        data: {
            keyword: '',    // 搜索的关键字
            results: []     // 搜索的结果
        },
        methods: {
            searchKey(){
                var keyword = this.keyword;
                console.log(keyword);
                // 对接后端的接口
                axios.get('search/'+keyword+"/1/10").then(response=>{
                    console.log(response.data);
                    this.results = response.data; // 绑定数据
                })
            }
        }
    })

</script>

</body>
</html>
```

测试效果

![image-20220121214701180](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220121214711.png)

