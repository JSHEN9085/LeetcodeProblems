package com.jshen;

import java.util.HashMap;
import java.util.Map;

public class ReorderList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //brute force solution, O(n) but it actually O(2n)
//    public void reorderList(ListNode head) {
//        if(head == null) return;
//
//        int index = 0;
//        ListNode current = head.next;
//        Map<Integer, ListNode> storage = new HashMap<>();
//
//        while(current != null){
//            index++;
//            storage.put(index, current);
//            current = current.next;
//        }
//
//        int counter = 1;
//        while(!storage.isEmpty()){
//            head.next = storage.remove(index);
//            index--;
//            head = head.next;
//
//            head.next = storage.remove(counter);
//            counter++;
//            head = head.next;
//        }
//        if(head != null) head.next = null;
//    }

    //iterative solution, O(n), actually O(n) + O(1/2n)
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode fast = head;
        ListNode slow = head;
        //find the middle point, if two middle point, slow is the first one
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //and then reverse the 2nd half of the list
        ListNode startOfSecondHalf = slow.next;
        ListNode pointer = startOfSecondHalf;
        slow.next = null; //cut the link between 1st and 2nd half example 1->2->3->4, make 2.next = null
        while(pointer != null){
            ListNode tem = pointer.next;
            pointer.next = slow;
            slow = pointer;
            pointer = tem;
        }
        startOfSecondHalf.next = null;
        //up to this point, head and slow is the two lists;

        //taking one Node from head, and then one from slow
        ListNode dummyHead = new ListNode(-1);
        while(head != null || slow != null){
            if(head != null){
                dummyHead.next = head;
                dummyHead = dummyHead.next;
                head = head.next;
            }
            if(slow != null){
                dummyHead.next = slow;
                dummyHead = dummyHead.next;
                slow = slow.next;
            }
        }
    }
}
