package com.usc.jvm.chapter05;

/**
 * @author jianjianDuan
 * @date 2021/12/27 3:45 PM
 */
public class MethodAreaTest {
    public static void main(String[] args) {
        Order order = null;
        order.hello();
    }
}

class Order {
    public static void hello() {
        System.out.println("hello!");
    }
}
