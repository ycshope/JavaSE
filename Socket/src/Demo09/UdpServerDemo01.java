package Demo09;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServerDemo01 {
    public static void main(String[] args) throws IOException {
        // 1.开放端口
        int port = 8848;
        DatagramSocket socket = new DatagramSocket(port);

        // 2.缓冲区,接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        // 3.接收数据,阻塞
        socket.receive(packet);

        //接收结果输出

        System.out.println(packet.getAddress().getHostAddress());   //输出服务端地址
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        //4.关闭连接
        socket.close();
    }
}
