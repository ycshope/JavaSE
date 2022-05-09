package Demo11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkRec implements Runnable{
    private int srcPort;
    private DatagramSocket socket = null;
    private String sender = null;
    private boolean flag = true;
    public TalkRec(int srcPort,String sender) {
        this.srcPort = srcPort;
        this.sender = sender;
        try {
            // 1.开放端口
            socket = new DatagramSocket(this.srcPort);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (this.flag) {
            try {
                // 2.缓冲区,接收数据包
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

                // 3.接收数据,阻塞
                this.socket.receive(packet);

                //接收buff
                String recData = new java.lang.String(packet.getData(),0,packet.getLength());

                System.out.println(this.sender +" : "+recData);

                if (recData.equals("bye")){
                    this.flag = false;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (this.socket != null){
            this.socket.close();
        }
    }
}
