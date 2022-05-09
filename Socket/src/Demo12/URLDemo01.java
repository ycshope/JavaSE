package Demo12;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
    static private String link = "http://www.baidu.com@evil.com:80/helloworld/index.php?username=admin&password=passwd";
    public static void main(String[] args) {
        try {
            URL url = new URL(link);
            System.out.println(url.getProtocol());  //http
            System.out.println(url.getHost());  //evil.com
            System.out.println(url.getPort());  //80
            System.out.println(url.getPath());  // /helloworld/index.php
            System.out.println(url.getFile());  // /helloworld/index.php?username=admin&password=passwd
            System.out.println(url.getQuery()); //username=admin&password=passwd
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
