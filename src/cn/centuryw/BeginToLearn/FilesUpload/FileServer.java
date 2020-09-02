package cn.centuryw.BeginToLearn.FilesUpload;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * 实现客户端上传图片 服务端保存
 */
public class FileServer {
    // 图片保存路径
    public static final String FILES_DEST = "D:\\云盘";
    public static void main(String[] args){
        try{
            System.out.println("---服务端启动---");
            // 注册端口
            ServerSocket serverSocket = new ServerSocket(7777);
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+"已连接");
                // 创建独立线程处理通信
                new ServerReaderThread(socket).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

