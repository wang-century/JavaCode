package cn.centuryw.BeginToLearn.TestTCP;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class TCPClient {
    public static void main(String[] args) throws Exception{
        // 创建socket通信管道
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        // 从socket通信管道获取字节输出流
        OutputStream os = socket.getOutputStream();
        // 将字节输出流包装成高级的打印流
        PrintStream ps = new PrintStream(os);
        // 发送消息
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("我：");
            ps.println(scanner.nextLine());
            ps.flush();
        }
    }
}
