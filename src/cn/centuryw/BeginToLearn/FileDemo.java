package cn.centuryw.BeginToLearn;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * File类的概述和API
 * File类:代表操作系统的文件对象。
 * File类:是用来操作操作系统的文件对象的，删除文件，获取文件信息，创建文件（文件夹)
 *       广义来说操作系统认为文件包含（文件和文件夹）
 *
 * File类的创建文件对象的API:
 * 包:java.io.File
 * 1）构造器:
 *      -- public File(string pathname):根据路径获取文件对象
 *      -- public rile(string parent , string child):根据父路径和文件名称获取文件对象
 *      -- public File(File parent , string child)
 *
 * File类创建文件对象的格式:
 *      a. File f = new File("绝对路径/相对路径");
 *          绝对路径:从磁盘的的盘符一路走到目的位置的路径。
 *                  --绝对路径依赖具体的环境，一旦脱离环境，代码可能出错!!
 *          相对路径:不带盘符的
 *                  --默认是直接相对到工程目录下寻找文件的
 *                  --相对路径只能用于寻找工程下的文件
 *                  -—能用相对路径就应该尽量使用，可以跨平台!
 *
 *      b. File f = new File("文件对象/文件夹对象");
 *          广义来说:文件是包含文件和文件夹的。
 *
 * 文件路径分隔符:
 *      -- a.使用正斜杠: "/"
 *      -- b.使用反斜杠: "\\"
 *      -- c.使用分隔符API: File.separator
 *
 * 目标:File类的获取功能的API
 *      - public string getAbsolutePath():      返回此File的绝对路径名字符串。
 *      - public string getPath():              获取创建文件对象的时候用的路径
 *      - public string getName():              返回由此File表示的文件或目录的名称。
 *      - public long length():                 返回由此rile表示的文件的长度。
 *
 * 目标:File类的判断功能的方法
 *      - public boolean exists():          此File表示的文件或目录是否实际存在。
 *      - public boolean isDirectory():     此File表示的是否为目录。
 *      - public boolean isFile():          此File表示的是否为文件
 *
 * 目标:File类的创建和删除的方法
 *      - public boolean createNewFile():   当且仅当具有该名称的文件尚不存在时，
 *                                          创建一个新的空文件。(几乎不用的，因为以后文件都是自动创建的!)
 *      - public boolean delete():          删除由此File表示的文件或目录。（只能删除空目录)
 *      - public boolean mkdir():           创建由此File表示的目录（只能创建一级目录)
 *      - public boolean mkdirs():          可以创建多级目录（建议使用的）
 *
 * 目标:rile针对目录的遍历
 *      - public string[] list():               获取当前目录下所有的”一级文件名称"到一个字符串数组中去返回。
 *      - public file[] listFiles()(常用):       获取当前目录下所有的"一级文件对象"到一个文件对象数组中去返回（重点）
 *
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建文件对象
        File file1 = new File("/home/centuryw/.xsession-errors");
        System.out.println(file1.length());  // 文件大小(字节大小)
        // 绝对路径
        System.out.println(file1.getAbsoluteFile());
        // 获取创建文件对象的时候用的路径
        System.out.println(file1.getPath());
        // 返回由此File表示的文件或目录的名称
        System.out.println(file1.getName());


        // 2.创建文件夹对象
        File file2 = new File("/home/centuryw");
        System.out.println(file2.exists()); // 判断文件夹是否存在
        System.out.println(file2.isDirectory());    // 是否为目录
        System.out.println(file2.isFile());         // 是否为文件

        // 创建文件与删除文件
        File file3 = new File("/home/centuryw/文档/test.txt");
        file3.createNewFile();  // 创建一个新的空文件
        file3.delete();         // 删除文件

        // 创建目录
        File file4 = new File("/home/centuryw/文档/test");
        file4.mkdir();

        // 创建多级目录
        File file5 = new File("/home/centuryw/文档/test/hello");
        file5.mkdirs();
        file5.delete();
        file4.delete();

        // 获取目录文件名称
        String[] filesName = new File("/home/centuryw/文档").list();
        for (String name:filesName){
            System.out.println(name);
        }
        // 获取目录对象下所有一级文件对象数组
        File[] filesObject = new File("/home/centuryw/文档").listFiles();
        for (File file:filesObject){
            System.out.println(file.getAbsoluteFile()); // 获取文件对象绝对路径
        }

        // 获取文件最后修改时间
        File file6 = new File("/home/centuryw/文档/Tencent Files");
        long fileModifyTime = file6.lastModified();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(fileModifyTime));

    }
}
