package com.jshen;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        int nodeReversed = n - m;

        while(--m > 0){
            head = head.next;
            pre = pre.next;
        }

        ListNode lastInReverse = head;
        ListNode pointer = head;
        head = head.next;
        while(nodeReversed-- > 0){
            ListNode tem = head.next;
            head.next = pointer;
            pointer = head;
            head = tem;
        }
        pre.next = pointer;
        lastInReverse.next = head;
        return fakeHead.next;
    }
}
