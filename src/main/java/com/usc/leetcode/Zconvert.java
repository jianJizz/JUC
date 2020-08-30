package com.usc.leetcode;

public class Zconvert {
    public static void main(String[] args) {
        String ans = new Zconvert().convert("PAYPALISHIRING", 3);
        System.out.println(ans);
    }

   
    // down: [0, r)
    // up: [r-2, 0)
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < numRows; i++)
            sbs[i] = new StringBuilder("");

        char[] chs = s.toCharArray();
        int index = 0;
        while (index < chs.length) {

            // down
            for (int r = 0; r < numRows && index < chs.length; r++) {
                sbs[r].append(chs[index++] + "");
            }

            // up
            for (int r = numRows - 2; r > 0 && index < chs.length; r--) {
                sbs[r].append(chs[index++] + "");
            }
        }

        for (int i = 0; i < sbs.length; i++) {
            ans = ans.append(sbs[i]);
        }

        return ans.toString();

    }
}