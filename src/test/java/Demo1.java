import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.usc.leetcode.ListNode;
import com.usc.leetcode.TreeNode;

import java.util.*;

/**
 * @author jianjianduan
 * @date 2020/10/4 6:51 下午
 */
public class Demo1 {
    public static void main(String[] args) {
        //  0   1   2  3  4  5  6   7  8  9 10 11
        //[[6],[6],[],[],[],[5],[],[],[],[],[],[]]
        //[null,true,6,6,true,true,5,true,-1,false,false,false]
        MyCircularQueue circularQueue = new MyCircularQueue(6); // 设置长度为 3
        circularQueue.enQueue(6);  // 返回 true
        circularQueue.Rear(); // 6
        circularQueue.Rear(); // 6
        circularQueue.deQueue(); // true
        circularQueue.enQueue(5); //true
        circularQueue.Rear(); // 5
        circularQueue.deQueue(); // true
        circularQueue.Front(); // -1
        circularQueue.deQueue(); // false
        circularQueue.deQueue(); // false
        circularQueue.deQueue(); // false

    }
}

class MyCircularQueue {
    int[] q;
    int head; // 队首
    int tail; // 队尾
    int size; // 队列大小
    public MyCircularQueue(int k) {
        q = new int[k];
        size = k;
        head = 0;
        tail = -1;
    }
    // 1 2 3
    // 0   2
    public boolean enQueue(int value) {
        if (tail + head < size - 1) {
            q[++tail] = value;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            move();
            return true;
        }

        return false;
    }

    public int Front() {
        if (!isEmpty()) return q[head];
        return -1;
    }

    public int Rear() {
        if (!isEmpty()) return q[tail];
        return -1;
    }

    public boolean isEmpty() {
        return tail == -1;
    }

    public boolean isFull() {
        return tail + head == size - 1;
    }

    // 将队首后面的元素往前移一位
    public void move() {

        head++;
        tail++;
        head %= size;
        tail %= size;
        if (head > tail) head = 0; tail = -1;
    }
}


