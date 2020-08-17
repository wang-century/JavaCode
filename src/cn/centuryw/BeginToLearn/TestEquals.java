package cn.centuryw.BeginToLearn;

/**
 * equals方法测试和自定义类重写equals方法
 *
 * @author centuryw
 */
public class TestEquals {
    public static void main(String[] args) {
        Person2 p1 = new Person2(001, "小艾");
        Person2 p2 = new Person2(001, "小七");
        System.out.println(p1 == p2); //false，不是同一个对象
        System.out.println(p1.equals(p2));  //true，id相同则认为两个对象内容相同
        String s1 = new String("哈哈");
        String s2 = new String("哈哈");
        System.out.println(s1 == s2); //false，两个字符串不是同一个对象
        System.out.println(s1.equals(s2));  //true，两个字符串内容相同
    }
}

class Person2 {
    int id;
    String name;

    public Person2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {   //重写equals方法，只通过id判断是否相同
        if (this == o) return true;
        if (!(o instanceof Person2)) return false;
        Person2 person2 = (Person2) o;
        return id == person2.id;
    }

}
