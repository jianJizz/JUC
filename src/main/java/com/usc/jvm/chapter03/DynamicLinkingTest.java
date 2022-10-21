package com.usc.jvm.chapter03;

/**
 * @author jianjianDuan
 * @date 2021/12/3 4:10 PM
 */
public class DynamicLinkingTest {
    public static void main(String[] args) {

    }

    int num = 10;

    public void methodA(){
        System.out.println("methodA()....");
    }

    public void methodB(){
        System.out.println("methodB()....");

        methodA();

        num++;
    }
}
