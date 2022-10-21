package com.usc.jvm.chapter06;

/**
 * @author jianjianDuan
 * @date 2022/1/2 8:37 PM
 */
public class StringTableTest1 {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTableTest1 ex = new StringTableTest1();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
    }
}


