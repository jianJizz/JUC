package com.usc.jvm.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * @author jianjianDuan
 * @date 2021/12/6 11:21 AM
 */
public class HeapTest2 {
    public static void main(String[] args) {
        "".toLowerCase();
        System.out.println("start...");
        try {
            TimeUnit.MINUTES.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end...");
    }
}
