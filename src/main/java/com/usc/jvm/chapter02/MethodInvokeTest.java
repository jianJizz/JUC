package com.usc.jvm.chapter02;

/**
 * @author jianjianDuan
 * @date 2021/12/27 4:59 PM
 */
public class MethodInvokeTest {
    public static void main(String[] args) {
        MethodInvokeTest test = new MethodInvokeTest();
        // final方法虽然是非虚方法但是通过invokevirtual调用
        test.get();

        //invokespecial
        test.getPrivate();

        // invokeinterface + invokedynamic(lambda表达式里的方法是动态调用的)
        MethodInterface in = () -> {

        };

        in.methodA();
    }

    public final int get() {
        return 100;
    }

    private int getPrivate() {
        return 200;
    }
}

interface MethodInterface {
    void methodA();
}
