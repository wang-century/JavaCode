package cn.centuryw.BeginToLearn.TestUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 服务器端
 * 用于接受客户端消息
 */
public class UDPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器端启动");
        // 创建socket
        DatagramSocket socket = new DatagramSocket(6666);
        // 创建数据包
        byte[] buffer = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
        // 接受数据包
        socket.receive(packet);
        // 获取收到的数据包数据量
        int len = packet.getLength();
        // 获取发送方的IP和端口
        String ip = packet.getAddress().getHostAddress();
        int port = packet.getPort();
        // 输出数据
        String result = new String(buffer,0,len);
        System.out.println(ip+":"+port+":"+result);
        // 关闭socket
        socket.close();
    }

}
