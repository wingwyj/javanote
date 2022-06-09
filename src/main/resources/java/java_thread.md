## Java 并发编程  
### Java 中线程的六种状态  
  > * **初始(NEW)**：新创建了一个线程对象，但还没有调用start()方法。  
  > * **运行(RUNNABLE)**：Java线程中将就绪（ready）和运行中（running）两种状态笼统的称为“运行”。
线程对象创建后，其他线程(比如main线程）调用了该对象的start()方法。该状态的线程位于可运行线程池中，等待被线程调度选中，获取CPU的使用权，此时处于就绪状态（ready）。就绪状态的线程在获得CPU时间片后变为运行中状态（running）。  
  > * **阻塞(BLOCKED)**：表示线程阻塞于锁。  
  > * **等待(WAITING)**：进入该状态的线程需要等待其他线程做出一些特定动作（通知或中断）。  
  > * **超时等待(TIMED_WAITING)**：该状态不同于WAITING，它可以在指定的时间后自行返回。  
  > * **终止(TERMINATED)**：表示该线程已经执行完毕。  
### 多线程中启动线程为什么是start()而非run()？  
  > 源码中显示调用start()方法后，start()方法内会调用start0()方法。start0()方法是一个native方法，用于启动一个线程并调用run()方法。如果new 线程后直接调用run()方法，此时没有执行start0()方法，没有启动新的线程，所以不是新启动的线程来执行run()，而是main()方法在执行run()。  

### 多线程中 `sleep(long millis)`、`wait()`、`yield()` 区别  
  * **sleep(millis)** `Thread`类的方法，使线程挂起一定时间，让出CPU，进入`阻塞状态`。但是期间不会释放持有的对象锁，时间到后会进入`就绪状态`，等待任务调度器的调用(参与竞争CPU)。  
  * **wait()** `Object` 的方法。释放锁进入`阻塞状态`,只有该锁对象被调用`notify`或者`notifyall`后，才会被唤醒进入`就绪状态`等待任务调度器的调用。  
  * **yield()** 调用`yield()`方法会让当前线程交出CPU权限，不会释放锁，而是进入`就绪状态`，和其他线程同样去竞争CPU。