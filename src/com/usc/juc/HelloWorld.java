package com.usc.juc;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HelloWorld {
	public static void main(String[] args) {
		int[] twoSum = twoSum(new int[]{1,2,4,6}, 7);
		System.out.println(Arrays.toString(twoSum));
	}
	
	
	//[2, 7, 11, 15] target 9
	public static int[] twoSum(int[] nums, int target) {
		 Map<Integer, Integer> map = new HashMap<>();
		    for (int i = 0; i < nums.length; i++) {
		        int complement = target - nums[i];
		        if (map.containsKey(complement)) {
		            return new int[] { map.get(complement), i };
		        }
		        map.put(nums[i], i);
		    }
		    throw new IllegalArgumentException("No two sum solution");
    }
}
