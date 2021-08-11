package com.usc;

class Test {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + r >> 1;
            // 1, 2, 3, 4, 5
            // 0  0  0  1  1
            boolean isBadMid = isBadVersion(mid);
            if (mid -1 >= l && isBadMid && isBadVersion(mid-1) == false){
                return mid;
            }

            // 版本错误
            if (isBadMid) {
                r = mid;
            }else{
                l = mid;
            }
        }

        return -1;
    }

    public boolean isBadVersion(int n) {
        if (n == 3) return true;
        return false;
    }
    public static void main(String[] args) {

        new Test().firstBadVersion(3);
    }
}