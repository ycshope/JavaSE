package Demo06;

public class TestThread02 implements Runnable{

    private int tick = 10;
    @Override
    public void run() {
        while (true){
            if ( tick <=0 ){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //获取线程名
            System.out.println(Thread.currentThread().getName()+"------拿到了第"+ tick-- +"票");
        }
    }

    public static void main(String[] args) {
        TestThread02 testThread = new TestThread02();

        new Thread(testThread,"大黄").start();
        new Thread(testThread,"小黄").start();
        new Thread(testThread,"中黄").start();

    }
}
