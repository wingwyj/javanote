## Redis相关记录
 ### redis的常见五种数据结构  
  * `string` string类型是而二进制的，意味着可以是包含任何数据(最大长度是512M)；  
  * `list` 按着插入的顺序排序，底层是双向链表插入快索引慢；  
  * `hash` 键值对集合。和java中的Map类似；  
  * `set` 是一个string类型的无序列表，和list的区别就是可以去重，地层是一个hash表；  
  * `sorted set` (zset)一个没有重复元素的字符串集合，每个集合成员都关联一个评分(score)，且按着评分从低到高排序；   
 ### redis为什么这么快？
  * **基于内存存储实现**  
    > redis是基于内存存储实现的数据库，相对于磁盘的mysql数据库，免去了很多I/O消耗，所以比磁盘快很多。  
  * **高效的数据结构**  
    > redis自身使用 C 语言编写，有很多优化机制，比如动态字符串 sds，跳跃表等。  
  * **合理的数据编码**  
    > 每种基本类型对应多种存储数据结构，什么时候用什么样的数据结构，什么样的编码，redis设计者都有总结优化。如: String：如果存储数字的话，是用int类型的编码;如果存储非数字，小于等于39字节的字符串，是embstr；大于39个字节，则是raw编码。  
  * **合理的线程模型**
    > redis中核心命令的执行是单程执行的，客户端的读写(输入/输出)是采用的I/O多路复用机制。redis中的其他模块也有各自的线程。  
  * **虚拟内存机制**  
    > 虚拟内存机制就是暂时把不经常访问的数据(冷数据)从内存交换到磁盘中，从而腾出宝贵的内存空间用于其它需要访问的数据(热数据)。通过VM功能可以实现冷热数据分离，使热数据仍在内存中、冷数据保存到磁盘。这样就可以避免因为内存不足而造成访问速度下降的问题。  
 ### 什么是缓存击穿、缓存穿透、缓存雪崩？
  * TODO
 ### 收藏文章
  * [把Redis当作队列来用，真的合适吗？](https://mp.weixin.qq.com/s/RthQvzLHZRGNo-z6X_7jQQ)
  * [Redis分布式锁到底安全吗？](https://mp.weixin.qq.com/s/RnSokJxYxYDeenOP_JE3fQ)
  * [`万字长文` 一文讲透如何排查Redis性能问题！](https://mp.weixin.qq.com/s/Bg08b7ifMo6D4KhiTIj_3A)
  * [Redis 突然变慢了如何排查并解决？](https://mp.weixin.qq.com/s/eGDxmt2tIaoW9qzqNvQH0A)  
  * [Redis 缓存击穿（失效）、缓存穿透、缓存雪崩怎么解决？](https://mp.weixin.qq.com/s/K7nwfmgaplfBuVMc_QaxAQ)  
  * [20道经典Redis面试题](https://blog.csdn.net/weixin_40205234/article/details/124614720)  
