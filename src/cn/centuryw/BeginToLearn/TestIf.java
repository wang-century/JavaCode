package cn.centuryw.BeginToLearn;

/**
 * 测试if选择结构
 * @author centuryw
 */
public class TestIf {
    public static void main(String[] args) {
        double d = Math.random();   //反回[0,1)之间的随机数
        System.out.println(d);
        //掷骰子游戏
        int i = (int)(6*Math.random()+1);   //6*Math.random()的范围为0-5  +1之后的范围为1-6   即骰子的范围
        int j = (int)(6*Math.random()+1);
        int k = (int)(6*Math.random()+1);
        int count = i+j+k;
        //如果三个骰子之和大于15，则输出手气不错
        if(count>15){
            System.out.println("手气不错");
        }
        //如果和在10-15，则输出手气一般
        if(count>=10 && count<=15){
            System.out.println("手气一般");
        }
        //如果和小于10则手气不好
        if(count<10){
            System.out.println("手气不好");
        }
        System.out.println("总分:"+count+"分");
    }
}
