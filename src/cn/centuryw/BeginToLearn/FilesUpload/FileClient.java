package cn.centuryw.BeginToLearn.FilesUpload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class FileClient {
    // 要上传的文件路径
    public static String FILE_SRC = "D:\\Speed.log";

    public static void main(String[] args) throws Exception{
        // 创建Socket管道
        Socket socket = new Socket(InetAddress.getLocalHost(),7777);
        // 获取字节输出流
        OutputStream os = socket.getOutputStream();
        // 包装成缓冲字节输出流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(os);
        // 读取要上传的文件写出到缓冲字节输出流
        // 发送文件名
        bufferedOutputStream.write("peed.log".getBytes());
        bufferedOutputStream.flush();
        Thread.sleep(500);
        // 发送文件内容
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(FILE_SRC));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=bufferedInputStream.read(buffer))!=-1){
            bufferedOutputStream.write(buffer,0,len);
        }
        bufferedOutputStream.flush();
        System.out.println("文件发送完毕");
        socket.shutdownOutput();
    }
}
