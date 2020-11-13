package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LC19RemoveNthNodefromLast {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode prev = start, cur = start;
        cur.next = head;

        int i = 0;
        while (i <= n) {
            cur = cur.next;
            i++;
        }

        while (cur != null) {
            prev = prev.next;
            cur = cur.next;
        }

        prev.next = prev.next.next;
        return start.next;
    }
}