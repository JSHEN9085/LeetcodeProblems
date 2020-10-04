package com.jshen;

public class Cycle {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

    public ListNode detectCycle(ListNode head){
        if(head == null || head.next == null) return null;

        ListNode f = head;
        ListNode s = head;

        while(f != null && f.next != null){

            if(f == null || f.next == null) break;
            s = s.next;
            f = f.next.next;

            if(s == f){
                f = head;
                while(s != f){
                    s = s.next;
                    f = f.next;
                }
                if(s == f) return s;
            }

        }
        return null;
    }
}
