package com.usc.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {50, 30, 0, 100, 11, 2, 123, 543, 187, 49};
        RadixSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * @param arr 原数组
     */
    public static void sort(int[] arr) {
        int maxNum = maxNum(arr);
        int len = arr.length;
        List[] bucket = new ArrayList[10];
        int count = 1; //目前处理到第几位
        for (int i = 0; i < bucket.length; i++) bucket[i] = new ArrayList();
        for (int i = 0; i < maxNum; i++) {
            for (int j = 0; j < len; j++) {
                bucket[(arr[j] / count) % 10].add(arr[j]);
            }
            copy(arr, bucket);
            count *= 10;
        }


    }

    //复制数据到原始数组
    public static void copy(int[] src, List[] bucket) {
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (Object num : bucket[i]) {
                src[k++] = (int) num;
            }
            bucket[i].clear();
        }
    }

    //最高位数
    public static int maxNum(int[] arr) {
        if (arr.length == 1 && arr[0] == 0)
            return 1;
        int ans = 0;
        int len = arr.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        while (max != 0) {
            max /= 10;
            ans++;
        }

        return ans;
    }
}
