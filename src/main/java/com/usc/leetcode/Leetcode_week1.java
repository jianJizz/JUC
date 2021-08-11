package com.usc.leetcode;

/**
 * @author jianjianDuan
 * @date 2021/8/1 10:55 上午
 */
public class Leetcode_week1 {
    public static void main(String[] args) {
        new Leetcode_week1().minimumPerimeter(1);
    }

    public long minimumPerimeter(long neededApples) {
//        for (int i=2; i<neededApples+2; i+=2) {
//            if (maxApples(i) >= neededApples) {
//                return i * 4;
//            }
//        }
// 1000000000
// 5996365200
// 304698252
        // 1 2 4 6 8 10
        // 0 1 2 3 4 5
        // 0 12 60 168
        // =>12 * 2*2 = 48
        System.out.println(maxApples(6));
        return -1;
    }

    public long maxApples(int b) {
        long sum = 0;
        for (int i=2; i<=b; i+=2) {
            // b = 4 -> -2 * 2 1 0
            int tSum = 0;
            int p = i/2;
            for (int m = -p; m<=p; m++) {
                tSum += Math.abs(m) + p;
            }
            tSum *= 4;
            tSum -= 4*(p+p);
            sum += tSum;
        }
        return sum;
    }
}
