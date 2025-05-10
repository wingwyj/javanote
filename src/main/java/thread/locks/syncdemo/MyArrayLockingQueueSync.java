package thread.locks.syncdemo;

/**
 * 基于synchronized实现一个阻塞队列
 * @author wyj
 * @version 1.0
 * @date 2025/5/10
 */
public class MyArrayLockingQueueSync<T> {
    private final T[] array;
    private int head;  // 头指针
    private int tail;  // 尾指针
    private int count; // 队列中元素的个数

    public MyArrayLockingQueueSync(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void put(T element) throws InterruptedException {
        synchronized (this) {
            while (count == array.length) {
                this.wait();
            }
            array[tail] = element;
            tail = (tail + 1) % array.length;
            count++;
            notifyAll();
        }
    }

    public T take() throws InterruptedException {
        synchronized (this) {
            while (count == 0) {
                this.wait();
            }
            T element = array[head];
            head = (head + 1) % array.length;
            count--;
            notifyAll();
            return element;
        }
    }
}
