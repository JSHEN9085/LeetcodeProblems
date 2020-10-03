package com.jshen;

public class Intersection {
    
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;
        int countA = 0;
        int countB = 0;

        while(pA != pB && countA < 2 && countB < 2){
            if(pA.next != null){
                pA = pA.next;
            } else {
                pA = headB;
                countA++;
            }

            if(pB.next != null){
                pB = pB.next;
            } else {
                pB = headA;
                countB++;
            }
        }
        if(pA == pB){
            return pA;
        } else {
            return null;
        }
    }
}
