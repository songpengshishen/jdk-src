package client.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件通道示例
 * @author wangsongpeng
 * @since nio
 */
public class FileChannelDemo {

    public static void main(String[] args)throws Exception {
        FileInputStream fin = new FileInputStream("D:\\压测链接.txt");//创建文件输入流对象
        FileChannel fch = fin.getChannel();//创建文件通道.
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read0  = fch.read(buffer);
        byte[] bytes =  new byte[1024];
        buffer.flip();
        buffer.get(bytes);
        String str = new String(bytes);
        System.out.println(str);
    }

}
