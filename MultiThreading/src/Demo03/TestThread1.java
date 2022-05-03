package Demo03;

//继承Thread
public class TestThread1 extends Thread{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0 ; i<200; i++){
            System.out.println("--------------我是子线程");
        }
    }

    public static void main(String[] args) {
        //main线程,主线程

        //创建一个线程对象
        TestThread1 thread1 = new TestThread1();

        //start方法开启线程
        thread1.start();

        for (int i = 0 ; i<2000; i++){
            System.out.println("我是主线程---------------");
        }
    }
}
