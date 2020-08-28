package cn.centuryw.BeginToLearn.TestIO;

import java.io.*;

/**
 * 目标:IO流读写数据。
 * <p>
 * IO输入输出流:输入/输出流
 * Input:输入
 * output:输出
 * 引入:
 * File类只能操作文件对象本身，不能读写文件对象的内容。
 * 读写数据内容，应该使用IO流。
 * <p>
 * IO流是一个水流模型:IO理解成水管，把数据理解成水流。
 * <p>
 * IO流的分类:
 * 按照流的方向分为:输入流，输出流。
 * (1）输出流:以内存为基准，把内存中的数据写出到磁盘文件或者网络介质中去的流称为输出流。
 * 输出流的作用:写数据到文件，或者写数据发送给别人
 * (2）输入流:以内存为基准，把磁盘文件中的数据或者网络中的数据读入到内存中去的流称为输入
 * 输入流的作用:读取数据到内存。
 * 按照流的内容分为:字节流，字符流
 * (1）字节流:流中的数据的最小单位是一个一个的字节，这个流就是字节流。
 * (2）字符流:流中的数据的最小单位是一个一个的字符，这个流就是字符流。(针对于文本内容)
 * <p>
 * 大体分为四大类:
 * 字节输入流:以内存为基准，把磁盘文件中的数据或者网络中的数据以一个一个的字节的形式读入到内存中去的流称为字节输入流。
 * 字节输出流:以内存为基准，把内存中的数据以一个一个的字节写出到磁盘文件或者网络介质中去的流称为字节输出流。
 * 字符输入流:以内存为基准，把磁盘文件中的数据或者网络中的数据以一个一个的字符的形式读入到内存中去的流称为字符输入流。
 * 字符输出流:以内存为基准，把内存中的数据以一个一个的字符写出到磁盘文件或者网络介质中去的流称为字符输出流。
 * <p>
 * <p>
 * 目标:字节输入流的使用。
 * IO流的体系:
 * 字节流                         字符流
 * 字节输入流            字节输出流           字符输入流       字符输出流
 * InputStream         OutputStream        Reader          Writer(抽象类)
 * FileInputStream    FileOutputStream     FileReader     FileWriter(实现类)
 * <p>
 * a.FileInputStream文件字节输入流
 * --作用:以内存为基准，把磁盘文件中的数据按照字节的形式读入到内存中的流。
 * 简单来说，就是按照字节读取文件数据到内存。
 * --构造器:
 * 1.public FileInputStream(File path):        创建一个字节输入流管道与源文件对象接通。
 * 2.public FileInputStream(string pathName):  创建一个字节输入流管道与文件路径对接。
 * --方法:
 * 1.public int read():每次读取一个字节返回!读取完毕会返回-1。
 * 2.public int read(byte[] buffer):从字节输入流中读取字节到字节数组中去，
 *                                      返回读取的字节数盘，没有字节可读返回-1。
 *
 *
 * 拓展:解决字节输入流读取中文内容输出乱码的问题。
 * 引入:
 *      一个一个字节读取中文输出
 *      一个一个字节数组读取中文输出均无法避免乱码。
 * 如何实现读取可以避免乱码呢?
 *      1.定义一个字节数组与文件的大小刚刚一样大，然后一桶水读取全部字节数据再输出!|
 *
 * 小结:
 * 定义一个字节数组与文件的大小刚刚一样大，然后一桶水读取全部字节数据再输出!
 * 可以避免中文读取输出乱码，但是如果读取的文件过大，会出现内存溢出!!
 * 字节流并不适合读取文本文件内容输出，读写文件内容建议使用字符流。
 *
 * b.Fileoutputstream文件字节输出流
 * --作用:以内存为基准，把内存中的数据，按照字节的形式写出到磁盘文件中去。
 * 简单来说，把内存数据按照字节写出到磁盘文件中去。
 *
 * 小结:
 * 字节输出流可以写字节数据到文件中去。
 * 写一个字节，写一个字节数组，写一个字节数组的一部分出去。
 * 管道用完需要关闭，数据要生效需要刷新，关闭包含刷新，刷新后流可以继续使用，关闭后流无法继续使用
 * 字节输出流管道默认是覆盖数据管道，启动管道写数据前会清空数据
 *
 *
 *
 * 目标:字节流做文件复制。
 * 字节流复制的思想:
 *      字节是计算机中一切文件的组成，所以字节流适合做一切文件的复制。
 *      复制是把源文件的全部字节一字不漏的转移到目标文件，只要文件前后的格式一样，绝对不会有问题。
 *
 * 需求:
 *      原文件:
 *      目标文件:
 * 分析步骤:
 * (1）创建一个字节输入流管道与源文件接通。
 * (2）创建一个字节输出流与目标文件接通。
 * (3）创建一个字节数组作为桶
 * (4）从字节输入流管道中读取数据，写出到字节输出流管道即可。
 * (5）关闭资源!
 *
 *
 * 目标:JDK 1.7开始之后释放资源的新方式
 *      try-with-resources:
 *          try(
 *              //这里只能放置资源对象，用完会自动调用close()关闭
 *          ) {
 *          }catch(Exception e){
 *              e.printstackTrace();
 *          }
 * 什么是资源?
 * 资源类一定是实现了closeable接口，实现这个接口的类就是资源
 * 有close()方法，try-with-resources会自动调用它的close()关闭资源。
 *
 *
 * 什么是缓冲流:缓冲流可以提高字节流和字符流的读写数据的性能。
 * 缓冲流分为四类:
 * (1）BufferedInputStream:字节缓冲输入流，可以提高字节输入流读数据的性能。
 * (2）BufferedOutputStream:字节缓冲输出流，可以提高字节输出流写数据的性能。
 * (3）BufferedReader:字符缓冲输入流，可以提高字符输入流读数据的性能。
 * (4）BufferedWriter:字符缓冲输出流，可以提高字符输出流写数据的性能。
 *
 * 字符输入转换InputStreamReader:
 * --作用:可以把原始的字节流按照当前默认的代码编码转换成字符输入流。(解决乱码问题)
 * 也可以把原始的字节流按照指定编码转换成字符输入流
 *
 * 字符输出转换流: OutputStreamWriter
 * --作用:可以指定编码把字节输出流转换成字符输出流。
 *      制定写出字符编码
 *
 * 目标:对象序列化技术。
 * 对象序列化:就是把Java对象数据直接存储到文件中去。       对象→>文件中
 * 对象反序列化:就是把Java对象的文件数据恢复到Java对象中   文件中=>对象
 *
 * 对象序列化流（对象字节输出流）: ObjectOutputStream
 * --作用:把内存中的Java对象数据保存到文件中去。
 * --构造器:public ObjectOutputStream(OutputStream out)
 * --序列化方法:public final void WriteObject (object obj)
 * 注意:如果要序列化对象，那么对象必须实现序列化接口: implements Serializable
 *
 *
 * 对象反序列化（对象字节输入流）: ObjectInputStream
 * --作用:读取序列化的对象文件恢复到Java对象中。
 * --构造器:public objectInputstream (Inputstream is)
 * --方法:public final object readobject()
 *
 * 如果一个字段不想参数序列化:
 *      transient修饰i该成员变量，它将不参与序列化!
 * 序列化版本号:
 * //加入序列版本号
 * private static final long serialVersionUID = 2L;
 * 必须序列化使用的版本号和反序列化使用的版本号一致才可以正常反序列化!否则报错!
 */
public class IODemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /* 单个字节读取 */
        //demo1();

        /* 按照字节数组读取 */
        //demo2();

        /* 解决字节输入流读取中文内容输出乱码的问题 */
        //demo3();

        // 输出字节流数据
        //demo4();

        // 使用字节方式复制文件
        //demo5();

        // 文件字符输入流
        //demo6();

        // 文件字符输出流
        //demo7();

        // 字节缓冲输入流
        //demo8();

        // 字节缓冲输出流
        //demo9();

        // 字符缓冲输入流
        //demo10();

        // 字符缓冲输出流
        //demo11();

        // 字符输入转换流
        //demo12();

        // 字符输出转换流
        //demo13();

        // 对象序列化
        demo14();

        // 对象反序列化
        demo15();



    }

    private static void demo15() throws IOException, ClassNotFoundException {
        /* 对象反序列化 */
        InputStream inputStream = new FileInputStream("/home/centuryw/文档/Users.dat");
        // 包装
        ObjectInputStream os = new ObjectInputStream(inputStream);
        // 反序列化
        User user = (User)os.readObject();
        System.out.println(user);

    }

    static class User implements Serializable{
        private String name;
        // transient 修饰的变量不会参与序列化
        private transient String passwd;

        // 加入序列化版本号
        private static final long serialVersionUIL = 1L;



        public User(String name, String passwd) {
            this.name = name;
            this.passwd = passwd;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        @Override
        public String toString() {
            return "User "+this.name;
        }
    }

    private static void demo14() throws IOException {
        // 创建序列化对象
        User user = new User("铁山公主","21379571080921");
        OutputStream os = new FileOutputStream("/home/centuryw/文档/Users.dat");
        // 包装
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
        // 通过对象字节输出流序列化对象
        objectOutputStream.writeObject(user);
        os.close();
        System.out.println("序列化成功");
    }


    private static void demo13() throws IOException{
        OutputStream os = new FileOutputStream("");
        // 转换
        Writer fw = new OutputStreamWriter(os,"GBK");
        fw.write("你好世界");
        fw.close();
    }

    private static void demo12() throws IOException{
        // 提取GBK文件的原始字节流
        InputStream inputStream = new FileInputStream("");
        // 把原始字节输入流通过转换流,转换成InputStreamReader
        Reader isr = new InputStreamReader(inputStream,"GBK");
        // 包装成缓冲流
        BufferedReader br = new BufferedReader(isr);
        // 读取数据
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }

    }

    private static void demo11() throws IOException{
        // 追加写法
        Writer writer = new FileWriter("/home/centuryw/文档/test.txt",true);

        // 包装
        BufferedWriter bw = new BufferedWriter(writer);

        // 新增功能:自动写入一行换行
        bw.write("今天是个好日子");

        writer.flush();

        // 关闭文件
        writer.close();

    }

    private static void demo10() throws IOException{
        Reader reader = new FileReader("/home/centuryw/文档/test.txt");
        // 包装
        BufferedReader bufferedReader = new BufferedReader(reader);

        // 原来使用字符数组读取内容
        /*char[] buffer = new char[1024];     // 1K
        int len;
        while ((len=bufferedReader.read(buffer))!=-1){
            System.out.println(new String(buffer,0,len));
        }*/
        // 包装后新增按行读取
        String line;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        reader.close();
    }

    private static void demo9() throws IOException{
        OutputStream outputStream = new FileOutputStream("/home/centuryw/文档/test.txt");
        // 包装
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        // 写数据
        bos.write('a');
        outputStream.close();
    }

    private static void demo8() throws IOException{
        // 定义一个低级的字节输入流与源文件接通
        InputStream inputStream = new FileInputStream("/home/centuryw/文档/test.txt");
        // 包装成高级的缓冲字节输入流
        InputStream bis = new BufferedInputStream(inputStream);
        // 定义字节数组按照循环读取
        byte[] buffer = new byte[3];
        int len;
        while ((len=bis.read(buffer))!=-1){
            System.out.println(new String(buffer,0,len));
        }
        inputStream.close();
    }

    private static void demo7() throws IOException{
        // 追加写法
        Writer reader = new FileWriter("/home/centuryw/文档/test.txt",true);

        // 写一个字符
        reader.write(97);   // 字符a
        reader.write('b');
        reader.write('三');

        // 写字符串
        reader.write("你好世界!\r\n");

        // 写字符数组
        reader.write("我爱你\n".toCharArray());

        // 写字符串的一部分
        reader.write("Java是语言\n",0,4);

        // 关闭文件
        reader.close();

    }

    private static void demo6() throws IOException {
        // File file = new File("/home/centuryw/文档/test.txt");
        // Reader reader = new FileReader(file);
        // 简化
        Reader reader = new FileReader("/home/centuryw/文档/test.txt");
        // 按照字符读取,每次读取一个字符的编号返回
        //int code = reader.read();
        //System.out.println((char)code);

        // 使用循环,每次读取一个字符的编号返回
        /*int code;
        while ((code=reader.read())!=-1){
            System.out.println((char)code);
        }*/

        // 使用字符数组读取内容
        char[] buffer = new char[1024];     // 1K
        int len;
        while ((len=reader.read(buffer))!=-1){
            System.out.println(new String(buffer,0,len));
        }
        reader.close();
    }

    private static void demo5() throws IOException {
        // 创建文件对象
        try (OutputStream outputStream = new FileOutputStream("/home/centuryw/图片/copy_Cage.jpg"); InputStream inputStream = new FileInputStream("/home/centuryw/图片/22_Cage2_4k.jpg")) {
            // 连接到被复制的文件
            // 连接到复制的文件地址
            // 创建字节流数组
            byte[] bytes = new byte[1024];  // 1KB
            int len;
            // 写出到复制的文件
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            System.out.println("文件复制完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void demo4() throws IOException {
        // 创建一个字节输出流管道与目标文件路径接通,默认覆盖
        OutputStream outputStream = new FileOutputStream("/home/centuryw/文档/test.txt");
        OutputStream outputStream1 = new FileOutputStream("/home/centuryw/文档/test.txt",true);   // 追加方式
        // 写一个字节
        outputStream.write(97); // 字节a
        outputStream.write('b');

        // 换行
        outputStream.write("\r\n".getBytes());

        // 写字节数组
        byte[] bytes = new byte[]{47,35,47,57,58,35};
        outputStream.write(bytes);
        byte[] bytes1 = "Java是语言".getBytes();   // 默认以当前编码UTF-8提取字节数组  .getBytes("GBK)以GBK提取字节组
        outputStream.write(bytes1);

        // 换行
        outputStream.write("\r\n".getBytes());

        // 写字节数组的一段
        byte[] bytes2 = "Java是语言".getBytes();
        outputStream.write(bytes2,0,7);

        outputStream.flush();   // 立即刷新数据到文件,刷新后管道可以继续使用
        outputStream.close();   // 立即关闭资源管道

    }


    private static void demo3() throws IOException {
        /* 解决字节输入流读取中文内容输出乱码的问题 */

        // 创建文件对象
        File file = new File("/home/centuryw/文档/test.txt");
        // 定义输入流
        InputStream inputStream = new FileInputStream(file);
        /*
        // 定义一个字节数组与文件的大小刚刚一样大
        byte[] buffer = new byte[(int) file.length()];
        int len = inputStream.read(buffer);
        System.out.println("读取字节:"+len);
        System.out.println(new String(buffer));
        */

        // 上述方法的替代
        byte[] buffer = inputStream.readAllBytes();
        String string = new String(buffer);
        System.out.println(string);

        inputStream.close();
    }

    static void demo2() throws IOException {
        /* 按照字节数组读取 */
        /*try {
            // 创建一个字节输入流管道与文件接通
            InputStream file2InputStream = new FileInputStream("/home/centuryw/文档/test.txt");
            // 定义一个字节数组读取数据
            byte[] buffer = new byte[3];
            // 从管道中读取字节装入字节数组,返回读取字节的数量
            int len1 = file2InputStream.read(buffer);
            System.out.println("读取字节数:"+len1);
            String res1 = new String(buffer);
            System.out.println(res1);
            // 读多少倒多少
            // String res = new String(buffer,0,len);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        // 使用循环替代上述方法
        InputStream fileInputStream = new FileInputStream("/home/centuryw/文档/test.txt");
        byte[] buffer = new byte[3];
        int len;
        while ((len=fileInputStream.read(buffer))!=-1){
            System.out.println(new String(buffer,0,len));
        }
        fileInputStream.close();
    }

    static void demo1(){
        /* 单个字节读取 */
        // 1.创建文件对象
        File file1 = new File("/home/centuryw/文档/test.txt");
        // 2.创建一个字节输入流管道与文件接通
        try (InputStream file1InputStream = new FileInputStream(file1)) {
            // 3.使用while读取字节
            int chr = 0;
            while (chr != -1) {
                chr = file1InputStream.read();
                System.out.println((char) chr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
