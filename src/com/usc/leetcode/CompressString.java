package com.usc.leetcode;

/**
 * @author jianjianduan
 *
 * 压缩字符串
 * ['a', 'a', 'a', 'b', 'b'] -> [a, 3, b, 2]
 *
 *
 * @date 2020/8/9 9:07 下午
 */
public class CompressString {
    public static void main(String[] args) {

        // a a a b b
        compress(new char[]{'o','o','o','o','o','o','o','o','o','o'});
    }



    public static int compress(char[] chars) {
        int n = chars.length;
        if (n == 0 || n == 1) return n;

        int count = 1;
        int index = 0;
        for(int i=1; i<n; i++){
            if (i == n-1 || chars[i-1] != chars[i]){
                index = getIndex(chars, count, index);
                chars[++index] = chars[i];
                count = 1;
            }

            // 1. [a, a, a]
            // 2. [a, a, c]
            if (i == n-1 && chars[i-1] == chars[i]){
                index = getIndex(chars, count, index);
            }
        }

        return index+1;
    }

    private static int getIndex(char[] chars, int count, int index) {
            if (count <= 1) return index;
            String str = String.valueOf(count);
            for(int j=0; j<str.length(); j++){
                chars[++index] = str.charAt(j);
             }
        return index;
    }

    public static int compress1(char[] chars) {
        int ans = 0;
        int n = chars.length;
        if (n == 0) return 0;

        char[] chs = new char[n];
        int count = 1;
        char curChar = chars[0];
        int index = 0;
        chs[index] = curChar;
        ans++;
        for (int i = 1; i < n; i++) {
            if (chars[i] == curChar) {
                count++;
            } else {
                String str = count + "";
                if (count > 1) {
                    ans += str.length();
                    for (int j = 0; j < str.length(); j++) {
                        chs[++index] = str.charAt(j);
                    }
                }


                curChar = chars[i];
                chs[++index] = chars[i];
                count = 1;
                ans++;
            }
            if (count > 1 && i == n - 1) {
                String str = count + "";
                ans += str.length();
                for (int j = 0; j < str.length(); j++) {
                    chs[++index] = str.charAt(j);
                }
            }
        }
        System.arraycopy(chs, 0, chars, 0, ans);

        return ans;
    }
}
