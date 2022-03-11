## Notes
### 破解TOOL
 * [破解工具URL](https://www.ajihuo.com/)
 * [IDEA2021.3.2 永久激活](https://mp.weixin.qq.com/s/IAPjkBIGmDF9SrLg_ZoYEw)
 * [IntelliJ IDEA激活码-持续更新](https://docs.qq.com/doc/DTVh3bkxWSEpvVm5N)
 * [JetBrains 系列IDE官方版及白嫖教程](https://www.nite07.com/jetbrains/)
 * [JetBrains 全系列软件激活教程激活码以及JetBrains系列软件汉化包](https://www.macwk.com/article/jetbrains-crack)  
### Java
 * [Java_Base](./src/main/resources/java/java_base.md)
 * [Java 相关收藏文章](./src/main/resources/java/java_collections.md)
 * [Java_相关经典问题](./src/main/resources/java/java_issues.md) 
### Netty  
 * [【硬核】肝了一月的Netty知识点](https://aobing.blog.csdn.net/article/details/113174359)  
### Protocol Buffer  
 * `Protocol Buffer` Google开源的一种序列化结构数据的方式。其具有平台无关、语言无关、更小、更快等特点，序列化后的二进制格式使其序列化过程更快，压缩后内存更小使其传输更高效。  
  > [Protocol Buffer 文章](https://carsonho.blog.csdn.net/article/details/70037693)  
  > [什么是 Protocol Buffer?](https://zhuanlan.zhihu.com/p/143627360)  
  > [Protocol Buffer是什么?](https://zhuanlan.zhihu.com/p/126241266)
### Redis
  * [Redis 相关记录](./src/main/resources/redis/redis_note.md)  
### MQ(Message Queue)  
 * [消息队列经典十连问](https://mp.weixin.qq.com/s/VtpG4uYtG7ZX7AjTVSvqmg)
### 网络相关
  #### Net_Collection
  * [如果让你来设计网络，你会把它弄成啥样?](https://mp.weixin.qq.com/s/LzskZWr97vhtQ1QwQNCsJw)
  * [阿里云面试：拔掉网线后， 原本的 TCP 连接还存在吗？](https://mp.weixin.qq.com/s/0YFsUWL6e9r_aDrCZeTK3w)  
  * [面试题：40 张图解 TCP 三次握手和四次挥手](https://mp.weixin.qq.com/s/Yq4mVDRyMmcc3bJpXOWEww)  
  * [一台机器最多能创建多少个 TCP 连接？](https://mp.weixin.qq.com/s/TvYE46uZsekqbBvdI9gD-A)  
### Git
  * [Git 常用命令记录](./src/main/resources/git/git_note.md)
### UNIX五种I/O模型
#### 1.阻塞I/O(同步)
  传统的阻塞IO过程中存在accept和read两个地方阻塞。accept阻塞等待连接，read阻塞等待数据从网卡(或者磁盘)中读取到用户缓冲区buf。  
#### 2.非阻塞I/O(同步)
  非阻塞IO通过多线程的方式，每accept一个连接的时候都创建一个线程，在每个线程中用循环去read数据，通过设置操作系统提供的数据没准备好时返回负1的功能，来避免线程阻塞在read上。非阻塞只是在数据未准备好前不会阻塞主线程，但是read方法还是阻塞的，非阻塞IO不是真正意义上的非阻塞，只是通过多线程的手段在用户层做的小把戏。  
#### 3.I/O多路复用(同步阻塞)
  IO多路复用是通过系统提供的select(阻塞)把连接的客户端的文件描述符(fd)放在集合中发给操作系统，由操作系统来循环判断是否有数据准备好了，
然后告诉用户数据准备好的线程个数，用户再遍历去执行数据准备好的线程。  
不过，IO多路复用有几个弊端：
  * 1.高并发时调用select时的文件描述符数组的拷贝会消耗性能;
  * 2.内核仍然是通过遍历来判断数据是否准备好，是个同步过程;
  * 3.select返回的是可读文件描述符的个数，具体哪个可读还需要用户自己遍历判断;  
  
  poll 去掉了select只能监听1024个文件描述符的限制。  
  epoll 优化了select上边的三个不足:
  * 每次调用不在拷贝，而是每次告诉内核修改的fd，内核会保存一份fd记录;
  * 内核不再通过轮询的方式找就绪的文件描述符，而是通过异步IO事件唤醒;
  * epoll_wait直接返回具体就绪的fd;(这里epoll_wait会同步阻塞和调用select类似)。  

#### 4.信号驱动式I/O(同步非阻塞)
信号驱动IO是先建立SIGIO的信号处理程序，系统调用执行一个信号处理函数，请求会立即返回。当数据准备就绪时，会生成对应进程的SIGI信号，通过信号回调通知对应线程来读数据。然后数据再由内核空间拷贝到用户空间。  

#### 5.异步I/O(异步非阻塞)
异步IO是应用给内核发送一个read的请求后，方法立刻返回。内核收到请求后建立一个信号联系，当数据准备就绪，内核会主动将数据拷贝到用户空间，操作完成后，内核会发一个信号通知应用。 
> [你管这破玩意叫 IO 多路复用？](https://mp.weixin.qq.com/s?__biz=Mzk0MjE3NDE0Ng==&mid=2247494866&idx=1&sn=0ebeb60dbc1fd7f9473943df7ce5fd95&chksm=c2c5967ff5b21f69030636334f6a5a7dc52c0f4de9b668f7bac15b2c1a2660ae533dd9878c7c&scene=21#wechat_redirect)  

