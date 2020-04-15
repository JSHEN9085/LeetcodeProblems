package com.jshen;

public class Swap {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //with fake head
//    public ListNode swapPairs(ListNode head) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode current = dummy;
//
//        while(current.next != null && current.next.next != null){
//            ListNode first = current.next;
//            ListNode second = current.next.next;
//
//            first.next = second.next; //key step make 3.next = 4.next, if 4 is the last one, 3.next is null
//            second.next = first;
//            current.next = second;
//            current = first;
//        }
//        return dummy.next; //dummy is the fake head, and in the first loop, we swap dummy.next as the 2nd ListNode
//    }

    //without fake head
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode current = head;
        ListNode previous = null;
        while(current != null && current.next != null){
            if(current == head) {
                head = head.next;
            } else {
                previous.next = current.next;
            }

            ListNode tem = current.next.next;
            current.next.next = current;
            current.next = tem;
            previous = current;
            current = tem;
        }
        return head;
    }

//note: Given 1->2->3->4, you should return the list as 2->1->4->3.
//the key point here is to maintain the .next relationship  between 1 and 4
//after swap 1 and 2, list is 2->1->3->4, so before swap 3 and 4, we need to build relationship that 1.next = 4
//that is why we need to maintain a previous ListNode in the function
}
