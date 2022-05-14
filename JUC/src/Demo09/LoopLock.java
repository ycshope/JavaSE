package Demo09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoopLock {
    public static void main(String[] args) {
        Data03 data03 = new Data03();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    data03.printA();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    data03.printB();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    data03.printC();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    data03.printD();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        },"D").start();
    }
}

class Data03{
    private int flag = 0;
    final Lock lock = new ReentrantLock();
    final Condition a = lock.newCondition();
    final Condition b = lock.newCondition();
    final Condition c = lock.newCondition();
    final Condition d = lock.newCondition();

    public void printA() throws InterruptedException {
        lock.lock();
        try {
            //不是自己的时候不叫
            while (flag%4 != 0 )
            {
                a.await();
            }
            flag++;
            System.out.println(Thread.currentThread().getName());
            //唤醒b
            b.signal();
        } finally {
            lock.unlock();
        }
    }
    public void printB() throws InterruptedException {
        lock.lock();
        try {
            //不是自己的时候不叫
            while (flag%4 != 1 )
            {
                b.await();
            }
            flag++;
            System.out.println(Thread.currentThread().getName());
            //唤醒c
            c.signal();
        } finally {
            lock.unlock();
        }
    }
    public void printC() throws InterruptedException {
        lock.lock();
        try {
            //不是自己的时候不叫
            while (flag%4 != 2 )
            {
                c.await();
            }
            flag++;
            System.out.println(Thread.currentThread().getName());
            //唤醒b
            d.signal();
        } finally {
            lock.unlock();
        }
    }
    public void printD() throws InterruptedException {
        lock.lock();
        try {
            //不是自己的时候不叫
            while (flag%4 != 3 )
            {
                d.await();
            }
            flag++;
            System.out.println(Thread.currentThread().getName());
            //唤醒a
            a.signal();
        } finally {
            lock.unlock();
        }
    }

}