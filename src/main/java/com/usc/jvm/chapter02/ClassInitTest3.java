package com.usc.jvm.chapter02;

/**
 * @author jianjianDuan
 * @date 2021/11/30 11:28 AM
 *
 * 3. 若该类具有父类，JVM会保证子类的<clinit>()执行前，父类的<clinit>()已经执行完毕
 */
public class ClassInitTest3 {
    static class Father {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Son extends Father {
        public static int B = A;
    }

    public static void main(String[] args) {
        // 需要获取B -> 先加载父类的A -> A = 1 -> A = 2 -> B = A = 2;
        System.out.println(Son.B); // 2
    }
}
