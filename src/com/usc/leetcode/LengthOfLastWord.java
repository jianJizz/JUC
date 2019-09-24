package com.usc.leetcode;

public class LengthOfLastWord {
    public static void main(String[] args) {
       int len = new LengthOfLastWord().lengthOfLastWord("a ");
        System.out.println(len);
    }

    public int lengthOfLastWord(String s) {
        int ans = 0;
        s = s.trim();
        int len = s.length();
        for (int i = len-1; i >= 0; i--){
            if (s.charAt(i) == ' '){
                break;
            }
            ans++;
        }

        return ans;
    }
}
