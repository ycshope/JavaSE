package Demo20;

public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket buyticket = new BuyTicket();

        new Thread(buyticket,"我").start();
        new Thread(buyticket,"你").start();
        new Thread(buyticket,"黄牛").start();

    }

}

class BuyTicket implements Runnable{
    //票的数量
    private int ticket = 10;
    //线程结束标志位
    private boolean flag = true;

    @Override
    public void run() {
        while (flag){
            try {
                Thread.sleep(100);
                buy();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //买票,synchronized 加锁,锁的是this
    private synchronized void buy() throws InterruptedException {
        if (ticket<=0){
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "买了第"+ ticket-- +"张票");
    }
}