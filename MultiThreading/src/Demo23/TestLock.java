package Demo23;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        Buyticket buyticket = new Buyticket();

        //多个线程操作一个对象
        new Thread(buyticket,"我").start();
        new Thread(buyticket,"你").start();
        new Thread(buyticket,"黄牛").start();
    }
}

class Buyticket implements Runnable{
    //票
    private int ticket = 30;

    private boolean flag = true;
    //锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(flag){
            try {
                try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                }
                lock.lock(); //加锁
                if(ticket >0){
                    System.out.println(Thread.currentThread().getName()+"买到了第"+ticket--+"张票");
                }
                else {
                    flag=false;
                }
            } finally {
                lock.unlock(); //解锁
            }
        }
    }
}