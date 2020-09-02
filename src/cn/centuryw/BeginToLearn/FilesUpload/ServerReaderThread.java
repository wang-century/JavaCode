package cn.centuryw.BeginToLearn.FilesUpload;

import java.io.*;
import java.net.Socket;

public class ServerReaderThread extends Thread{
    private final Socket socket;
    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            // 接受客户端发来的文件
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] buffer = new byte[1024];
            int len;
            // 第一次读取文件名
            len = bufferedInputStream.read(buffer);
            String fileName = new String(buffer,0,len);
            System.out.println(fileName);
            // 读取文件字节，写出到本地路径
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(FileServer.FILES_DEST+File.separator+fileName));
            while ((len=bufferedInputStream.read(buffer))!=-1){
                bufferedOutputStream.write(buffer,0,len);
            }
            bufferedOutputStream.flush();
            bufferedInputStream.close();
            System.out.println("文件接收完毕");
        }catch (Exception e){
            System.out.println(socket.getRemoteSocketAddress()+"断开连接");
        }
    }
}
