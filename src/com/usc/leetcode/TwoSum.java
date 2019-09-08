package com.usc.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 
    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    示例:

    给定 nums = [2, 7, 11, 15], target = 9

    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
 */
public class TwoSum{

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int [] res  = new int[2];
        res =  new TwoSum().twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }



    
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int[]{-1, -1};
        if (nums == null || nums.length < 2){
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        // 把数组中的元素一个个添加到map中，如果该数字与target的差值在map中存在，那么就说明找到了 返回数组下表即可
        for (int i = 0; i < nums.length; i++){
            int remain = target - nums[i];
            if (map.containsKey(remain)){
                res[0] = map.get(remain);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    } 
}