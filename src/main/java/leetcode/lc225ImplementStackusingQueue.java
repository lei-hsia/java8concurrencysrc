package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
*   用queue实现stack，只需要一个queue
* */
public class lc225ImplementStackusingQueue {

    Queue<Integer> q;
    /** Initialize your data structure here. */
    public lc225ImplementStackusingQueue() {
        q = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
        for (int i = 1; i < q.size(); ++i) {
            q.offer(q.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        /**
         * Your MyStack object will be instantiated and called as such:
         *
         */
        lc225ImplementStackusingQueue obj = new lc225ImplementStackusingQueue();
        obj.push(3);
        obj.push(4);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.top();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}

