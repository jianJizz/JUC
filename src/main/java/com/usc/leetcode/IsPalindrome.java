//package com.usc.leetcode;
//public class IsPalindrome{
//
//    public boolean isPalindrome(int x) {
//        if (x < 0) return false;
//        int n = x;
//        int sum = 0;
//        //对整数x进行反转 因为x每次会除以10 且会丢掉余数所以 sum对其进行你操作即可
//        while (n != 0){
//            sum = sum * 10 + n % 10;
//            n /= 10;
//       }
//
//       return  x == sum;
//    }
//}