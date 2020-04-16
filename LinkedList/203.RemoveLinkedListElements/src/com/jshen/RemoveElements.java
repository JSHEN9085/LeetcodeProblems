package com.jshen;

public class RemoveElements {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return  null;

        ListNode pointer = new ListNode(-1); //0 or -1 is same as performance
        pointer.next = head;
        head = pointer;

        while(pointer.next != null){ //checking pointer.next will only need one pointer in the list, if checking pointer, we need another pointer that siting at the previous position
            if(pointer.next.val == val){
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return head.next;
    }
}
