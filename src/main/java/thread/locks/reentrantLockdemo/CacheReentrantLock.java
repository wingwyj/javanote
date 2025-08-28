package thread.locks.reentrantLockdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * reentrantLock 实现一个读多写少的缓存
 *
 * @author wyj
 * @version 1.0
 * @date 2025/5/10
 */
public class CacheReentrantLock<K, V> {
    private final Map<K, V> cache = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public V get(K key) {
        readLock.lock();
        try {
            return cache.get(key);
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 1.如果缓存中不存在，则加载缓存
     * 2.双重校验防止多个线程修改V
     *
     * @param key
     * @return
     */
    public V loadIfPresent(K key) {
        V v = cache.get(key);
        if (v == null) {
            writeLock.lock();
            try {
                v = cache.get(key);
                if (v == null) {
                    // 加载数据
                    // v = load(key);
                    cache.put(key, v);
                }
                // 锁降级 ：写锁降级为读锁
                readLock.lock();
            } finally {
                writeLock.unlock();
            }
            // 锁降级以后，这里可以防止其他线程获取写锁去修改数据，这时其他线程可以获取读锁
            try {
                // 这里可以保证v还是可以和上边修改的值是一致的
            } finally {
                readLock.unlock();
            }
        }
        return v;
    }

    public void put(K key, V value) {
        writeLock.lock();
        try {
            cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public void remove(K key) {
        writeLock.lock();
        try {
            cache.remove(key);
        } finally {
            writeLock.unlock();
        }
    }


}
