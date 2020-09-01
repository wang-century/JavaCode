package cn.centuryw.BeginToLearn.TestTCP;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 服务器端
 *
 * 1.各户端用socket连接服务端。
 * 2.服务端用serverSocket注册端口，接收客户端的Socket连接。
 * 3.通信是很严格的，对方怎么发，你就应该怎么收，对方发多少你就只能收多少。
 * 4.实现的面向连接的socket端到端的通信管道，一方如果出现对象，另一方会出现异常
 */
public class TCPServer {
    public static void main(String[] args) throws Exception{
        try{
            System.out.println("---服务端启动---");
            // 注册端口
            ServerSocket serverSocket = new ServerSocket(8888);

            // 设置线程池
            HandleSocketThreadPool handleSocketThreadPool = new HandleSocketThreadPool(3,20,100);

            while (true){
                // 开始等待接收客户端的Socket管道连接
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+"上线...");
                // 每接收一个客户端必须为这个客户端分配一个独立的线程来处理通信
                handleSocketThreadPool.execute(new ReaderClientRunnable(socket));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ThreadTCPServer extends Thread{
    private final Socket socket;

    public ThreadTCPServer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        // 从Socket管道中获取字节输入流
        InputStream is = null;
        try {
            is = socket.getInputStream();
            // 转换成字符输入流并包装成缓冲字符输入流
            Reader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            // 按行读取消息
            String message;
            while ((message=bufferedReader.readLine())!=null){
                System.out.println(this.socket.getRemoteSocketAddress()+"："+message);
            }
        } catch (IOException e) {
            System.out.println(this.socket.getRemoteSocketAddress()+"下线了...");
        }
    }
}

class HandleSocketThreadPool{
    /**
     * 线程池
     */
    private final ExecutorService executor;

    /**
     * 线程池初始化设置
     * @param maxPoolSize 存活线程数
     * @param queueSize 队列等待数
     * @param maximumPoolSize 最大线程数
     */
    public HandleSocketThreadPool(int maxPoolSize,int maximumPoolSize,int queueSize){
        this.executor = new ThreadPoolExecutor(
                maxPoolSize,        // 保存数量
                maximumPoolSize,        // 最大数量
                120L,  // 存活时间120s
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize)
        );
    }

    public void execute(Runnable task){
        this.executor.execute(task);
    }
}

class ReaderClientRunnable implements Runnable{
    private final Socket socket;

    public ReaderClientRunnable(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        // 从Socket管道中获取字节输入流
        InputStream is = null;
        try {
            is = socket.getInputStream();
            // 转换成字符输入流并包装成缓冲字符输入流
            Reader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            // 按行读取消息
            String message;
            while ((message=bufferedReader.readLine())!=null){
                System.out.println(this.socket.getRemoteSocketAddress()+"："+message);
            }
        } catch (IOException e) {
            System.out.println(this.socket.getRemoteSocketAddress()+"下线了...");
        }
    }
}
