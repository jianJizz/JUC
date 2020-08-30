package com.usc.leetcode;
/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    示例:

    输入: [-2,1,-3,4,-1,2,1,-5,4],
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    进阶:

    如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/maximum-subarray
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray{
    public static void main(String[] args) {
        int sum = MaxSubArray.maxSubArray2(new int[]{1, -1, 1});
        System.out.println(sum);
    }

    // 1 2 3 4 5 -1
    // 如果sum大于0说明其对ans有增益效果，加进去，否则将sum等于当前值，更新ans
    public static int maxSubArray(int[] arr){
        int ans = arr[0];
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            if (sum > 0) sum += arr[i];
            else sum = arr[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }


    public static int maxSubArray2(int[] nums) {

        return help(nums, 0, nums.length-1);
    }

    private static int help(int[] nums, int left, int right){
        if (right == left) return nums[left];
        int mid =  (left + right) / 2;
        int m1 = help(nums, left, mid);
        int m2 = help(nums, mid+1, right);

        int leftSum = nums[mid];
        int now = 0;
        for (int i=mid-1; i>=left; i--){
            now += nums[i];
            leftSum = Math.max(leftSum, now);
        }

        int rightSum = nums[mid+1];
        now = 0;
        for(int i=mid+2; i<=right; i++){
            now += nums[i];
            rightSum = Math.max(rightSum, now);
        }
        int  m3 = leftSum + rightSum;

        return Math.max(m1, Math.max(m2, m3));
    }
    
}