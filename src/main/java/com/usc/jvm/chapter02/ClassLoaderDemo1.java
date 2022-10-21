package com.usc.jvm.chapter02;

import com.usc.leetcode.AddSum;

/**
 * @author jianjianDuan
 * @date 2021/11/10 6:22 下午
 */
public class ClassLoaderDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
//        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        System.out.println(contextClassLoader);
//        System.out.println(contextClassLoader.getParent());
//        System.out.println(contextClassLoader.getParent().getParent());


        // 类加载的三种方式
//
//        1、命令行启动应用时候由JVM初始化加载
//        2、通过Class.forName()方法动态加载
//        3、通过ClassLoader.loadClass()方法动态加载


        ClassLoader loader = AddSum.class.getClassLoader();
        // 不会执行静态代码块的方法
          loader.loadClass("com.usc.leetcode.AddSum");

        // 会执行静态代码块的方法
//        Class.forName("com.usc.leetcode.AddSum");

        // 显示指定加载器并初始化时不执行静态块
//        Class.forName("com.usc.leetcode.AddSum", false, loader);
    }
}
