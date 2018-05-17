package client.nio;


import java.io.*;


import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * java 内存文件映射
 * @author wsp
 */
public class MappedByteBufferDemo {

    public static void main(String[] args) throws Exception{
       long time = System.currentTimeMillis();
        directMemoryIo();
       System.out.println("共耗时 : " + (System.currentTimeMillis() - time));
    }


    /**
     * 标准流读 次数 : 788042  时间(毫秒):4222
     * @throws Exception
     */
    static void streamIoFile()throws Exception{
        File inFile = new File("D:\\jmap_636178_2017-06-13-10-29-06.txt");
        BufferedInputStream  bufferedInputStream = new BufferedInputStream(new FileInputStream(inFile));
        byte[] bytes = new byte[1024];
        int count = 0;
        while(bufferedInputStream.read(bytes)>0){
            count++;
        }
        System.out.println("共读取次数 :" + count);
        bufferedInputStream.close();
    }

    /**
     * 内存映射文件的区域是在用户进程虚拟内存空间中专门预留的内存映射区域分配的,读写时减少了原有C库到jvm堆缓冲区的copy,也减少了用户进程到内核进程缓冲区的copy.(2次copy)而且这个内存区域不受gc影响.
     * 内存映射文件读取 数 : 788042  时间(毫秒):600
     * @throws Exception
     */
    static void mapperIo()throws Exception{
        File inFile = new File("D:\\jmap_636178_2017-06-13-10-29-06.txt");
        FileChannel fileChannel1 = new FileInputStream(inFile).getChannel();
        MappedByteBuffer buffer1 =  fileChannel1.map(FileChannel.MapMode.READ_ONLY,0,fileChannel1.size());
        byte[] bytes = new byte[1024];
        int count = 0;
        for(int offset = 0 ; offset < fileChannel1.size(); offset+=1024){
            buffer1.get(bytes);
            buffer1.flip();
            count++;
        }
        System.out.println("共读取次数 :" + count);
        fileChannel1.close();
    }



    /**
     * 直接内存是分配在jvm空间堆外随便一个内存区域,读写时减少了原有C库到jvm堆缓冲区的copy,但是没有减少用户进程到内核进程缓冲区的copy..而且这个直接内存受gc影响.
     * 直接内存读取 次数 : 788042  时间(毫秒):4874
     * @throws Exception
     */
    static void directMemoryIo()throws Exception{
        File inFile = new File("D:\\jmap_636178_2017-06-13-10-29-06.txt");
        FileChannel fileChannel1 = new FileInputStream(inFile).getChannel();
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        int count = 0;
        while(fileChannel1.read(buffer)>0){
            count++;
            buffer.flip();
            buffer.clear();
        }
        System.out.println("共读取次数 :" + count);
        fileChannel1.close();
    }

}
