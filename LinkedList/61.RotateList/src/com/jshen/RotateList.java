package com.jshen;

public class RotateList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //O(n)
    public ListNode rotateRight(ListNode head, int k){
        if(head == null || head.next == null || k == 0) return head;

        ListNode s = head;
        int len = 1;
        while(s.next != null){
            s = s.next;
            len++;
        } //this while loop is getting the size of the LinkedList

        s.next = head;
        k = k % len;

        for(int i = 1; i < len - k; i++){
            head = head.next;
        }
        ListNode result = head.next;
        head.next = null;
        return result;

    }


    //O(kn), where k is the times of rotation, and n is the size of the LinkedList, too slow
//    public ListNode rotateRight(ListNode head, int k) {
//        if(head == null || head.next == null || k == 0) return head;
//
//        while(k > 0){
//            head = rotate(head);
//            k--;
//        }
//
//        return head;
//
//    }
//
//    private ListNode rotate(ListNode head){
//        ListNode f = head.next;
//        ListNode s = head;
//
//        while(f.next != null){
//            f = f.next;
//            s = s.next;
//        }
//        s.next = null;
//        f.next = head;
//        return f;
//    }
}
