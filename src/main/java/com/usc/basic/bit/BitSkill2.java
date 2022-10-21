package com.usc.basic.bit;

/**
 * @author jianjianDuan
 * @date 2021/12/1 5:50 PM
 */
public class BitSkill2 {
    public static void main(String[] args) {
        long l = new BitSkill2().binPow2(2, 3);
        System.out.println(l);

    }


    // f(2, 3) <- f(2, 1) <- f(2, 0)
    // f(2,0) = 1
    // f(2,1) = f(2,0) * f(2,0) * 2 = 2
    // f(2, 3) = f(2,1) * f(2,1) * 2 = 8
    // 快速幂递归
    public long binPow1(long a, long b) {
        if (b == 0) return 1;
        long res = binPow1(a, b >> 1);
        if ((b & 1) == 0) return res * res;
        else return res * res * a;
    }

    // 快速幂非递归
    public long binPow2(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 0) res = res * res;
            else res = res * res * a;
            b >>= 1;
        }

        return res;
    }


//    // 遍历 u 的非空子集
//    for (int s = u; s; s = (s - 1) & u) {
//        // s 是 u 的一个非空子集
//    }


}
