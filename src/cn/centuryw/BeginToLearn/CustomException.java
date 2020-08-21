package cn.centuryw.BeginToLearn;

import java.util.Scanner;

/**
 *      自定义异常(了解)
 * 引入: Java已经为开发中可能出现的异常都设计了一个类来代丧.
 *      但是实际开发中，异常可能有无数种情况,Java无法为
 *      这个世界上所有的异常都定义一个代表类。
 *      假如一个企业如果想为自己认为的某种业务问题定义成一个异常
 *      就需要自己来自定义异常类.
 *
 * 需求:认为年龄小于o岁，大于200岁就是一个异常。
 *
 * 自定义异常:
 * 自定义编译时异常.
 *      a.定义一个异常类继承Exception.
 *      b.重写构造器。
 *      c.在出现异常的地方用throw new自定义对象抛出!
 *      编译时异常是编译阶段就报错，提醒更加强烈，一定需要处理!!
 *
 * 自定义运行时异常．
 *      a.定义一个异常类继承RuntimeException.
 *      b.重写构造器。
 *      c.在出现异常的地方用throw new自定义对象抛出!
 *
 * throws:用在方法上，用于抛出方法中的异常。
 * throw:用在出现异常的地方，用于创建异常对象且立即从此处抛出!
 */
public class CustomException {
    public static void main(String[] args) {
        try {
            checkAge(400);
        } catch (MyException e) {
            e.printStackTrace();
        }

        inputAge();

        throw new MyRuntimeException("运行异常");


    }




    /**
     * 检查年龄是否在范围内
     * @param age　年龄
     */
    static void checkAge(int age) throws MyException {
        if (age<0 || age>200){
            throw new MyException(" age error");
        }
    }

    /**
     * 小案例：输入一个合法年龄为止
     */
    static void inputAge(){
        while (true){
            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("请输入年龄:");
                int age = sc.nextInt();
                System.out.println("年龄："+age);
                break;
            }catch (Exception e){
                System.out.println("输入错误，重新输入！");
            }

        }
    }
}

/**
 * 自定义编译异常类
 */
class MyException extends Exception{
    public MyException() {
        super();
    }

    /**
     * 使用最多　　输出异常信息
     * @param message
     */
    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }

    protected MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

/**
 * 自定义运行时异常
 */
class MyRuntimeException extends RuntimeException{
    public MyRuntimeException() {
        super();
    }

    /**
     * 使用最多　　输出异常信息
     * @param message 异常信息
     */
    public MyRuntimeException(String message) {
        super(message);
    }

    public MyRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyRuntimeException(Throwable cause) {
        super(cause);
    }

    protected MyRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}