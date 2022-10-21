package com.usc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author jianjianDuan
 * @date 2021/9/3 4:58 下午
 */
public class Leetcode_2321 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 5, 6, 9, 4, 11, 6, 7, 2, 10, 27, 35, 21, 10, 5, 17, 30};
        new Leetcode_2321().sort3(arr);
        System.out.println(Arrays.toString(arr));
    }


    // 冒泡排序 原始版本
    public void sort1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // 交换
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    // 优化 减少比较趟数
    public void sort2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < n - i - 1; j++) {
                // 交换
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    isSorted = false;
                }
            }

            if (isSorted) break;
        }
    }

    // 优化 减少每一轮比较次数
    public void sort3(int[] arr) {
        int n = arr.length;
        // 每一轮结束后最后一次交换的位置
        int lastExchangeIndex = 0;
        // 下一轮比较从最后一次交换的位置开始
        int border = n - 1;
        for (int i = 0; i < n - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < border; j++) {
                // 交换
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            if (isSorted) break;
            border = lastExchangeIndex;
        }
    }
}
