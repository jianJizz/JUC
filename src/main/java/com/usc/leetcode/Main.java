package com.usc.leetcode;


import java.util.*;



public class Main {

    // 4->5->1->9
    public static void main(String[] args) {
        int i = new Main().nthUglyNumber(1000000000, 2, 217983653, 336916467);
        System.out.println(i);

    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        int f1 = arr[0], f2 = arr[1], f3 = arr[2];
        int i = f1, num = 0;
        while (true) {
            if (i % f1 == 0) num++;
            else if (i % f2 == 0) num++;
            else if (i % f3 == 0) num++;
            if (num == n) break;
            i++;
        }

        return i;
    }


}

class Trie {
    // 孩子节点
    public Trie[] children;
    // 是否以这个单词结束
    public boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        char[] chs = word.toCharArray();
        Trie node = this;
        for (int i=0; i<chs.length; i++) {
            int idx = chs[i] - 'a';
            Trie[] child = node.children;
            if (child[idx] == null) {
                child[idx] = new Trie();
            }
            node = child[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public Trie searchPrefix(String prefix) {
        // 从根开始找
        char[] chs = prefix.toCharArray();
        Trie node = this;
        for (int i=0; i<chs.length; i++) {
            int idx = chs[i] - 'a';
            Trie[] child = node.children;
            if (child[idx] == null) {
                return null;
            }
            node = child[idx];
        }

        return node;
    }
}

