package cn.centuryw.BeginToLearn;

import javax.swing.*;
import java.io.*;

/**
 * 复制文件夹
 */
public class CopyDir {
    public static void main(String[] args) throws IOException {
        copyDir(new File("/home/centuryw/文档"), new File("/home/centuryw/下载"));

    }

    /**
     * 复制文件夹
     *
     * @param srcDir  源目录
     * @param destDir 目标目录
     */
    public static void copyDir(File srcDir, File destDir) throws IOException {
        // 1.判断是否存在原路径，是否是文件夹
        if (srcDir.exists() && srcDir.isDirectory()) {
            // 2.创建复制的目标文件夹
            destDir.mkdirs();
            // 3.提取源文件夹的一级文件对象
            File[] files = srcDir.listFiles();
            // 4.判断是否存在一级文件对象
            if (files != null && files.length > 0) {
                // 5.遍历一级文件对象
                for (File file : files) {
                    if (file.isFile()) {
                        // 直接复制过去到当前路径
                        copyFile(file, new File(destDir, file.getName()));
                    } else {
                        // file是文件夹,作为新的源文件夹
                        // 目标文件夹:上一个文件夹+新文件夹名称
                        copyDir(file,new File(destDir,file.getName()));
                    }
                }
            }
        }

    }

    /**
     * 复制文件
     *
     * @param srcFile  源文件
     * @param destFile 目标目录
     */
    private static void copyFile(File srcFile, File destFile) throws IOException {
        try (
                // 创建一个低级的字节输入流与源文件接通
                InputStream is = new FileInputStream(srcFile);
                BufferedInputStream bis = new BufferedInputStream(is);
                // 创建一个低级字节输出流管道与目标文件接通
                OutputStream os = new FileOutputStream(destFile);
                BufferedOutputStream bos = new BufferedOutputStream(os);
        ) {
            // 定义一个字节数组存储字节
            byte[] buffer = new byte[1024];
            // 定义一个变量存储每次读取的字节数量
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
