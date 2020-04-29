package com.jshen;

public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //recursion solution, do merge sort for a group of linked lists
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    //sort function keep separating lists into groups of 2 lists
    private ListNode sort(ListNode[] lists, int start, int end){
        if(start >= end) return lists[start];
        int mid = (start + end) / 2;
        ListNode l1 = sort(lists, start, mid);
        ListNode l2 = sort(lists, mid+1, end);
        return merge(l1, l2);
    }

//    private ListNode merge(ListNode l1, ListNode l2){
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//
//        if(l1.val < l2.val){
//            l1.next = merge(l1.next, l2);
//            return l1;
//        }
//        l2.next = merge(l1, l2.next);
//        return l2;
//    }

    //merge function is simply merging 2 linked lists
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = new ListNode(0);
        ListNode result = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if(l1 == null) head.next = l2;
        if(l2 == null) head.next = l1;
        return result.next;
    }
}
