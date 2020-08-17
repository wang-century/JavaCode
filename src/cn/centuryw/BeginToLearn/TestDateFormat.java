package cn.centuryw.BeginToLearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
    /**
     * 目标: DateFormat简单日期格式化类的使用。
     * 引入:
     * 我们之前得到的Date日期对象或者时间毫秒值的时间形式
     * 开发中并不喜欢，不符合有些时间格式的需求。
     * DateFormat作用:
     * 1.可以把日期对象或者时间毫秒值格式化成我们喜欢的时间形式。
     * 2.可以把字符串的时间形式解析成日期对象。
     * DateFormat是一个抽象类，不能直接使用，要找它的子类，simpleDateFormat
     * 我们需要用的是简单日期格式化类:simpleDateFormat
     * 格式化示例：
     *      "yyyy.MM.dd G 'at' HH:mm:ss z"	2001.07.04 AD at 12:08:56 PDT
     *      "EEE, MMM d, ''yy"	            Wed, Jul 4, '01
     *      "h:mm a"	                    12:08 PM
     *      "hh 'o''clock' a, zzzz"	        12 o'clock PM, Pacific Daylight Time
     *      "K:mm a, z"	                    0:08 PM, PDT
     *      "yyyyy.MMMMM.dd GGG hh:mm aaa"	02001.July.04 AD 12:08 PM
     *      "EEE, d MMM yyyy HH:mm:ss Z" 	Wed, 4 Jul 2001 12:08:56 -0700
     *      "yyMMddHHmmssZ"	                010704120856-0700
     *      "yyyy-MM-dd'T'HH:mm:ss.SSSZ"	2001-07-04T12:08:56.235-0700
     *      "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"	2001-07-04T12:08:56.235-07:00
     *      "YYYY-'W'ww-u"	                2001-W27-3
     */
    public static void main(String[] args) throws ParseException {
        // 将此刻日期格式化为其它格式
        Date date = new Date();
        System.out.println(date);
        // 创建格式化对象
        System.out.println("格式化后日期：");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 aaa hh:mm:ss");
        System.out.println(sdf.format(date));
        // 12分钟后的时间
        long time = date.getTime();
        time += 720*1000;
        System.out.println(sdf.format(time));

        // 字符串转为Date日期对象
        // 例："2019-11-04 09:30:30"加一天15小时30分29秒后的时间为
        String srcTime = "2019-11-04 09:30:30";     // 时间字符串
        // 1.创建日期格式化对象，注意参数必须与被转换的字符串内格式一致
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 解析字符串为Date对象
        Date newDate = sdf2.parse(srcTime);
        // 获取时间戳，对时间戳进行操作
        time = newDate.getTime() + (24L*60*60+15*60*60+30*60+29)*1000;

        System.out.println("一天15小时30分29秒后的时间为:\n"+sdf.format(time));



    }


}
