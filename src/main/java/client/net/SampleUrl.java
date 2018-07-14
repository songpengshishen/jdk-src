package client.net;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * url的例子
 */
public class SampleUrl {

    public static void main(String[] args)throws Exception {
        connection();
    }


    public static void printUrl()throws Exception{
        URL url = new URL("http://www.baidu.com/index.html?key=aa&key2=bb#haha");
        System.out.println("protocol : " + url.getProtocol());
        System.out.println("host : " + url.getHost());
        System.out.println("port : " + url.getPort());
        System.out.println("path : " + url.getPath());
        System.out.println("paramter : " + url.getQuery());
        System.out.println("ref : " + url.getRef());
        System.out.println("authority : " + url.getAuthority());
    }

    public static void connection()throws Exception{
        URL url = new URL("https://fanyi.baidu.com/#en/zh/connection");
        URLConnection connection =  url.openConnection();
        connection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String text ;
        while (null!= (text = reader.readLine())){
            System.out.println(text);
        }
        System.out.println(connection.getHeaderFields());
    }


}


