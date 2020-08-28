package cn.centuryw.BeginToLearn.TestStream;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * 目标:打印流PrintStream / PrintWriter.
 * 打印流的作用:
 * 1.可以方便，快速的写数据出。
 * 2.可以实现打印啥出去，就是啥出去。
 * 打印流的构造器:
 * public PrintStream(OutputStream os):
 * public PrintStream (String filepath):
 *
 * 打印流可以方便，且高效的打印各种数据。
 * PrintStream不光可以打印数据，还可以写字节数据出去。
 * PrintWriter不光可以打印数据，还可以写字符数据出去。
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws Exception{
        // PrintStream
        demo1();
        // 打印流改变输出的流向,重定向
        demo2();



    }

    static void demo1() throws Exception{
        // PrintStream
        OutputStream os = new FileOutputStream("/home/centuryw/文档/test.txt",true);
        PrintStream ps = new PrintStream(os);
        //PrintStream ps = new PrintStream("/home/centuryw/文档/test.txt");
        ps.println(97);
        ps.println("快乐的");
        ps.println(98.3);

        // 写字节数据
        ps.write("我爱你".getBytes());
        ps.close();
    }

    static void demo2() throws Exception{
        /* 打印流改变输出的流向,重定向 */
        OutputStream os = new FileOutputStream("/home/centuryw/文档/test.txt",true);
        PrintStream ps2 = new PrintStream(os);
        System.setOut(ps2);     // 让系统的输出流向打印流
        System.out.println("---helloworld---");
        ps2.close();
    }
}
