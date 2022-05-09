package Demo09;

import java.io.IOException;
import java.net.*;

public class UdpClientDemo01 {
    public static void main(String[] args) throws IOException {
        //1. 建立socket
        DatagramSocket socket = new DatagramSocket();

        //2. 指定服务端的对象
        String msg = "Hello Server!!";
        int port = 8848;
        InetAddress address = InetAddress.getByName("localhost");

        //数据,起始长度,发送目标
        DatagramPacket packet = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,address,port);

        //3. 发送包
        socket.send(packet);

        //4.关闭连接
        socket.close();

    }
}
