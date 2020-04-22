package com.jshen;

public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        //this portion is to divide linked list into 2 part, until it break into smallest unit (each ListNode)
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;

        ListNode l1 = sortList(head); //recursion
        ListNode l2 = sortList(slow); //recursion
        //divide completed here

        return merge(l1, l2); //combine portion of merge sort
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode result = dummyHead;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                dummyHead.next = l1;
                l1 = l1.next;
            } else {
                dummyHead.next = l2;
                l2 = l2.next;
            }
            dummyHead = dummyHead.next;
        }
        if(l1 == null){
            dummyHead.next = l2;
        }
        if(l2 == null){
            dummyHead.next = l1;
        }
        return result.next;
    }
}
