package com.usc.leetcode;

/**
 * @author jianjianDuan
 * @date 2021/9/1 9:36 上午
 */
public class Leetcode_165 {
    public static void main(String[] args) {
        new Leetcode_165().compareVersion("1.0.1", "1");
    }

    public int compareVersion(String version1, String version2) {
        String[] p1 = version1.split("\\.");
        String[] p2 = version2.split("\\.");

        int len1 = p1.length;
        int len2 = p2.length;

        if (len1 == len2) {
            for (int i = 0; i < len1; i++) {
                int num1 = Integer.parseInt(p1[i]);
                int num2 = Integer.parseInt(p2[i]);
                if (num1 > num2) return 1;
                else if (num1 < num2) return -1;
                else {
                    if (i == len1 - 1) return 0;
                }
            }
        }

        if (len1 < len2) {
            for (int i = 0; i < len2; i++) {
                int num1 = 0;
                int num2 = Integer.parseInt(p2[i]);
                if (i < len1) {
                    num1 = Integer.parseInt(p1[i]);
                }

                if (num1 > num2) return 1;
                else if (num1 < num2) return -1;
                else {
                    if (i == len2 - 1) return 0;
                }
            }
        }

        if (len2 < len1) {
            for (int i = 0; i < len1; i++) {
                int num1 = Integer.parseInt(p1[i]);
                int num2 = 0;
                if (i < len2) {
                    num2 = Integer.parseInt(p2[i]);
                }

                if (num1 > num2) return 1;
                else if (num1 < num2) return -1;
                else {
                    if (i == len1 - 1) return 0;
                    else continue;
                }
            }
        }

        return 0;
    }

}
