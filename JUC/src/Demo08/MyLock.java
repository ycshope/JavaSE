package Demo08;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {
    public static void main(String[] args) {
        Data2 data = new Data2();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.inc();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"A1").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.inc();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"A2").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.dec();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"B1").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.dec();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"B2").start();
    }
}
class Data2{
    private int num = 0;
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    public void inc() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0) {
                notFull.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "=>" + num);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }

    }

    public void dec() throws InterruptedException {
        lock.lock();
        try {
            while (num != 1) {
                notEmpty.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "=>" + num);
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }
}
