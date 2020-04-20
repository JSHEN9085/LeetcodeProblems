package com.jshen;

public class MergeTwoSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        } else if(l1 == null && l2 != null){
            return l2;
        } else if(l1 != null && l2 == null) {
            return l1;
        } else {
            ListNode result = new ListNode(0);
            ListNode pointer = result;

            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    pointer.next = l1;
                    l1 = l1.next;
                } else {
                    pointer.next = l2;
                    l2 = l2.next;
                }
                pointer = pointer.next;
            }
            if(l1 == null){
                pointer.next = l2;
            }
            if(l2 == null){
                pointer.next = l1;
            }
            return result.next;
        }



    }
}
