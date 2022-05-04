package Demo17;
// 测试守护线程
// 上帝守护你
public class TestDeamon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认为False表示用户线程

        thread.start();
        new Thread(you).start();
    }
}


//上帝 --- 进程结束后守护线程也会自然结束
class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("===========God bless you================");
        }
    }
}

//你
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("i am alive,i am Happy");
        }
        System.out.println("!!!!!!!!Good Bye World!!!!");
    }
}