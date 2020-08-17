package cn.centuryw.BeginToLearn;

/**
 * 测试if-else选择结构
 * @author centuryw
 */
public class TestIfElse {
    public static void main(String[] args) {
        int score = (int)(6*Math.random()+1);
        if(score>3){
            System.out.println("大");
        }else{
            System.out.println("小");
        }
        System.out.println("***************");

        //随机产生一个[0.0, 4.0)之间的半径，并根据半径求圆的面积和周长
        double r = 4*Math.random();
        double circle = 2*Math.PI*r;
        double area = Math.PI * Math.pow(r,2);  //Math.pow(r,2) 求半径r的平方
        System.out.println("半径："+r);
        System.out.println("周长："+circle);
        System.out.println("面积："+area);
        //如果面积大于周长则输出”面积大于周长“，否则输出”周长大于面积“
        if(circle>area){
            System.out.println("周长大于面积");
        }else{
            System.out.println("面积大于周长");
        }
        System.out.println("***************");


        //if-else if-else多选择结构
        int age = (int)(100*Math.random());
        System.out.print("年龄:"+age+", 属于");
        if(age<15){
            System.out.println("儿童，喜欢玩");
        }else if(age<25){
            System.out.println("青年，要学习");
        }else if(age<45){
            System.out.println("中年，要工作");
        }else if(age<65){
            System.out.println("中老年，要补钙");
        }else if(age<85){
            System.out.println("老年，多运动");
        }else{
            System.out.println("老寿星，古来稀");
        }

    }
}
