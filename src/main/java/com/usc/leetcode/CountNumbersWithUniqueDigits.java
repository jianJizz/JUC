package com.usc.leetcode;

/**
 * @author jianjianduan
 * @date 2020/9/14 10:51 下午
 * 计算各个位数不同的数字个数
 *
 * TODO:// 完成这道题
 */
public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {
        new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(2);
    }
    int ans = 0;
    public int countNumbersWithUniqueDigits(int n) {
        int[] track = new int[n];
        // 初始化
        for(int i=0; i<n; i++){
            track[i] = -1;
        }
        dfs(track, 1);

        return ans;
    }

    public void dfs(int[] track, int n){
        boolean flag = true;
        for(int i=0; i<n; i++){// 都选过了
            if (track[i] == -1) {
                flag = false;
                break;
            }
        }
        if (flag) {
            ans++;
            return;
        }

        for(int i=0; i<n; i++) {//n代表这次共需要选几位数
            for(int num=0; num<10; num++) {
                // 验证是否合法
                if (!isVaild(track, num, i+1)) continue;
                // 做选择
                track[i] = num;
                // 继续下一层
                dfs(track, n + 1);
                // 撤销选择
                track[i] = -1;
            }
        }
    }

    //n表示选第几位
    public boolean isVaild(int[] track, int num, int n){
        for(int j=0; j<=n; j++){
            if (track[j] != num) return false;
        }

        return true;
    }
}
