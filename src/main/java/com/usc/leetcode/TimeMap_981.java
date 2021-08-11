package com.usc.leetcode;

import javax.management.Query;
import java.util.*;

/**
 * @author jianjianDuan
 * @date 2021/7/10 3:55 下午
 */
public class TimeMap_981 {


    private Map<String, String> timeValueMap = new HashMap<>();
    private Map<String, ArrayList<Integer>> keyTimeMap = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TimeMap_981() {
    }

    public void set(String key, String value, int timestamp) {
        timeValueMap.put(key + timestamp, value);
        ArrayList<Integer> queue = keyTimeMap.getOrDefault(key, new ArrayList<>());
        queue.add(timestamp);
        keyTimeMap.put(key, queue);
    }



    public String get(String key, int timestamp) {
        ArrayList<Integer> queue = keyTimeMap.getOrDefault(key, null);
        if (queue == null) return "";
        Collections.sort(queue);
        int preTimestamp = binarySearch(queue, timestamp);
        if (preTimestamp < 0) return "";

        String value = timeValueMap.getOrDefault(key + preTimestamp, null);
        return value == null ? "" : value;

    }

    private static int binarySearch(ArrayList<Integer> queue, int timestamp) {
        int l = 0, r = queue.size()-1;
        int max = queue.get(r);
        if (timestamp >= max) {
            return max;
        }

        // 找出比<= timestamp 中最大的
        // 2
        // 1, 2, 3, 5
        while (l <= r) {
            int mid = l + r >> 1;
            int midTime = queue.get(mid);
            if (midTime > timestamp)  {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (r < 0 ) return -1;

        return queue.get(r);
    }

    public static void main(String[] args) {
        TimeMap_981 t = new TimeMap_981();
        t.set("foo","bar",1);
        t.set("foo","bar",2);
        t.set("foo","bar2",3);
        t.set("foo","bar",5);
        t.get("foo", 4);

//        ArrayList<Integer> queue = new ArrayList<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        queue.add(5);
//        int res =  binarySearch(queue, 4);
//        System.out.println(res);
    }
}
