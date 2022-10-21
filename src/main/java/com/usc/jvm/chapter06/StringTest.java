package com.usc.jvm.chapter06;

/**
 * @author jianjianDuan
 * @date 2022/2/14 10:33 AM
 */
public class StringTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<10000; i++) {
            String s = new String("aaa" + i);
            Thread.sleep(3000);
        }
    }
}
