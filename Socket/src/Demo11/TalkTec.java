package Demo11;

public class TalkTec {
    public static void main(String[] args) {
        new Thread(new TalkSend(5555,"localhost",8888)).start();
        new Thread(new TalkRec(9999,"学生")).start();
    }
}
