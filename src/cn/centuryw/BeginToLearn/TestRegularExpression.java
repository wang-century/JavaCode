package cn.centuryw.BeginToLearn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {
    /**
     * 测试正则表达式
     */
    public static void main(String[] args) {
        // 验证QQ号码是否符合规则
        String qq = "16496017";
        if (qq.matches("\\d{4,}")) {     // \\d代表数字  4代表4个以上

            System.out.println("该字符串是QQ号");
        } else {
            System.out.println("该字符串不是QQ号");
        }
        // 验证邮箱地址是否正确
        String email = "164960@qq.com";
        boolean checkEmail = checkEmailAddress(email);
        if (checkEmail) {
            System.out.println("合法邮箱");
        } else {
            System.out.println("邮箱格式不合法！");
        }
        // 验证手机号是否合法
        String phoneNumber = "15897766666";
        if (checkPhoneNumber(phoneNumber)) {
            System.out.println("手机号格式正确");
        } else {
            System.out.println("手机号格式错误");
        }
        // 正则表达式在方法中的使用
        // split
        String names = "战士,里斯,王唔";
        String[] nameArray = names.split(",");
        for (String name : nameArray) {
            System.out.println(name);
        }

        // 替换
        String names2 = "张三awdajiv231里斯waiejo1238网无123124124";
        System.out.println(names2.replaceAll("\\w+", "/"));

        spider();
    }

    static boolean checkPhoneNumber(String phone) {
        /**
         * 验证手机号是否合法
         */
        return phone.matches("1[3-9]\\d{9}");
    }

    static boolean checkEmailAddress(String email) {
        /**
         * 验证邮箱地址
         */
        return email.matches("\\w{1,}@\\w{2,10}(\\.\\w{2,10}){1,2}");
    }

    static void spider() {
        String rs = "来黑马程序学习Java,电话020-43422424，或者联系邮箱" +
                "itcast@itcast.cn,电话18762832633，0203232323" +
                "邮箱bozai@itcast.cn，400-100-3233 , 4001003232";
        // 需求:从上面的内容中爬取出电话号码和邮箱。
        // 1. 定义爬取规则
        String regex = "(\\w{1,}@\\w{2,10}(\\.\\w{2,10}){1,2})|(1[3-9]\\d{9})|(O\\d{2,5}-?\\d{5,15})|400-?\\d{3,8}-?";
        // 2.编译正则表达式成为一个匹配规则对象
        Pattern pattern = Pattern.compile(regex);
        // 3.通过匹配规则对象得到—个匹配数据内容的匹配器对象
        Matcher matcher = pattern.matcher(rs);
        // 4.通过匹配器从内容取出数据
        while (matcher.find()){
            System.out.println(matcher.group());
        }

    }


}
