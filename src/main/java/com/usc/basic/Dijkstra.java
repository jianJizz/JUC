package com.usc.basic;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author jianjianDuan
 * @date 2021/11/4 3:43 下午
 */
public class Dijkstra {
    // 返回节点 from 到节点 to 之间的边的权重
    public int weight(int from, int to) {
        return 0;
    }

    public int[] dijkstra(int start, List<List<Integer>> graph) {
        // 图的节点个数
        int V = graph.size();
        // distTo[i] => start到i的最短路径
        int[] distTo = new int[V];
        // 初始化distTo数组,因为要求最短路所以初始为正无穷
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case: start到start距离为0
        distTo[start] = 0;
        // 优先队列 distFromStart较小的排在前面
        PriorityQueue<State> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        // 从起点start开始bfs
        q.offer(new State(start,  0));

        while (!q.isEmpty()) {
            State cur = q.poll();
            int curId = cur.id;
            int curDist = cur.dist;
            // 将邻接节点加入队列
            for (int adjId: graph.get(curId)) {
                int dist = distTo[curId] + weight(start, adjId);
                if (dist < curDist) {
                    distTo[adjId] = dist;
                    // 将邻接节点加入队列
                    q.offer(new State(adjId, dist));
                }
            }
        }

        return distTo;
    }
}


class State {
    // 图节点的 id
    public int id;
    // 从 start 节点到当前节点的距离
    public int dist;

    public State(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }
}