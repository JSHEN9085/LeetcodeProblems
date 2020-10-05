package com.jshen;

public class ReverseEveryK {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy;

        while(pointer != null){
            ListNode count = pointer;
            for(int i = 0; i < k && count != null; i++){
                count = count.next;
            }
            if(count == null){
                break;
            }

            ListNode prev = null;
            ListNode cur = pointer.next;
            ListNode next = null;
            for(int i = 0; i < k; i++){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            ListNode tail = pointer.next;
            tail.next = cur;
            pointer.next = prev;
            pointer = tail;
        }
        return dummy.next;
    }
}
