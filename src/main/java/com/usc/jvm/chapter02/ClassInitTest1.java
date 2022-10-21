package com.usc.jvm.chapter02;

/**
 * @author jianjianDuan
 * @date 2021/11/29 11:02 下午
 *
 * 1. javac编译器自动收集类中的所有类变量的赋值动作和静态代码块中的语句合并而来
 *    <clinit>()方法中的指令按语句在源文件中出现的顺序执行
 */
public class ClassInitTest1 {
    private static int num = 1;

    static{
        num = 2;
        number = 20;
        //System.out.println(number);//报错：非法的前向引用。
    }


    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(ClassInitTest1.num); // linking之prepare 0 --> 1 --> 2
        System.out.println(ClassInitTest1.number); // linking之prepare 0 -->20 --> 10
    }
}
