package beginToLearn;

/**
 * 测试构造方法
 *  要点：
 *      1.通过new关键字调用
 *      2.构造器虽然有返回值，但是不能定义返回值类型(返回的值肯定是本类),不能在构造器内使用return返回某个值
 *      3.如果没有定义构造器，编译器会自动定义一个无参的构造函数，如果已定义则编译器不会自动添加
 *      4.构造器方法名必须与类名一致！
 * 测量两点之间的距离
 * @author centuryw
 */

class Point{
    double x,y;
    //构造方法名称和类名必须保持一致
    public Point(double _x, double _y){
        x = _x;
        y = _y;
    }

    public double getDIstance(Point p){
        return Math.sqrt((x-p.x)*(x-p.x)+((y-p.y)*(y-p.y)));
    }
}

public class TestConstructor {
    public static void main(String[] args) {
        Point p = new Point(3.0,4.0);
        Point origin = new Point(0.0,0.0);
        System.out.println(p.getDIstance(origin));
    }
}
