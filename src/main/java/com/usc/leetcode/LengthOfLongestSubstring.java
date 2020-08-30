package com.usc.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring{
    public static void main(String[] args) {
        int max = new LengthOfLongestSubstring().lengthOfLongestSubstring2("abcabcbb");
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



    public int lengthOfLongestSubstring2(String s){
        int max = 0;
        char[] chs = s.toCharArray();
        int left = 0;
        int right = 0;
        while(right < chs.length){
            //遍历从left到right之间的字符，发现有重复的记录其长度，让left从重复的字符后一个开始
          for (int i = left; i < right; i++){
              if (chs[i] == chs[right]){
                  max = Math.max(max, right - left);
                  left = i + 1;//从重复的下一个字符开始
                  break;
              }
          }
          right++;
        }


        // 从left到right都没有重复那么再算一次max
        return Math.max(max, right - left);
    }
  
}