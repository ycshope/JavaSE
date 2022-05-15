package Demo18;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        TestCache testCache = new TestCache();
        //写入
        for (int i = 0; i < 10; i++) {
            final int temp = i;
                new Thread(() -> {
                    testCache.put(temp + "", temp + "");
                }, String.valueOf(i)).start();
            }
        //读取
        for (int i = 0; i < 10; i++) {
            final int temp = i;
                new Thread(() -> {
                    testCache.get(temp + "");
                }, String.valueOf(i)).start();
        }
    }
}

class TestCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //一次只能有一个线程写入
    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    //一次可以有多个线程读取
    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}