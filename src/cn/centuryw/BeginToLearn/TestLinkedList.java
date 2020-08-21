package cn.centuryw.BeginToLearn;

import java.util.LinkedList;

/**
 * 使用LinkedList(基于链表)实现栈和队列
 */
public class TestLinkedList {
    public static void main(String[] args) {
        // 实现栈  (先进后出)
        LinkedList<String>stack = new LinkedList<>();
        // 添加元素
        stack.push("你好");
        stack.push("世界");
        stack.push("!");
        System.out.println(stack);
        // 弹出元素
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        // 实现队列 (先进先出)
        LinkedList<String>queue = new LinkedList<>();
        // 添加元素
        queue.addLast("你好");
        queue.addLast("Java");
        queue.addLast("!");
        System.out.println(queue);
        // 取出元素
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());


    }


}
