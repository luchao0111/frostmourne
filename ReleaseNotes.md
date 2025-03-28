# 1.0-SNAPSHOT

### Feature

* 【1.0】发布0.9-RELEASE, 开始1.0-SNAPSHOT开发 [2022-09-19]
* 【1.0】数据名增加名称模糊查询 [2022-09-25]
* 【1.0】prometheus增加/api/v1/query_range查询支持 [2022-10-08]

### Other

* 【1.0】启动脚本优化，多版本jar包使用最新版本启动 [2022-09-23]

# 0.9.1-RELEASE

### Bugfix

* 【0.9.1】修复 http, telent 等无数据源的类型，获取 数据源 settings 报空指针问题 [2022-09-22]

# 0.9-RELEASE

### Feature

* 【0.9】发布0.8-RELEASE, 进入0.9开发 [2022-06-09]
* 【0.9】增加telnet端口连通监控 [2022-06-09]
* 【0.9】增加SqlServer数据监控报警 [2022-06-30]
* 【0.9】监控列表增加监控调度时间查看 [2022-08-04]
* 【0.9】优化启动脚本，支持java11, java13 [2022-08-04]
* 【0.9】告警列表组件新增日志查询 [2022-08-13]
* 【0.9】数据源及数据名页面数据类型新增icon [2022-08-13]
* 【0.9】后端接口增加部分数据校验并返回合适的提示信息 [2022-08-17]
* 【0.9】启动增加时区参数TZ配置 [2022-08-19]
* 【0.9】敏感信息加密处理 [2022-09-19]

### BugFix

* 【0.9】修复飞书消息发送两条的问题 [2022-06-17]

### Document

* 【0.9】增加telnet端口监控使用指南 [telnet.md](./doc/wiki/telnet.md) [2022-06-09]

### Thanks

0.9-RELEASE大部分功能由 [@limbo](https://github.com/limboinf) 贡献，感谢！

# 0.8-RELEASE

### Feature

* 【0.8】 发布0.7.1-RELEASE, 进入0.8-SNAPSHOT开发版 [2022-05-14]
* 【0.8】邮箱报警支持ssl [2022-05-15]
* 【0.8】增加报警升级功能 [2022-05-15]
* 【0.8】增加国际化支持 [2022-05-28]
* 【0.8】mysql, clickhouse表达式规则增加TOP 50条记录数据TOP_N_DOCUMENTS [2022-05-31]
* 【0.8】Elasticsearch数值实现环比监控 [2022-06-07]
* 【0.8】influxdb数值实现环比监控 [2022-06-09]
* 【0.8】增加 [iotdb](https://github.com/apache/iotdb) 数据监控报警 [2022-06-09]

### BugFix

* 【0.8】解决logo不显示的问题 [2022-05-17]
* 【0.8】解决关闭数据库连接错误调用clone方法的问题 [gitee#I58JI1](https://gitee.com/tim_guai/frostmourne/issues/I58JI1) [2022-05-21]
* 【0.8】优化druid连接参数，修复连接超时后无法执行sql的问题 [2022-05-27]
* 【0.8】解决消息模板列表模板类型不显示的问题 [2022-06-07]

### Mysql

* 【0.8】alert_event表新增upgrade字段; recipient新增recipient字段; 新增alert_upgrade表 - [SQL](./doc/mysql-schema/2022-05-15/change.sql) [2022-05-15]

### Others

* 【0.8】frostmourne-core改名为frostmourne-common [2022-05-18]
* 【0.8】metric注入逻辑重构，去掉metric map构造改成自动注入 [2022-06-09]

# 0.7.1-RELEASE

### Feature

* 发布0.6.2-RELEASE [2022-05-05]
* 【0.7】静默优化，支持字段判断表达式 [2022-05-05]
* 【0.7】mysql, clickhouse监控增加表达式监控规则 [2022-05-06]
* 【0.7】增加ping监控报警 [2022-05-07]
* 【0.7】增加[skywalking](https://github.com/apache/skywalking)日志数据监控 [2022-05-09]
* 【0.7】增加[skywalking](https://github.com/apache/skywalking)报警数据监控 [2022-05-10]
* 【0.7】增加[prometheus](https://github.com/prometheus/prometheus)数据监控报警支持 [2022-05-12]
* 【0.7.1】增加判断规则：持续n次满足规则时报警 [2022-05-13]

### Bugfix:

* 【0.7】bugfix: 解决http消息模板不加载的问题 [2022-05-12]

### Mysql

* 【0.7】alert表新增silence_expression字段，新增alert_event表 - [SQL](./doc/mysql-schema/2022-05-02/change.sql)[2022-05-05]
* 【0.7.1】alarm_log表新增alert字段 - [SQL](./doc/mysql-schema/2022-05-10/change.sql)[2022-05-13]


### Document

* 【0.7】增加SkyWalking数据监控使用指南 [skywalking.md](./doc/wiki/skywalking.md) [2022-05-10]
* 【0.7】增加Prometheus数据监控使用指南 [prometheus.md](./doc/wiki/prometheus.md) [2022-05-12]

# 0.6.2-RELEASE

### Feature

* 移除spi模块，相关功能移至monitor [2022-04-05]
* 微信机器人、钉钉机器人和http报警消息格式支持markdown - [SQL](./doc/mysql-schema/2022-04-14/change.sql) [2022-04-15]
* 增加用户密码设置功能，方便没有部署ldap的团队使用。配置了ldap的将优先使用ldap认证。 - [SQL](./doc/mysql-schema/2022-04-10/change.sql) [2022-04-10]
* 移除xxl-job依赖，内置实现分布式调度，减小部署难度 - [SQL](./doc/mysql-schema/2022-04-17/change.sql) [2022-04-18]
* elasticsearch数据源https支持pkcs12证书 [issue#71](https://github.com/AutohomeCorp/frostmourne/issues/71) [2022-04-25]
* 数据预览前端增加参数校验提示 [2022-04-28]
* 数据源增加Elasticsearch8支持 [issue#73](https://github.com/AutohomeCorp/frostmourne/issues/73) [2022-05-02]
* 【0.6.2】 Elasticsearch数据配置支持数据分桶，分桶类型支持：1. 按字段值分组，相当于ES里的Terms Aggregation. [issue#56](https://github.com/AutohomeCorp/frostmourne/issues/56) [issue#29](https://github.com/AutohomeCorp/frostmourne/issues/29) - [SQL](./doc/mysql-schema/2022-05-03/change.sql) [2022-05-04]
* 【0.6.2】 Elasticsearch数据配置支持数据分桶，分桶类型支持：2. 按时间分组,相当于ES里的DateHistogramAggregation. [issue#56](https://github.com/AutohomeCorp/frostmourne/issues/56) [issue#29](https://github.com/AutohomeCorp/frostmourne/issues/29) [2022-05-04]

### Bugfix

* 解决查询elasticsearch索引字段查询报错的问题 [2022-04-27]

### Mysql

* mysql: rule表增加消息模板内容类型字段：alert_template_type - [SQL](./doc/mysql-schema/2022-04-14/change.sql) [2022-04-15]
* mysql: user_info表增加密码字段password - [SQL](./doc/mysql-schema/2022-04-10/change.sql) [2022-04-10]
* mysql: 增加数据库分布式锁表job_lock，alarm表增加两个字段：trigger_last_time, trigger_next_time - [SQL](./doc/mysql-schema/2022-04-17/change.sql) [2022-04-18]
* [0.6.2] mysql: metric表增加字段bucket_type，bucket_field - [SQL](./doc/mysql-schema/2022-05-03/change.sql) [2022-05-04]

### Document

* 增加0.5升级0.6的说明文档 [upgrade-0.6.md](./doc/wiki/upgrade-0.6.md) [2022-04-07]
* 增加markdown格式消息使用文档说明 [template_markdown.md](./doc/wiki/template_markdown.md)
* 增加0.6升级0.6.1的说明文档 [upgrade-0.6.1.md](./doc/wiki/upgrade-0.6.1.md) [2022-04-19]
* 增加k8s环境部署说明 [2022-04-21]
* 增加项目代码规范说明文档 [code_format](./doc/wiki/code_format.md) [2022-04-23]

### Others

* 优化frostmourne-vue模块，支持较新版本node和npm支持; 引入frontend-maven-plugin插件，打包自动管理node和yarn使用特定版本 [2022-04-25]

# 0.5-RELEASE

### Feature

* 报警方式增加飞书机器人 [2021-10-30]
* http监控兼容异常状态码 [2021-11-06]
* 恢复通知默认改为关闭 [2022-02-16]
* elasticsearch数据监控增加查询链接配置，例如可以设置查询链接为kibana链接，查询链接将优先使用kibana链接。 [2022-03-09]
* 内置实现一个短链接功能，移除外部短链接服务依赖，解决外部短链接服务请求比较慢的问题 [2022-03-09]

### Bugfix

* bugfix: 解决某些情况下，从elasticsearch中查询数据count大于0，但是hit数组为空的问题 [issue#43](https://github.com/AutohomeCorp/frostmourne/issues/43) [2021-07-27]
* bugfix: 解决不报警并且关闭恢复通知的时候，没有记录执行日志的问题。 [issue#53](https://github.com/AutohomeCorp/frostmourne/issues/53) [2022-03-07]

### Mysql

* mysql: alert表增加字段feishu_robot_hook，表示飞书机器人地址 - [SQL](./doc/mysql-schema/2021-10-30/change.sql) [2021-10-30]
* mysql: 增加短链接表short_link - [SQL](./doc/mysql-schema/2022-03-08/short_link.sql) [2022-03-08]
* mysql: 增加配置表config_map - [SQL](./doc/mysql-schema/2022-03-08/config_map.sql) [2022-03-08]

### Document

* 修改短链接部分文档说明, 移除外部短链接依赖 [2022-03-10]
* 增加如何配置报警消息头的方法说明 [2022-03-10]

### Others

* log4j2升级至2.17.1 [2022-01-14]

# 0.4-RELEASE

### Feature

* 实现influxdb数值监控 [2020-09-19]
* 增加influxdb数值同比监控 [2020-09-19]
* 增加mysql数据监控报警支持 [2020-11-15]
* 重构: 抽象一层监控数据读取层，对接新的数据存储只需要实现抽象层接口就可以对接完成 [2020-11-20]
* 监控配置增加是否发送恢复通知的开关选项 [issue#24](https://github.com/AutohomeCorp/frostmourne/issues/24) [2020-12-05]
* 监控保存逻辑，增加测试运行步骤，测试运行通过后才可以保存 [2021-01-11]
* 监控编辑页面：增加查询数据预览功能 [2021-02-28]
* Elasticsearch数据源增加https选项设置 [2021-03-13]
* 报警消息头文字支持自定义配置 [2021-04-17]
* 短链接增加百度短链接支持 [2021-04-17]
* Elasticsearch数据源支持HTTPS [2021-04-28] [issue#35](https://github.com/AutohomeCorp/frostmourne/issues/35)
* 增加clickhouse数据监控报警支持 [2021-05-09]
* InfluxDB支持用户名密码设置 [2021-05-09]
* http方式发送消息，post内容增加监控上下文数据字段context [2021-05-11]
* Elasticsearch数据名增加查询显示字段配置 [2021-05-27]
* 编辑Elasticsearch监控增加索引字段下拉提示 [2021-05-28]

### Bugfix

* 解决登录跳转链接没有带上参数的问题 [2020-09-26]
* 解决http请求没有正确带上头信息的问题 [issue#30](https://github.com/AutohomeCorp/frostmourne/issues/30) [2020-12-17]
* es数据查询，下载请求改为post，解决可能由于scrollid过长导致请求非法的问题 [2021-01-11]
* 解决mysql监控，语句执行报错的问题 [issue#32](https://github.com/AutohomeCorp/frostmourne/issues/32) [2021-02-01]
* 修复用户编辑输入无效的问题 [2021-04-17]

### Mysql

* mysql: alarm表增加字段recover_notice_status，表示是否开启恢复通知 - [SQL](./doc/mysql-schema/2020-11-29/change.sql) [2020-12-05]
* mysql: data_source表字段properties类型改为text - [SQL](./doc/mysql-schema/2021-04-21/change.sql) [2021-04-28]

### Document

* doc: 增加influxdb数据监控使用指南 [2020-09-24]
* doc: 增加mysql数据监控使用指南 [2020-09-24]
* doc: 增加clickhouse数据监控报警使用指南 [2021-05-11]

# 0.3-RELEASE

### Feature

* 监控列表增加按团队查询，默认只显示自己团队的监控；监控按部门隔离 [2020-07-22]
* Elasticsearch监控数值实现同比监控 [2020-07-24]
* Elasticsearch数据源更新免重启加载 [2020-07-25]
* 集成LDAP登录认证 [2020-07-25]
* 数据名保存表单数据提交增加前端验证 [2020-07-22]
* 菜单增加权限控制，部分页面(如：数据源配置)只对管理员开放 [2020-07-27]
* Elasticsearch查询增加历史语句自动提示 [2020-07-27]
* Elasticsearch查询数据柱状图可点击并自动变更时间范围 [2020-07-28]
* 另存时，监控名称增加(copy)字样标识，名字和原监控区分开 [2020-08-01]
* 报警消息模板管理功能 [2020-08-10]
* 账号增加角色(管理员，普通用户)设置功能 [issue#18](https://github.com/AutohomeCorp/frostmourne/issues/18) [2020-08-18]
* 聚合类型(unique_count, percentiles, standard deviation)数值监控
* 增加服务管理，监控可以和服务关联,监控列表增加按服务查询条件 [2020-09-03]
* 如果监控关联了服务，报警接收人自动增加对应的服务负责人 [2020-09-05]
* 监控增加风险等级设置(提示，重要，紧急，我崩了),报警消息添加风险等级信息 [2020-09-05]

### Bugfix

* bugfix: 解决列表分页问题
* bugfix: 解决Elasticsearch数据嵌套时，数据值为undefine的问题 [issue#11](https://github.com/AutohomeCorp/frostmourne/issues/11) [2020-08-01]
* bugfix: 解决部分浏览器下表头和表内容有点错位的问题 [2020-09-05]
* bugfix: 解决数据查询页面，不查询可以直接点击加载更多的问题 [2020-09-05]

### Mysql

* mysql: alarm表增加风险等级字段risk_level - [SQL](./doc/mysql-schema/2020-07-24/change.sql)
* mysql: 增加消息模板表alert_template - [SQL](./doc/mysql-schema/2020-07-31/alert_template.sql)
* mysql: 增加用户角色表user_role - [SQL](./doc/mysql-schema/2020-08-18/user_role.sql)
* mysql: 增加服务表 - [SQL](./doc/mysql-schema/2020-09-01/change.sql)

### Document

* 增加Elasticsearch数据监控使用指南 [2020-08-27]
* 增加同比监控使用指南 [2020-08-29]
* 增加ORM层选型的说明 [2020-09-05]

### Other

* mybatis-generator-maven-plugin依赖的mysql-connector升级为8.0.20
* 默认镜像服务改用阿里云
* 数据库访问层全部换成[mybatis-dynamic-sql](https://github.com/mybatis/mybatis-dynamic-sql) [2020-07-30]
* 替掉蛇形命名字段，全部改为驼峰，统一代码风格 [2020-09-08]

# 0.2-RELEASE

### Feature

* 用户，团队，部门增加应用外配置文件的维护方式
* 增加数据导出CSV功能
* 增加Elasticsearch查询分享功能
* 增加HTTP报警方式
* 增加企业微信报警方式
* elasticsearch监控增加avg,min,max,sum数值metric类型
* 缺少短链接或短链接失败的情况下，使用原链接
* 数据查询页面增加创建监控跳转按钮
* 增加dockerfile和docker-compose
* HTTP监控增加头设置
* 报警接收人设置时给出提示
* 增加企业微信机器人消息发送方式 [2020-07-05]
* 用户信息，团队信息，部门信息外部文件增加定期重新加载 [2020-07-05]
* 账号管理功能模块 [2020-07-11]

### Bugfix

* bugfix: 解决dataname还在使用中，仍然可以删除的问题
* bugfix: 解决elasticsearch 7+版本，数据数量为0的问题
* bugfix: 解决邮箱需要认证的情况下，邮件发送失败的问题
* bugfix: 解决消息过长无法保存的问题

### Mysql

* mysql: alert表增加字段: http_post_url - [SQL](./doc/mysql-schema/2020-06-01/change.sql)
* mysql: data_name表增加data_name字段唯一索引 - [SQL](./doc/mysql-schema/2020-06-13/change.sql)
* mysql: alert表增加字段: wechat_robot_hook - [SQL](./doc/mysql-schema/2020-07-04/change.sql)
* mysql: 增加user_info, team_info, department_info表 - [SQL](./doc/mysql-schema/2020-07-11/change.sql)
* mysql: alarm_log表字段message类型改为text；alert_log字段content类型改为text - [SQL](./doc/mysql-schema/2020-07-16/change.sql)

### Document

* 增加query string简易教程
* 增加docker启动说明文档

### Others

* Elasticsearch-Rest-Client升级至6.6.2
* 升级guava至28.2-jre
* 引入[mybatis-dynamic-sql](https://github.com/mybatis/mybatis-dynamic-sql)
* springboot升级至2.3.1-RELEASE
* 引入[maven-ci-friendly](https://maven.apache.org/maven-ci-friendly.html)实践 [2020-07-18]
* 使用[autolog4j](https://github.com/AutohomeCorp/autolog4j)程序日志格式 [2020-07-19]
* 文本日志按天滚动 [2020-07-19]

# 0.1-RELEASE

* Elasticsearch数据监控, 你只需要写一条查询就可以轻松搞定监控
* HTTP数据监控
* UI功能，简单易用
* 监控管理
* 灵活的报警消息模板定制，支持变量
* 多种消息发送方式(email,短信,钉钉(机器人))
* 多数据源管理
* Elasticsearch数据查询页面
* 报警消息附带日志查询短链接，直达报警原因
* 报警消息抑制功能，防止消息轰炸
