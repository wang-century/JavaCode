package cn.centuryw.StudentManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    /**
     * 管理类
     */
    // 键盘录入对象（全局可用）
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;     // 存储用户输入
        ArrayList<Student>student_array = new ArrayList<>();
        // 测试
        Student stu = new Student(2001,"张三",21,"1999-11-23");
        student_array.add(stu);
        Student stu2 = new Student(2002,"李四",20,"2000-11-10");
        student_array.add(stu2);

        bre:
        while (true){
            show_menu();
            System.out.print("请输入您的选择:");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    add_student(student_array);     // 添加学生
                    break;
                case 2:
                    delete_student(student_array);  // 删除学生
                    break;
                case 3:
                    update_student(student_array);  // 修改学生
                    break;
                case 4:
                    show_students(student_array);
                    break;
                case 5:
                    break bre;  // 跳出while循环
                default:
                    System.out.println("输入错误！请重新输入");
                    break;
            }
        }

    }

    public static void update_student(ArrayList<Student>student_array) {
        /* 修改学生 */
        // 输入学生学号
        System.out.print("请输入要修改的学生学号：");
        int id = sc.nextInt();
        int exist = student_is_exist(id,student_array); // 查询学生是否存在
        if (exist==-1){
            System.out.println("学号不存在！");
        }else{
            Student stu = student_array.get(exist); // 创建学生对象用于修改字段
            while(true){
                System.out.println("找到该学号学生，学生信息：");
                System.out.println("\t学号\t\t姓名\t\t年龄\t\t出生日期");
                System.out.println("\t"+stu.getId()+"\t"+stu.getName()+"\t\t"+stu.getAge()+"\t\t"+stu.getBirthday());
                System.out.print("请选择要修改的字段(1.学号 2.姓名 3.年龄 4.出生日期 5.退出)：");
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.print("请输入新的学号：");
                        id = sc.nextInt();
                        stu.setId(id);
                        break;
                    case 2:
                        System.out.print("请输入新的姓名：");
                        String name = sc.next();
                        stu.setName(name);
                        break;
                    case 3:
                        System.out.print("请输入新的年龄：");
                        int age = sc.nextInt();
                        stu.setAge(age);
                        break;
                    case 4:
                        System.out.print("请输入新的出生日期：");
                        String birthday = sc.next();
                        stu.setBirthday(birthday);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("输入错误，重新输入！");
                }
                student_array.set(exist,stu);  // 将修改后的学生信息插入集合
                System.out.println("修改成功，修改后的信息为：");
                System.out.println("\t"+student_array.get(exist).getId()+"\t"+student_array.get(exist).getName()+"\t\t"+student_array.get(exist).getAge()+"\t\t"+student_array.get(exist).getBirthday());
            }

        }



    }

    public static int student_is_exist(int id,ArrayList<Student>student_array){
        /*
            判断学号学生是否存在，存在返回索引的值，不存在返回-1
         */
        // 遍历集合，查找学号是否存在
        for (int i=0;i<student_array.size();i++){
            // 若学号存在
            if (student_array.get(i).getId()==id){
                return i;   // 将学生所在位置返回
            }
        }
        // 否则返回-1
        return -1;
    }


    public static void delete_student(ArrayList<Student> student_array) {
        /* 删除学生(通过学号) */
        System.out.print("请输入要删除的学生学号：");
        int id = sc.nextInt();
        int student_is_exist = -1;
        student_is_exist = student_is_exist(id,student_array);  // 判断学生是否存在
        if (student_is_exist!=-1){
            student_array.remove(student_is_exist);
            System.out.println("删除学生"+id+"成功！");
        }else {
            System.out.println("学号"+id+"学生不存在！");
        }
    }

    public static void show_students(ArrayList<Student> student_array) {
        /* 查看学生信息 */
        if (student_array.size() == 0){
            System.out.println("学生数据为空！");
        }else {
            System.out.println("\t学号\t\t姓名\t\t年龄\t\t出生日期");
            for (int i=0;i<student_array.size();i++){
                System.out.println("\t"+student_array.get(i).getId()+"\t"+student_array.get(i).getName()+"\t\t"+student_array.get(i).getAge()+"\t\t"+student_array.get(i).getBirthday());
            }
        }
    }

    public static void show_menu(){
        /* 显示菜单 */
        System.out.println("--------欢迎来到学生管理系统--------");
        System.out.println("1 添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查看学生");
        System.out.println("5.退出");
    }
    public static void add_student(ArrayList<Student> student_array){
        /* 添加学生 */
        int id;;
        while(true){
            System.out.print("请输入学号：");
            id = sc.nextInt();
            int exist = student_is_exist(id,student_array);
            if (exist!=-1){
                System.out.println("学号存在，请重新输入！");
            }else {
                break;
            }
        }
        System.out.print("请输入姓名：");
        String name = sc.next();
        System.out.print("请输入年龄：");
        int age = sc.nextInt();
        System.out.print("请输入出生日期(1999-10-24)：");
        String birthday = sc.next();
        // 封装学生对象并存入集合
        Student stu = new Student(id,name,age,birthday);
        student_array.add(stu);
        System.out.println("添加成功！");
    }
}
