## Java 相关问题  
 ### ArrayList 源码中为什么可分配的存储数组的最大值 MAX_ARRAY_SIZE = = Integer.MAX_VALUE - 8;  
  * 因为有些虚拟机会在数组中保存 header words 头部字。  
  * Java对象在堆内存中的存储布局可以分为三部分：对象头（object header），实例数据（Instance Data）和对齐填充（Padding）。  
   > **header(对象头)包括：**
   > > * Mark Word：用于对象自身的运行时数据存储，如HashCode，GC分代年龄，锁状态标志，线程持有的锁，偏向线程ID和偏向时间戳等。  
   > > * Klass Pointer：对象指向它类元数据的指针，JVM通过这个指针长度来确定对象是哪个类的实例。  
   > > * 数组长度（只有数组对象才有）：记录数组对象的长度。
   > 
 ### ArrayList 源码中扩容机制中，为什么扩容 int newCapacity = oldCapacity + (oldCapacity >> 1); 而不是oldCapacity + 1 ？  
   > 预分配冗余空间避免内存的频繁分配，空间换时间的思想。  
 