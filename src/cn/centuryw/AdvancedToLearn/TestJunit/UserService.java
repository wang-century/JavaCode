package cn.centuryw.AdvancedToLearn.TestJunit;

/**
 * 模拟用户登录业务
 */
public class UserService {
    public String login(String userName,String passWord){
        if (userName.equals("admin") && passWord.equals("123")){
            return "success";
        }
        return "用户名或密码错误";
    }

    public void division(int number1,int number2){
        int result = number1/number2;
        System.out.println(result);
    }
}
