package com.usc;

class Solution {
    public int romanToInt(String s) {
        int result = 0;
        char numC;
        for(int index = s.length() - 1 ; index != -1 ; index -- ){
            numC = s.charAt(index);
            if(numC == 'I'){
                result += 1;
            }
            if(numC == 'V'){
                result += 5;
                if(index != 0 && s.charAt(index - 1) == 'I'){
                    result --;
                    index --;
                }
            }
            if(numC == 'X'){
                result += 10;
                if(index != 0 && s.charAt(index - 1) == 'I'){
                    result --;
                    index --;
                }
            }
            if(numC == 'L'){
                result += 50;
                if(index != 0 && s.charAt(index - 1) == 'X'){
                    result -= 10;
                    index --;
                }
            }
            if(numC == 'C'){
                result += 100;
                if(index != 0 && s.charAt(index - 1) == 'X'){
                    result -= 10;
                    index --;
                }
            }
            if(numC == 'D'){
                result += 500;
                if(index != 0 && s.charAt(index - 1) == 'C'){
                    result -= 100;
                    index --;
                }
            }
            if(numC == 'M'){
                result += 1000;
                if(index != 0 && s.charAt(index - 1) == 'C'){
                    result -= 100;
                    index --;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().romanToInt("IV");
    }
}