package cn.centuryw.beginToLearn;

/**
 * 测试break和continue
 *
 * @author centuryw
 */
public class TestBreakContinue {
    public static void main(String[] args) {
        //打印101-150之间的所有质数  质数:只能被1和它本身整除的数
        outer:for (int i = 101; i <= 150; i++) {    //带标签的continue
            for(int j=2;j<i/2;j++){
                if(i%j==0){
                    continue outer;
                }
            }
            System.out.print(i+"\t");
        }
    }
}
