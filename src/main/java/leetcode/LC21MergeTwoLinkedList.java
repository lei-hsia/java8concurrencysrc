package leetcode;

public class LC21MergeTwoLinkedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0), head = start;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                start.next = l1;
                l1 = l1.next;
            } else {
                start.next = l2;
                l2 = l2.next;
            }
            start = start.next;
        }
        start.next = (l1 == null) ? l2 : l1;
        return head.next;
    }
}