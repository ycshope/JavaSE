package Demo25;

public class TestPC {
    public static void main(String[] args) {
        Cache cache = new Cache();

        Producter producter = new Producter(cache);
        Consumer consumer = new Consumer(cache);

        new Thread(producter).start();
        new Thread(consumer).start();
    }
}

//生产者
class Producter implements Runnable{
    //接收进程间通信的缓冲区
    Cache cache;

    //构造函数
    public Producter(Cache cache) {
        this.cache = cache;
    }

    //生产鸡
    public void run(){
        for (int i = 0; i < 10; i++) {
            this.cache.push(i);
        }
        //生产完成
        this.cache.setFinish();
    }
}

//消费者
class Consumer implements Runnable{
    //接收进程间通信的缓冲区
    Cache cache;

    public Consumer(Cache cache) {
        this.cache = cache;
    }

    public void run(){
        while (!this.cache.isFinish()){
            this.cache.pop();
        }
    }
}

//缓冲区
class Cache{
    //定义变量,表示第x只鸡
    private int num;

    //定义状态,表示是否有鸡
    private boolean state = false;

    //定义状态表示是否结束
    private boolean finish = false;

    //生产者生产产品--同步方法
    public synchronized void push(int num){
        //如果有鸡,那么等待消费
        if(state){
            try {
                wait();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //没有鸡,那么生产
        this.num = num;
        System.out.println("生产了第"+this.num+"只鸡");

        this.state = true;

        //唤醒其他等待的线程
        this.notifyAll();
    }

    //消费者消费产品--临界区,要
    public synchronized void pop(){
        //如果没有鸡,那么等待生产
        if(!state){
            try {
                wait();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //有鸡直接吃
        System.out.println("用户吃了第"+this.num+"只鸡");
        this.state = false;

        //唤醒其他等待的线程
        this.notifyAll();
    }

    public void setFinish(){
        this.finish = true;
    }

    public boolean isFinish(){
        return this.finish;
    }


}