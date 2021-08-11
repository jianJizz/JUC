package com.usc.leetcode;

/**
 * @author jianjianDuan
 * @date 2021/7/27 10:08 上午
 */
public class Leetcode_63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        uniquePathsWithObstacles(obstacleGrid);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 1. dp数组值和下标的含义 机器人从(0,0)到(i,j)位置有dp[i][j]种走法
        // 2. 确定递推公式
        // dp[i][j] = obstacleGrid[i-1][j] != 1 -> dp[i-1][j]
        // obstacleGrid[i][j-1] != 1  + dp[i][j-1]
        // 3. dp数组初始化
        // dp[i][0] = 1 and obstacleGrid[i][0] != 1, dp[0][j] = 1 and obstacleGrid[0][j] != 1
        // 4. 遍历顺序  -- 从前往后
        // 5. 举例验证dp数组
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i=0; i<m; i++) {
            if (i >= 1 && obstacleGrid[i][0] != 1 && obstacleGrid[i-1][0] != 1 && dp[i-1][0] != 0)
                dp[i][0] = 1;
        }

        for (int j=0; j<n; j++) {
            if (j >= 1 && obstacleGrid[0][j] != 1 && obstacleGrid[0][j-1] != 1 && dp[0][j-1] != 0)
                dp[0][j] = 1;
        }

        for (int i=1; i<m; i++){
            for(int j=1; j<n; j++) {
                if (obstacleGrid[i][j] != 1){
                    if (obstacleGrid[i-1][j] != 1)
                        dp[i][j] += dp[i-1][j];
                    if (obstacleGrid[i][j-1] != 1)
                        dp[i][j] += dp[i][j-1];
                }

            }
        }

        return dp[m-1][n-1];
    }
}
