package leetcode;

public class ReverseLinkedlistII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = head;
        for (int i = 0; i < m-1; ++i) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        for (int i = m; i < n; ++i) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }
}
