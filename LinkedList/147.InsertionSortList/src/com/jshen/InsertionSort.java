package com.jshen;

public class InsertionSort {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //iteration solution
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode result = new ListNode(-1); //fake head
        result.next = head;
        ListNode cur = head;
        ListNode pointer;

        while(cur.next != null){
            if(cur.val > cur.next.val){ //if current node value > next node value, and we are going to move current node
                pointer = result; //assign pointer as fake head, ready to iterate the linked list from very beginning
                while(pointer.next != null && pointer.next.val < cur.next.val){
                    pointer = pointer.next;// pointer is moving up to the last position that < cur.next.val. ex: 3 -> 8 -> 4 -> 2 -> 1, cur is at 8, and pointer would move to 3
                }
                ListNode nextNode = cur.next.next; //save node as 2
                cur.next.next = pointer.next; //4.next = 8
                pointer.next = cur.next; //3.next = 4
                cur.next = nextNode; // 8.next = 2
                //in the next loop, cur is 8, and it will compare to its next node that is 2
            } else {
                cur = cur.next; //if val is sorted, just move cur forward
            }
        }
        return result.next;
    }

    //recursion solution
//    public ListNode insertionSortList(ListNode head) {
//        if(head == null || head.next == null) return head;
//
//        ListNode pointer = insertionSortList(head.next);
//        if(head.val <= pointer.val){
//            head.next = pointer;
//            return head;
//        }
//
//        ListNode result = pointer;
//        while(pointer.next != null && pointer.next.val < head.val){
//            pointer = pointer.next;
//        }
//        head.next = pointer.next;
//        pointer.next = head;
//        return result;
//    }
}

