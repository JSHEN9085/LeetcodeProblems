package com.jshen;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //iterative solution: using previous ListNode is convenience to swap LinkedList
//    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null) return head;
//
//        ListNode previous = null;
//        while(head != null){
//            ListNode tem = head.next;
//            head.next = previous;
//            previous = head;
//            head = tem;
//        }
//        return previous;
//    }

    //recursion solution
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

    }
}
