package Demo11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class TalkSend implements Runnable{
    private String dstIP;
    private int dstPort;

    private int srcPort;
    private DatagramSocket socket = null;   //socket
    private InetAddress addressObj = null;  //地址对象

    private BufferedReader buffer = null; //缓冲区,用于从stdin接收数据
    private boolean flag = true; //结束标记位

    public TalkSend(int srcPort,String dstIP,int dstPort) {
        this.srcPort = srcPort;
        this.dstIP = dstIP;
        this.dstPort = dstPort;

        try {
            // 1. 新建socket
            socket = new DatagramSocket(this.srcPort);
            // 2. 指定对端的对象
            addressObj = InetAddress.getByName(this.dstIP);
            // 3. 定义buffer
            buffer = new BufferedReader(new InputStreamReader(System.in));

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (flag){
            try {
                // 从缓存区读取内容,数据转换成byte
                String data = buffer.readLine();
                byte[] datas = data.getBytes();
//                System.out.println("addressObj="+addressObj);
//                System.out.println("dstPort="+dstPort);
                DatagramPacket packet = new DatagramPacket(datas,0,datas.length,addressObj,dstPort);

                socket.send(packet);
                if (data.equals("bye")){
                    flag = false;
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if (socket != null) {
            socket.close();
        }
    }
}
