package com.usc.jvm.chapter03;

/**
 * @author jianjianDuan
 * @date 2021/12/2 3:44 PM
 *
 * java虚拟机栈:
 *  修改虚拟机栈的内存: -Xss256k
 *
 */
public class JavaStackTest1 {
    public static int cnt = 0;

    public static void main(String[] args) {
        System.out.println(cnt);
        cnt++;
        main(args);
    }
}
