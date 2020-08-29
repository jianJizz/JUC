package com.usc.javase;

/**
 * @author jianjianduan
 * @date 2020/8/10 10:48 下午
 *
 *
 * 三目运算导致的空指针异常
 */
public class TernaryOperatorNPE {
    public static void main(String[] args) {
//        boolean flag = true;
//        boolean simpleBoolean = false;
//        Boolean nullBoolean = null;
//
//        boolean b = flag ? nullBoolean : simpleBoolean;
//        System.out.println(b);

        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Boolean flag = false;
        int d = 2;
        // a*b 的结果是 int 类型，那么 c 会强制拆箱成 int 类型，抛出 NPE 异常
        Integer result=(flag? a*b : c);
    }
}
