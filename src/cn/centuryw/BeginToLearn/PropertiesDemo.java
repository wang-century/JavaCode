package cn.centuryw.BeginToLearn;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * 目标:Properties的概述和使用(框架底层使用，了解这个技术即可)。〈保存数据到属性文件)
 * properties:属性集对象。
 *      其实就是一个Map集合。也就是一个键值对集合。但是我们一般不会当集合使用，
 *      因为有HashMap.
 * Properties核心作用:
 *      Properties代表的是一个属性文件，可以把键值对的数据存入到一个属性文件中去。
 *      属性文件:后缀是.properties结尾的文件,里面的内容都是key=value。
 *
 * 大家在后期学的很多大型框架技术中，属性文件都是很重要的系统配置文件。
 *  users.properties
 *      admin=123456
 *      dlei=dlei
 * 需求:使用Properties对象生成一个属性文件，里面存入用户名和密码信息。
 *
 * Properties的方法:
 * public object setProperty(string key，string value) :保存一对属性。
 * public string getProperty(string key):使用此属性列表中指定的键搜索属性值
 * public set<string>stringPropertyNames() :所有键的名称的集合
 * public void store(outputstream out，string comments):保存数据到属性文件中去
 * public void store(writer fw, string comments):保存数据到属性文件中去
 *
 * 小结:
 * 属性集对象Properties实际上是一个Map集合，可以实现把键值对数据保存到
 * 属性文件中去!!
 *
 *
 * 目标:Properties读取属性文件中的键值对信息。（读取）
 *
 *
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        // 保存
        demo1();
        // 读取
        demo2();
    }

    static void demo1() throws IOException {
        // 创建一个属性集对象
        Properties properties = new Properties();
        properties.setProperty("admin","123456");
        properties.setProperty("Lucy","wa2313124");
        System.out.println(properties);
        // 把属性集对象的数据存入到属性文件
        OutputStream os = new FileOutputStream("/home/centuryw/文档/users.properties");
        /**
         * 参数一:被保存的数据的输出管道
         * 参数二:保存描述
         */
        properties.store(os,"very good");
    }

    static void demo2() throws IOException {
        // 1.创建一个属性集对象
        Properties properties = new Properties();
        System.out.println(properties);
        // 2.字节输入流加栽属性文件的数据到属性集对象properties中去。
        properties.load (new FileInputStream("/home/centuryw/文档/users.properties"));
        System.out.println(properties);
        System.out.println(properties.getProperty("admin"));

    }
}
