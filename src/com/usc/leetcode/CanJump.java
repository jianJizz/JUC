package com.usc.leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanJump {

    public static void main(String[] args) {
        CanJump.canJump(new int[]{3,2,1,0,4});
    }

    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int last = len - 1;
        //从后往前遍历
        for(int i=len- 1; i>=0; i--){
            int temp = nums[i] + i ;
            if (temp >= last) //如果当前位置可以到达last则只需要看前面是否可到达当前位置即可，即更新last为当前位置
                last = i;
        }

        return last == 0;
    }
}
