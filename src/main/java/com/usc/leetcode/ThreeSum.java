package com.usc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> lists = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List ls : lists) {
            for (Object num : ls) {
                System.out.println(num);
            }
        }

       /* int[] ints = new ThreeSum().deduplicateArr(new int[]{0,0});
        System.out.println(Arrays.toString(ints));*/

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int base = 0;
        while (base <= nums.length - 2) {
            if (base > 0 && nums[base - 1] == nums[base]){
                base++;
                continue;
            }
            int left = base + 1;
            int right = nums.length - 1;
            while (left < right ) {
                    int sum = nums[left] + nums[right] + nums[base];
                    if (sum == 0 ) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[base]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);

                        while(left < right && nums[left] == nums[left+1])
                            left++;
                        left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        right--;
                    } else if (sum < 0) {
                        while(left < right && nums[left] == nums[left+1])
                            left++;
                        left++;
                    } else {
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        right--;
                    }

            }
            base++;
        }

        return ans;
    }



    //去重并排序
    public int[] deduplicateArr(int[] arr){
        if (arr == null || arr.length < 2)
            return arr;

        int[] helpNums = arr;
        Arrays.sort(helpNums);
        boolean [] isDup = new boolean[helpNums.length];
        int trueNums = 0;
        for (int i = 0; i < helpNums.length - 1; i++) {
            if (helpNums[i+1] != helpNums[i]){
                isDup[i] = true;
                trueNums++;
            }
        }

        if (helpNums[helpNums.length - 1] != helpNums[helpNums.length - 2]) {
            isDup[isDup.length - 1] = true;
            trueNums++;
        }
        if (trueNums == 0) isDup[trueNums++] = true;

        int [] taskArr = new int[trueNums];
        int j = 0;
        for (int i = 0; i < isDup.length; i++){
            if (isDup[i] == true)
                taskArr[j++] = helpNums[i];
        }

        return taskArr;
    }
}
