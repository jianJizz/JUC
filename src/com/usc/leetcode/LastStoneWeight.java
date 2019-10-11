package com.usc.leetcode;
/**
 * 有一堆石头，每块石头的重量都是正整数。

每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

	如果 x == y，那么两块石头都会被完全粉碎；
	如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。


最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。


提示：

	1 <= stones.length <= 30
	1 <= stones[i] <= 1000

 */
public class LastStoneWeight {
    public static void main(String[] args) {
        int ans = LastStoneWeight.lastStoneWeight(new int[]{3,7,8});
        System.out.println(ans);
    }

    /*
     *每次找出max和second 将差值赋值给max 将second赋值为-1  
     * 每次在求max和second的时候，如果stones中有负值则忽略 否则进行计算 
     * 注意：
     * 如[3,7,8]
     * [3,-1,1]
     * [2,-1,-1]
     * 此时要加判断 如果max或second为0 说明所有的石头都粉碎了 则结束循环
     */
    public static int lastStoneWeight(int[] stones) {
        int len = stones.length;
        if (len == 1) return stones[0];
        int ans = 0;
        for (int k = 0; k < len; k++) {
            int max = 0;
            int maxIndex = 0;
            int second = 0;
            int secondIndex = 0;
            for (int i = 0; i < len; i++) {
                if (stones[i] > max && stones[i] > 0) {
                    max = stones[i];
                    maxIndex = i;
                }
            }
            if (max == 0) break;
            for (int j = 0; j < len; j++) {
                if (stones[j] > second && j != maxIndex && stones[j] > 0) {
                    second = stones[j];
                    secondIndex = j;
                }
            }
            if (second == 0) break;
            stones[maxIndex] = max - second;
            stones[secondIndex] = -1;
        }

        for (int m = 0; m < len; m++)
            if (stones[m] > 0)
                ans = stones[m];

        return ans;
    }

}