package com.usc.jvm.chapter06;

import org.junit.Test;

/**
 * @author jianjianDuan
 * @date 2022/1/2 9:09 PM
 */
public class StringTableTest2 {
    public static void main(String[] args) {
        String a = "dd";
        String b  = "cc" + a;
    }

    @Test
    public void test1() {
        String s1 = new String("abc");//字面量定义的方式，"abc"存储在字符串常量池中
        String s2 = "abc";

        System.out.println(s1 == s2);// false

    }


    @Test
    public void test2() {
        String s1 = "abc";//字面量定义的方式，"abc"存储在字符串常量池中
        String s2 = "abc";

        System.out.println(s1 == s2);// true

    }

    @Test
    public void test3() {
        String s1 = new String("abc"); //在堆上创建对象

        String s2 = "abc";
        System.out.println(s1 == s2);

        s1.intern(); // 会将abc字符串放入字符串常量池，下次再调用intern方法时会直接从字符串常量池中取
        System.out.println(s1.intern() == s2);
    }
}
