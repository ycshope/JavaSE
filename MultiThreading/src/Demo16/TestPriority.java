package Demo16;

public class TestPriority{
    static class MyPriority implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"---->"+Thread.currentThread().getPriority());
        }
    }
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"---->"+Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread t1  = new Thread(myPriority);
        Thread t2  = new Thread(myPriority);
        Thread t3  = new Thread(myPriority);

        //先设置优先级再启动

        t1.start();

        t2.setPriority(10);
        t2.start();

        t3.setPriority(7);
        t3.start();
   }
}
