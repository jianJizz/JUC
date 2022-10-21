package com.usc.jvm.chapter02;

/**
 * @author jianjianDuan
 * @date 2021/11/30 11:22 AM
 *
 * 2. 当代码中包含static变量且有显示的赋值动作时，就会有<clinit>方法否则没有
 */
public class ClassInitTest2 {
    private int num;
    public ClassInitTest2() {
        num = 2;
    }

    public static void main(String[] args) {
    }
}
