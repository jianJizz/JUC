package com.usc.basic.bit;

/**
 * @author jianjianDuan
 * @date 2021/12/1 4:47 PM
 */
public class BitSkill1 {


    public static void main(String[] args) {
        // 10
        System.out.println(setBit(5, 1));
    }

    // 1. 判断一个数是不是2 的非负整数次幂：
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


    // 2. 对 2的非负整数次幂取模
    public static int modPowerOfTwo(int x, int mod) {
        return x & (mod - 1);
    }

    // 3. 取绝对值
    public static int abs(int n) {
        return ((n >> 31) ^ n) - (n >> 31);
        /* n>>31 取得 n 的符号，若 n 为正数，n>>31 等于 0，若 n 为负数，n>>31 等于 -1
     若 n 为正数 n^0=n, 数不变，若 n 为负数有 n^(-1)
     需要计算 n 和 -1 的补码，然后进行异或运算，
     结果 n 变号并且为 n 的绝对值减 1，再减去 -1 就是绝对值 */
    }

    // 4. 取两个数的最大/最小值¶
    // 如果 a>=b,(a-b)>>31 为 0，否则为 -1， -1的补码为全1
    // 任何数&0 = 0, 任何数& -1 = 任何数
    // ~0 = -1, ~-1 = 0
    // 任何数 | 0 = 任何数
    public static int max(int a, int b) {
        return b & ((a - b) >> 31) | a & (~(a - b) >> 31);
    }

    public static int min(int a, int b) {
        return a & ((a - b) >> 31) | b & (~(a - b) >> 31);
    }

    // 5. 判断两非零数符号是否相同
    public static boolean isSameSign(int x, int y) {  // 有 0 的情况例外
        return (x ^ y) >= 0; // 如果两个数的最高位相同则异或的后，最高位0, 否则为1(负数)
    }


    // 6.获取一个数二进制的某一位
    // 获取 a 的第 b 位，最低位编号为 0 -> 10 > 0 & 1 = 0 ,2的第0位是0
    public static int getBit(int a, int b) {
        return (a >> b) & 1;
    }

    // 7. 将一个数二进制的某一位设置为0
    // 将 a 的第 b 位设置为 0 ，最低位编号为 0
    public static int unsetBit(int a, int b) {
        // 设a = 5 (101) b = 2 -> 结果应为: 001 -> 1
        // ~(1 << 2) = (0100) -取反-> (1011) -> -3
        //   (0101)
        // &（1011）
        //   -----
        //    0001
        return a & ~(1 << b);
    }

    // 8. 将一个数二进制的某一位设置为 ：
    // 将 a 的第 b 位设置为 1 ，最低位编号为 0
    public static int setBit(int a, int b) {
        // 设a = 5 (101) b = 1 -> 结果应为: 111 -> 7
        // 1 << 1 = (10)
        //   (101)
        // |（010）
        //   -----
        //    111
        return a | (1 << b);
    }

    // 9.将一个数二进制的某一位取反
    // 将 a 的第 b 位取反 ，最低位编号为 0
    int flapBit(int a, int b) {
        // 设 a = 5(101) b = 1 -> 结果应为: 111 -> 7
        // 1 << 1 = (10)
        //   (101)
        // ^（010）
        //   -----
        //    111
        return a ^ (1 << b);
    }


}
