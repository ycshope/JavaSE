package Demo11;

public class TalkStd {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"localhost",9999)).start();
        new Thread(new TalkRec(8888,"老师")).start();
    }
}
