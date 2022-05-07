package Demo01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class TestTcpClientDemo01 {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.连接的目标地址和端口
            InetAddress serverIP = InetAddress.getByName("0.0.0.0");
            int port = 8848;

            //2. 创建socket来凝结
            socket = new Socket(serverIP, port);
            //3. 发送消息IO流
            os = socket.getOutputStream();

            os.write("hello world".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (os !=null){
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
