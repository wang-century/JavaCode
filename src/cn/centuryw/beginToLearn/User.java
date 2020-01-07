package cn.centuryw.beginToLearn;

/**
 * 构造方法的重载
 * @author centuryw
 */
public class User {
    int id; //用户编号
    String name;    //用户名
    String passwd;  //用户密码

    public User(){

    }
    public User(int id,String name){
        super();    //构造方法的第一句总是super()
        this.id = id;   //this表示创建好的对象
        this.name = name;
    }
    public User(int id,String name,String passwd){
        this.id = id;
        this.name = name;
        this.passwd = passwd;
    }

    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User(001,"小七");
        User u3 = new User(002,"小八","xiaoba");
    }

}
