package thread.locks.reentrantLockdemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于数组和ReentrantLock实现的阻塞队列
 *
 * @author wyj
 * @version 1.0
 * @date 2025/5/10
 */
public class MyArrayBlockingQueue<T> {
    private final T[] array;  // 存储元素的数组
    private int head;         // 头指针
    private int tail;         // 尾指针
    private int count;        // 队列中元素个数

    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public MyArrayBlockingQueue(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    public void put(T element) throws InterruptedException {
        lock.lock();
        try {
            while (count == array.length) { // 使用while而非if，避免虚假唤醒
                notFull.await(); // 队列满的时候，阻塞生产者线程
            }
            array[tail] = element;
            tail = (tail + 1) % array.length;
            count++;
            notEmpty.signal(); // 唤醒消费者线程
        } finally {
            lock.unlock();
        }
    }

    public boolean offer(T element, long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        lock.lockInterruptibly();
        try {
            while (count == array.length) {
                if (nanos <= 0) {
                    return false;
                }
                nanos = notFull.awaitNanos(nanos);
            }
            array[tail] = element;
            tail = (tail + 1) % array.length;
            count++;
            notEmpty.signal();
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 恢复中断状态
            return false;
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await(); // 队列为空时，阻塞消费者线程
            }
            T element = array[head];
            head = (head + 1) % array.length;
            count--;
            notFull.signal(); // 唤醒生产者线程
            return element;
        } finally {
            lock.unlock();
        }
    }

    public T poll(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                if (nanos <= 0) {
                    return null;
                }
                nanos = notEmpty.awaitNanos(nanos);
            }
            T element = array[head];
            head = (head + 1) % array.length;
            count--;
            notFull.signal();
            return element;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
        return null;
    }


}
