package com.usc.basic;

/**
 * @author jianjianDuan
 * @date 2021/10/11 3:25 下午
 * <p>
 * 邻接表 todo:// 完成
 */
public class Graph {
    // 图的边
    public static int M = 15;
    // 图的点
    public static int N = 10;

    public int[] he = new int[N]; // 存储的是某个节点对应边的头结点

    public int[] e = new int[M]; // 用于访问某一条边对应边的尾节点;

    public int[] ne = new int[M]; // 用于找到某一条边的下一条边

    public int[] w = new int[M]; // 用于表示某一条边的权重

    public int idx = 0; // 对边进行编号

    // 往图中添加元素 a --> b
    void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        w[idx] = c;
        idx++;
    }

    // 遍历图
    public void printGraph(int a) {
        // 遍历边
        for (int i = he[a]; i != -1; i = ne[i]) {
            int b = e[i];
            int c = w[i];
            // 存在a -> b 权重为c
        }
    }
}
