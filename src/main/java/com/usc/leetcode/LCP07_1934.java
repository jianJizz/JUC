package com.usc.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jianjianDuan
 * @date 2021/7/9 10:57 上午
 */
public class LCP07_1934 {

    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> waysHash = new HashMap<>();
        for (int[] arr: relation) {
            List<Integer> value;
            if (waysHash.containsKey(arr[0])){
                value = waysHash.get(arr[0]);
            }else {
                value = new ArrayList<>();
            }
            value.add(arr[1]);
            waysHash.put(arr[0], value);
        }
        // [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]]
        //  0->2->0->4， 0->2->1->4， 0->2->3->4。
        for(int i=0; i<n; i++){
            List<Integer> value  = waysHash.getOrDefault(i, null);
            if (value == null) continue;

        }

        return -1;
    }
}
