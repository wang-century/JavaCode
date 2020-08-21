package cn.centuryw.BeginToLearn;

/**
 * 拓展:常见的运行时异常。（面试题）
 * 运行时异常的概念:
 * 继承自RuntimeException的异常或者其子类，
 * 编译阶段是不会出错的，它是在运行时阶段可能出现的错误，
 * 运行时异常编译阶段可以处理也可以不处理,代码编译都能通过!!
 * <p>
 * 1.数组索引越界异常:ArrayIndexoutOfBoundsException.
 * 2.空指针异常: NullpointerException.
 * 直接输出没有问题。但是调用空指针的变量的功能就会报错!!
 * 3.类型转换异常:classCastException.
 * 4.迭代器遍历没有此元素异常:NoSuchElementException。
 * 5.数学操作异常:ArithmeticException。
 * 6.数字转换异常:NumberFormatException。
 * <p>
 * <p>
 * 编译时异常的处理方式一。
 * 编译时异常:编译阶段就会报错，一定需要程序员处理的，否则代码无法通过!!
 * 抛出异常格式:
 * 方法 throws 异常1 ，异常2 ， ..{}
 * 建议抛出异常的方式:代表一切异常，
 * 方法 throws Exception {}
 * <p>
 * 方式一:
 * 出现编译时异常的地方层层把异常抛出去给调用者，调用者最终抛出给JVM虚拟机。
 * JVM虚拟机输出异常信息，直接干掉程序，这种方式与默认方式是一样的。
 * 这种方式并不好!
 * 虽然可以解决代码编译时的错误，但是一旦运行时真的出现异常，程序还是会立即死亡!
 * <p>
 * 方式二:在出现异常的地方自己处理，谁出现谁处理。
 * 自己捕获异常和处理异常的格式:捕获处理
 * try{
 * //监视可能出现异常的代码!
 * }catch(异常类型1 变量){
 * //处理异常
 * }catch(异常类型2 变量){
 * //处理异常
 * }...
 * <p>
 * 监视捕获处理异常企业级写法:
 * try{
 * //可能出现异常的代码!
 * }catch(Exception e) {
 * e.printStackTrace(); //直接打印异常栈信息
 * }
 * 可以捕获处理一切异常类型
 * <p>
 * <p>
 * 方式三:在出现异常的地方把异常一层一层的抛出给最外层调用者，
 * 最外层调用者集中捕获处理!!（规范做法）
 * <p>
 * 小结:
 * 编译时异常的处理方式三:底层出现的异常抛出给最外层调用者集中捕获处理。
 * 这种方案最外层调用者可以知道底层执行的情况，同时程序在出现异常后也不会立即死亡，这是理论上最好的方案。
 * <p>
 * <p>
 * 小结:
 * 运行时异常编译阶段不报错，可以处理也可以不处理，建议处理!!
 * 运行时异常可以自动抛出，不需要我们手工抛出。
 * 运行时异常的处理规范:直接在最外层捕获处理即可，底层会自动抛出!!
 * <p>
 * <p>
 * finally关键字
 * 用在捕获处理的异常格式中的，放在最后面。
 * try{
 * //可能出现异常的代码!
 * }catch(Exception e) {
 * e.printstackTrace();
 * }finally{
 * //无论代码是出现异常还是正常执行，最终一定要执行这里的代码!!
 * }
 * finally的作用:可以在代码执行完毕以后进行资源的释放操作。
 */
public class TestException {
    public static void main(String[] args) {
        try {
            // 1.数组索引越界异常:ArrayIndexoutOfBoundsException.
            int[] array_1 = {10, 20};
            System.out.println(array_1[2]);

            // 2.空指针异常: NullpointerException.
            String name = null;
            System.out.println(name);
            //System.out.println(name.length());

            // 3.类型转换异常:classCastException.
            Object o = "你好";
            //Integer s = (Integer) o;

            // 5.数学操作异常:ArithmeticException。
            System.out.println(10 / 0);

        } catch (ArrayIndexOutOfBoundsException | ArithmeticException | NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            // 6.数字转换异常:NumberFormatException。
            String num = "12aa";
            Integer i = Integer.valueOf(num);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

        divide();
    }

    static void divide(){
        try{
            System.out.println(10/0);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("Finally被执行");
        }

    }
}
