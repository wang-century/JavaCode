package cn.centuryw.BeginToLearn;

/**
 * 测试static的使用以及静态初始化块的使用
 * @author centuryw
 */
public class TestStatic {
    int id;
    String name;
    String passwd;
    static String company;
    public TestStatic(int id,String name){
        this.id = id;
        this.name = name;
    }
    public void login(){
        System.out.printf("用户%s正在登录",this.name);
    }
    public static void printCompany(){
        // login(); 调用非静态成员会报错
        System.out.println(company);
    }
    //静态块
    static {
        System.out.println("执行类的初始化工作");
        company = "centuryw";
        printCompany();
    }

    public static void main(String[] args) {
        TestStatic sta = new TestStatic(001,"小红");
        TestStatic.printCompany();
        TestStatic.company = "阿里";
        TestStatic.printCompany();
    }
}
