package com.usc.leetcode;



/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrStr {
    public static void main(String[] args) {
        int i = new StrStr().strStr("a", "a");
        System.out.println(i);
//        System.out.println("hello".substring(0,2));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        int ans = -1;
        int left = 0;
        int len = needle.length();
        while(left < haystack.length() - len + 1){
            String temp = haystack.substring(left, len + left);
            if (temp.equals(needle)){
                ans = left;
                break;
            }
            left++;
        }

        return ans;
    }
}
