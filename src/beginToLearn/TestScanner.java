package beginToLearn;
import java.util.Scanner;

/**
 * 测试获取键盘输入
 * @author centuryw
 */
public class TestScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入名字：");
        String name = scanner.nextLine();
        System.out.println("请输入年龄：");
        int age = scanner.nextInt();
        System.out.println("请输入爱好：");
        String hobby = scanner.next();
        System.out.println("姓名:"+name+"\n年龄:"+age+"\n爱好:"+hobby+"\n来到地球的天数:"+(age*365));
    }
}
