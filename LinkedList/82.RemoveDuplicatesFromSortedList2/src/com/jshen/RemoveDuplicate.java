package com.jshen;

public class RemoveDuplicate {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //two pointer method 1
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null) return head;
//
//        ListNode fakeHead = new ListNode(-1);
//        fakeHead.next = head;
//        head = fakeHead;
//        ListNode pointer = null;
//
//        while(head.next != null && head.next.next != null){
//            if(head.next.val == head.next.next.val){
//                pointer = head.next.next;
//                while(pointer.next != null && pointer.val == pointer.next.val){
//                    pointer = pointer.next;
//                }
//                head.next = pointer.next;
//            } else {
//                head = head.next;
//            }
//        }
//        return fakeHead.next;
//    }

    //iterative solution version 2, moving two pointer all the time, but less writing
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode cur = head;

        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(pre.next != cur){
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }
}
