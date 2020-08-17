package cn.centuryw.BeginToLearn;

/**
 * Object类的用法 重写toString方法
 *
 * @author centuryw
 */
public class TestObject {
    public static void main(String[] args) {
        Person1 p = new Person1();
        p.age = 20;
        p.name = "小龙";
        System.out.println("信息:" + p.toString());
        Person1 p2 = new Person1();
        p2.age = 20;
        p2.name = "小龙";
        System.out.println(p2.equals(p));
    }
}

class Person1 {
    String name;
    int age;

    @Override
    public boolean equals(Object obj) {
        // 判断类型
        if(obj instanceof Person1){
            // 转类型
            Person1 person = (Person1)obj;
            return (this.name.equals(person.name)) && (this.age == person.age);
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        /**
         * 重写toString()
         */
        return name + ",年龄:" + age;
    }
}
