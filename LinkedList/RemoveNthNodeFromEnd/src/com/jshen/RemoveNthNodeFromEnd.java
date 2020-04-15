package com.jshen;

public class RemoveNthNodeFromEnd {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Maintain two pointers and update one with a delay of n steps.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        ListNode pointer1 = head;
        ListNode pointer2 = head;
        for(int i = 0; i < n; i++){
            pointer1 = pointer1.next;
        }

        if(pointer1 == null) return head.next;
        //question mentioned n is always valid, so it means n won't be 2 greater then "size of the list"
        //for 1->2->3->4->5, we need to treat it as 1->2->3->4->5->null if n is 5, it means deleting the first node, count 5 starting from end(null)

        while(pointer1 != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        pointer2.next = pointer2.next.next;
        return head;
    }
}
