## Java 分布式编程  
### 常见分布式ID生成方案
   * `UUID` 通用唯一识别码，字符串太长，无业务含义，存储性能差，实际项目中用的不多。  
   * `基于数据库自增id` 基于`auto_increment`每次插入时返回自增id，实现简单，但是单点有宕机且难扛住分布式高并发场景。
   * `数据库集群模式` 是对单点数据库宕机的优化，采用主从模式，给数据库自增id设置起始值和自增步长，解决单点宕机风险，但是单个数据库的高并发场景压力依旧很大。  
   * `数据库号段模式` 每次从数据库取一段id值，用完再取，减少数据库请求次数，解决高并发数据库瓶颈。
   * `Redis方式` 基于redis的`incr`命令也可以实现。考虑Redis的持久化问题，RDB定时打快照方式持久化重启会有数据丢失情况，导致ID重复；AOF每条修改指令都记录，不会ID重复，重启恢复数据时间过长。  
   * `Snowflake(雪花算法)模式` Twitter开源的分布式ID生成方案，备受国内大厂关注。  
   * `uid-generator（百度）` 百度基于snowflake开发的分布式ID生成方案。  
   * `Leaf(美团)` Leaf同时支持号段模式和snowflake算法模式，可以切换使用。  
   * `Tinyid(滴滴)` Tinyid是滴滴基于号段模式开发的分布式ID生成方案。  
   详解常用 `基于数据库号段模式` 和 `Snowflake(雪花算法)模式`  
   > **基于数据库的号段模式**
   > > `号段模式` 是当下分布式ID生成器的主流实现方式之一。 号段模式每次取出一定范围的号段，加载到内存中，给具体的服务使用。  
   > > ```sql
   > > CREATE TABLE id_generator (
   > > id int(10) NOT NULL,
   > > max_id bigint(20) NOT NULL COMMENT '当前最大id',
   > > step int(20) NOT NULL COMMENT '号段的步长',
   > > biz_type	int(20) NOT NULL COMMENT '业务类型',
   > > version int(20) NOT NULL COMMENT '版本号',
   > > PRIMARY KEY (`id`)
   > > )
   > > ```  
   > > version ：是一个乐观锁，每次都更新version，保证并发时数据的正确性。等这批号段ID用完，再次向数据库申请新号段，对max_id字段做一次update操作，update max_id= max_id + step，update成功则说明新号段获取成功，新的号段范围是(max_id ,max_id +step]。由于多业务端可能同时操作，所以采用版本号version乐观锁方式更新，这种分布式ID生成方式不强依赖于数据库，不会频繁的访问数据库，对数据库的压力小很多。
   >  
   > **基于Snowflake(雪花算法)**  
   > > `雪花算法` 生成的是Long类型的ID，一个Long类型占8个字节，每个字节占8比特，也就是说一个Long类型占64个比特。
   > > Snowflake ID组成结构：`正数位`（占1比特）+ `时间戳`（占41比特）+ `机器ID`（占5比特）+ `数据中心`（占5比特）+ `自增值`（占12比特），总共64比特组成的一个Long类型。  
   > > * 第一个bit位（1bit）：Java中long的最高位是符号位代表正负，正数是0，负数是1，一般生成ID都为正数，所以默认为0。  
   > > * 时间戳部分（41bit）：毫秒级的时间，不建议存当前时间戳，而是用（当前时间戳 - 固定开始时间戳）的差值，可以使产生的ID从更小的值开始；41位的时间戳可以使用69年，(1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69年。  
   > > * 工作机器id（10bit）：也被叫做workId，这个可以灵活配置，机房或者机器号组合都可以。  
   > > 序列号部分（12bit），自增值支持同一毫秒内同一个节点可以生成4096个ID。  
   > 
   > [参考文章](https://zhuanlan.zhihu.com/p/107939861)
### 常见(分布式)任务调度方式
  * `Timer` Java自带的解决任务调度方案，支持按照固定频率执行，所有的TimerTask在同一个线程串行执行。如果某一个TimerTask异常，线程退出，所有定时任务都失败。  
  * `ScheduledExecutorService` 基于线程池的定时任务解决方案，解决TimerTask定时器无法并行执行问题，支持固定频率和延迟一定时间执行。  
  * `Spring Task` Springboot提供了一套轻量级的定时任务工具Spring Task。支持cron表达式、固定频率、延迟一定时间执行。  
  * `Quartz` 一套轻量级的任务调度框架，主要包含Job、JobDetail、Trigger、Scheduler等核心类，支持基于数据库的集群模式。基于DB抢锁，性能较差；不支持动态修改或添加任务。  
  * `ElasticJob` 是一款基于 Quartz 开发，依赖 Zookeeper 作为注册中心、轻量级、无中心化的分布式任务调度框架，目前已经通过 Apache 开源。支持任务分片，使用Zookeep作为注册中心，不需要抢锁触发，性能比quatrz强大。ElasticJob 还提供了一个简单的 UI，可以查看任务的列表，同时支持修改、触发、停止、生效、失效操作。遗憾的是，ElasticJob 暂不支持动态创建任务。  
  * `xxl-job` 一个开箱即用的轻量级分布式任务调度系统。支持动态修改和添加任务。不过，XXL-JOB 所有功能都依赖数据库，且调度中心不支持分布式架构，在任务量和调度量比较大的情况下，会有性能瓶颈。如果对任务量级、高可用、监控报警、可视化等没有过高要求的话，XXL-JOB 基本可以满足定时任务的需求。  
  [参考文章@Java 定时任务技术趋势](https://baijiahao.baidu.com/s?id=1729960266642619995)