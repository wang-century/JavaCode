package cn.centuryw.BeginToLearn;

import java.net.InetAddress;

/**
    目标:InetAddress类概述
        一个该类的对象就代表一个IP地址对象。

    InetAddress类成员方法:
        static InetAddress getLocalHost()       获得本地主机IP地址对象
        static InetAddress getByName(string host)   根据IP地址字符串或主机名获得对应的IP地址对象。
        string getHostName()                        获得主机名
        string getHostAddress()                     获得IP地址字符串

 */
public class TestInetAddress {
    public static void main(String[] args) throws Exception {
        // 获取本机IP地址
        InetAddress ip = InetAddress.getLocalHost();
        // 打印主机名和地址
        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());
        // 获取百度的ip地址
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu.getHostName());
        System.out.println(baidu.getHostAddress());
        // 判断是否能ping通
        System.out.println(baidu.isReachable(3000));
    }
}
