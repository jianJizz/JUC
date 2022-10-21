package com.usc.jvm.chapter04;

/**
 * @author jianjianDuan
 * @date 2021/12/6 11:05 AM
 */
public class HeapTest1 {
    private int id;

    public HeapTest1(int id) {
        this.id = id;
    }

    public HeapTest1() {

    }

    public void show() {
        System.out.println(this.id);
    }

    public long get(String name) {
        return 1000L;
    }

    public int get(int id) {
        return id;
    }

    public static void main(String[] args) {
        HeapTest1 h1 = new HeapTest1(1);
        HeapTest1 h2 = new HeapTest1();
        h1.get("aaa");
        int[] arr1 = new int[10];
        Object[] obj = new Object[3];
    }


}
