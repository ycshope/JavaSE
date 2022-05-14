package Demo07;

public class Sync {
    public static void main(String[] args) {
        Data data = new Data();

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

class Data{
    private int num = 0;
    public synchronized void inc() throws InterruptedException {
        while (num!=0){
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"=>"+num);
        this.notifyAll();
    }

    public synchronized void dec() throws InterruptedException {
        while (num == 0){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"=>"+num);
        this.notifyAll();
    }
}
