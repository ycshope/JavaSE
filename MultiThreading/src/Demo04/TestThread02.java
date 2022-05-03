package Demo04;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestThread02 extends Thread{
    ///定义网络保存图片和文件名
    private String url;
    private String name;

    //构造函数,分配url和图片名
    public TestThread02(String url,String name) {
        this.url = url;
        this.name = name;
    }

    public static void main(String[] args) {
        TestThread02 t1 = new TestThread02("https://www.kuangstudy.com/assert/course/c1/01.jpg","01.jpg");
        TestThread02 t2 = new TestThread02("https://www.kuangstudy.com/assert/course/c1/02.jpg","02.jpg");
        TestThread02 t3 = new TestThread02("https://www.kuangstudy.com/assert/course/c1/03.jpg","03.jpg");

//      启动线程
        t1.start();
        t2.start();
        t3.start();

    }

    //下载图片执行的线程
    public void run(){
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downLoader(url,name);
        System.out.println("下载了"+name);
    }

    //文件下载工具类
    class WebDownloader{
        //远程路径,存储名字
        public void downLoader(String url,String name){
            try {
                FileUtils.copyURLToFile(new URL(url),new File(name));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
