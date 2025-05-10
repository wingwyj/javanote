package thread.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * 死锁demo
 * 产生死锁必须具备以下四个条件：
 *
 * 1.互斥条件：该资源任意一个时刻只由一个线程占用。
 * 2.请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
 * 3.不剥夺条件:线程已获得的资源在未使用完之前不能被其他线程强行剥夺，只有自己使用完毕后才释放资源。
 * 4.循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
 * @ Author wyj
 * @ Date 2022/3/30
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();
        new Thread(() -> {
            synchronized (lockA) {
                System.out.println("线程拿到lockA，等待获取lockB");
                new DeadLockDemo().sleep(2);
                synchronized (lockB) {
                    System.out.println("线程拿到了lockA和lockB");
                }
            }
        }, "thread-A").start();

        new Thread(() -> {
            synchronized (lockB) {
                System.out.println("线程拿到了lockB，等待获取lockA");
                new DeadLockDemo().sleep(2);
                synchronized (lockA) {
                    System.out.println("线程同时拿到了lockB和lockA");
                }
            }
        }, "thread-B").start();
    }

    public void sleep(long timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 恢复中断状态
        }
    }
}
