package Demo12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDown {
    public static void main(String[] args) throws Exception {
        // 1. 下载地址
        URL url = new URL("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");

        // 2. 连接到这个资源
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        // 3. 将流重定向到文件
        InputStream inputStream =  urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("baidu.png");

        byte[] buffer = new byte[1024];
        int length;
        while ((length=inputStream.read(buffer))!=-1){
            fos.write(buffer,0,length);
        }

        fos.close();
        inputStream.close();
        urlConnection.disconnect(); //断开连接

    }
}
