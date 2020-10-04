package com.jshen;


//Given a non-negative number represented as a singly linked list of digits, plus one to the number.
//
//        The digits are stored such that the most significant digit is at the head of the list.
//
//        Example:
//
//        Input:
//        1->2->3
//
//        Output:
//        1->2->4

public class PlusOne {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

    //O(n), worst case: for all val are 9, we need to iterate the list twice, and will be O(2n)
    public ListNode plusOne(ListNode head){
        if(head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        ListNode notNine = dummy;

        while(pointer != null){
            if(pointer.val != 9){
                notNine = pointer;
            }
            pointer = pointer.next;
        }

        notNine.val++;
        pointer = notNine.next;
        while(pointer != null){
            pointer.val = 0;
            pointer = pointer.next;
        }

        return notNine == dummy ? dummy : head;
    }


    //O(n), best is O(2n) reverse the list first, add one, and then reverse it back
    //for the worst case(all val are 9) it will be O(3n)
//    public ListNode plusOne(ListNode head){
//        if(head == null) return head;
//
//        head = reverseLinkedList(head);
//        ListNode cur = head;
//        ListNode pre = head;
//        int carry = 1;
//
//        while(cur != null){
//            pre = cur;
//            int sum = cur.val + carry;
//            cur.val = sum % 10;
//            carry = sum / 10;
//
//            if(carry == 0) break;
//            cur = cur.next;
//        }
//        if(carry == 1){
//           pre.next = new ListNode(1);
//        }
//        return reverseLinkedList(head);
//    }
//
//    private ListNode reverseLinkedList(ListNode head){
//        ListNode prev = null;
//        ListNode tem = null;
//
//        while(head != null){
//            tem = head.next;
//            head.next = prev;
//            prev = head;
//            head = tem;
//        }
//        return prev;
//    }

}
