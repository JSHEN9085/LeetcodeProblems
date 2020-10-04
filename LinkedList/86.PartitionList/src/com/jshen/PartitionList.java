package com.jshen;

public class PartitionList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

    public ListNode partition(ListNode head, int x){
        if(head == null || head.next == null) return head;

        ListNode beforeX = new ListNode(0);
        ListNode cur1 = beforeX;
        ListNode afterX = new ListNode(0);
        ListNode cur2 = afterX;

        while(head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur2.next = null;
        cur1.next = afterX.next;
        return beforeX.next;

    }
}
