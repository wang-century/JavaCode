package cn.centuryw.BeginToLearn.FilesUpload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class FileClient {
    // 要上传的文件路径
    public static String FILE_SRC = "E:\\SteamLibrary\\steamapps\\workshop\\content\\431960\\2005436556\\preview.png";

    public static void main(String[] args) throws Exception{
        // 创建Socket管道
        Socket socket = new Socket(InetAddress.getLocalHost(),7777);
        // 获取字节输出流
        OutputStream os = socket.getOutputStream();
        // 包装成缓冲字节输出流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(os);
        // 读取要上传的文件写出到缓冲字节输出流
        // 发送文件名
//        PrintStream printStream = new PrintStream(os);
//        printStream.print("aa.png");
//        printStream.flush();
        bufferedOutputStream.write("aa.png".getBytes());
        Thread.sleep(2000);
//        socket.shutdownOutput();
        // 发送文件内容
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(FILE_SRC));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=bufferedInputStream.read(buffer))!=-1){
            bufferedOutputStream.write(buffer,0,len);
        }
        bufferedOutputStream.flush();
        bufferedInputStream.close();
        System.out.println("文件发送完毕");
        socket.shutdownOutput();
        // 接受服务端的响应
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());
    }
}
