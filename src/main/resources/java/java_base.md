## JAVA_BASE
 ### String 的不可变
   * String被final修饰是不可变类，不能被继承。  
   * String中存储数据的数组被private和final修饰(private final char value[];)。final使char数组的引用地址不可变，private私有化使数组value不能被外部类修改，不过不可变的`核心因素`是String中没有提供修改char数组value的public方法。  
 ### String、StringBuilder、StringBuffer 区别  
   #### 线程安全  
   > 1.`String 线程安全` 其不可变保证其线程安全。  
   > 2.`StringBuilder 非线程安全` StringBuilder 没有对方法加同步锁(synchronized)。  
   > 3.`StringBuffer 线程安全` StringBuffer 对方法加了同步锁(synchronized)全。(StringBuilder 和 StringBuffer 都继承了AbstractStringBuilder类，存储用的char数组在抽象类中)  
   #### 性能
   > 1.`String` 每次修改都会创建新对象，然后将引用指向新的对象。  
   > 2.`StringBuilder` 每次修改是修改对象本身，单线程效率更高(数据量大)。  
   > 3.`StringBuffer` 每次也是修改对象本身，多线程中保证线程安全。  
 ### final关键字
   * 修饰`类`，不能被继承，类中所有方法被隐式指定未final。  
   * 修饰`方法`，不能被重写(继承), 可以任意重载。  
   * 修饰`变量(成员变量、局部变量)`，`基础变量`是值不能被更改，`引用变量`是引用地址值不可被更改(地址所指的对象value可变)。final修饰变量需要声明时被赋值或者类构造方法中赋值。  
   > ```java
   > /**
   > * todo 思考原因？
   > * 1.final 修饰的变量编译的时候会被优化认为是常量。  
   > * 2."+" 号两边如果都是常量，编译时jvm会直接优化看成一个常量。  
   > * 3."+" 号两边有引用类型，通过反编译(javap -c 或者可通过idea查看)后,  
   > *   看到是通过new StringBuilder对象调用append()来实现的。  
   > * 4."+" 号两边有null时，查看StringBuilder源码可看到对null时会被转成字符串"null"。
   > **/
   > public void finalTest() {
   >    String a = "hello2";
   >    final String b = "hello";
   >    String e = "hello";
   >    String c = b + "2";
   >    String d = e + "2";
   >    String f = "hello" + "2";
   >
   >    System.out.println(a == c); // true
   >    System.out.println(a == d); // false
   >    System.out.println(b == e); // true
   >    System.out.println(a == f); // true
   > }
   > ```
 ### Java中只有值传递
   * 对于`基本类型`, 方法的形参相当于copy一份。因此，对形参的修改不会影响实参。  
   * 对于`引用类型`, 方法的形参其实是引用对象的`内存中地址值`。因此，对形参修改不会影响实参(地址值)，但是对`引用对象`的修改会改变实参。  
 ### 循环中 continue、break、return 区别
   * continue 结束本次循环继续执行下一次循环；  
   * break 直接跳出其最近的一层循环(如果加了标识，就会直接跳到标识所在层循环)；  
   * return 直接跳出多层循环；  
 ### 序列化
   * 什么是序列化？  
     > **序列化** 是将内存中对象信息转化为可存储(传输)的字节序列过程。  
     > **反序列化** 是将磁盘(网络传输)中的字节序列转化为具体的对象过程。  
   * 序列化的原因？  
     > 需要将内存中数据存储到磁盘或者通过网络传输出去。**序列化最终目的** 是为了`跨平台存储`或者`网络传输`，而跨平台和网络传输的方式是 **IO** ，IO支持的数据结构是字节数组。  
   * 常见的序列化方式  
     > jdk自带，xml序列化，**JSON**（fastJSON、Jackson、Gson），**ProtoBuf**，Hessian，Kryo等。  
 ### Java两种动态代理
   * JDK动态代理
     > * 需要`接口`代理类和被代理类实现统一接口，实现InvocationHandler(把被代理对象传给Invocation)；  
     > * 代理类中通过`反射`拿到被代理类的方法，调用代理类的方法时会拿被代理类的方法去Invocation中去执行；  
   * CGLB动态代理
     > * 不需要接口，是通过`继承`被代理类实现;
     > * `动态生成继承子类(代理)` 通过调用代理对象的方法，跳转到自定义拦截器中进行代码增强，增强后调用父类的方法;  
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
   > [@origin](https://zhuanlan.zhihu.com/p/107939861)







