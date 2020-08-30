package com.usc.leetcode;

import java.util.*;

public class MergeTwoInterval {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int[] q = new int[2];
            q[0] = in.nextInt();
            q[1] = in.nextInt();
            list.add(q);
        }
        //TODO:对区间按照左端点排序
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        int ans = merge(list);
        System.out.println(ans);
    }

    public static int merge(List<int[]> list){
        List<int[]> ans = new ArrayList<>();
        if (list.size() == 0) return 0;

        int st = list.get(0)[0], ed = list.get(0)[1];

        for(int[] seg: list){
            int l = seg[0];
            int r = seg[1];
            if(r <= ed) {
                continue;
            }else if (l > ed) {
                ans.add(new int[]{st, ed});
                st = l;
                ed = r;
            }else if (l <= ed){
                ed = Math.max(r, ed);
            }
        }
        ans.add(new int[]{st, ed});
        return ans.size();
    }
}
