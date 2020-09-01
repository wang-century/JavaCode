package cn.centuryw.BeginToLearn.TestUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 客户端
 * 用于向服务端发送消息
 */
public class UDPClient {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端端启动");
        // 创建数据包
        byte[] buffer = "Hello World!".getBytes();
        // 参数说明：封装的字节数组、发送的数据长度、服务端的IP地址、服务端的端口号
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),6666);
        // 创建socket对象,可以声明端口，也可以不声明
        DatagramSocket socket = new DatagramSocket(7777);
        // 发送数据包对象
        socket.send(packet);
        // 关闭socket
        socket.close();
    }
}
