package Demo05;
//实现Runnable,重写run方法,将执行的线程丢入Runnable
public class TestThread implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<100; i++)
        {
            System.out.println("-------------我是子线程");
        }
    }

    public static void main(String[] args) {
        TestThread testThread = new TestThread();

        //创建线程对象,通过线程对象来开启我们的线程,代理
        new Thread(testThread).start();

        for (int i=0; i<1000; i++){
            System.out.println("我是父线程---------------------");
        }

    }
}

