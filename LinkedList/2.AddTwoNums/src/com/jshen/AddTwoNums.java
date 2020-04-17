package com.jshen;

import java.util.LinkedList;

public class AddTwoNums {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode pointer = result;
        int sum = 0;

        while(l1 != null || l2 != null){
//            if(l1 != null && l2 != null){
//                sum += l1.val + l2.val;
//                l1 = l1.next;
//                l2 = l2.next;
//            } else if(l1 == null && l2 != null){
//                sum += l2.val;
//                l2 = l2.next;
//            } else {
//                sum += l1.val;
//                l1 = l1.next;
//            } //counting l1.val + l2.val, below is simplified version
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode next = new ListNode(sum % 10);
            pointer.next = next;
            pointer = pointer.next;
            sum /= 10;
        }

        if(sum == 1){
            ListNode next = new ListNode(sum);
            pointer.next = next;
        }
        return result.next;
    }
}
