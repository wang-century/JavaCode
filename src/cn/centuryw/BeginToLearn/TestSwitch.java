package cn.centuryw.BeginToLearn;

/**
 * 测试switch语句
 * @author centuryw
 */
public class TestSwitch {
    public static void main(String[] args) {
        char c = 'a';
        int rand = (int)(26*Math.random());
        char c2 = (char)(c+rand);
        System.out.print(c2+":");
        switch (c2){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("元音");
                break;
            case 'y':
            case 'w':
                System.out.println("半元音");
                break;
            default:
                System.out.println("辅音");
        }
    }
}
