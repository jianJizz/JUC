package com.usc.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring{
    public static void main(String[] args) {
        int max = new LengthOfLongestSubstring().lengthOfLongestSubstring2("abcdbe");
        System.out.println(max);
    }

    public int lengthOfLongestSubstring(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0; //字符串最大长度
        boolean [] used = new boolean[128];//ACCIA是128位 可以用字符直接当做数组下标
        while(right < s.length()){
            //移动right指针
            if (used[s.charAt(right)] == false){
                used[s.charAt(right)] = true;
                right++;
            }else{
                //有重复的字符 记录长度
                max = Math.max(max, right-left);   
                // 如果左边不等于右边 那么把左边的设为false 直到相等那么左边移动一个右边移动一个    
                // 这样保证了左边和右边永远是不重复的字符子串
               while(left < right && s.charAt(left) != s.charAt(right)){
                    used[s.charAt(left)] = false;
                    left++;
               }

               left++;
               right++;

            }
        }

        max = Math.max(max, right-left);

        return max;
    }


  
}