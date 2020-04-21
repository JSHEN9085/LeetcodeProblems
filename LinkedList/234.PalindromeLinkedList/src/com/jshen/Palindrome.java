package com.jshen;

public class Palindrome {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){ //getting the middle point, if two middle point, slow is the second one
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = null;
        while(slow != null){
            ListNode tem = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tem;
        }
        //after swapping the 2nd half of list, pre is the completed 2nd half

        while(pre != null){
            if(head.val != pre.val){
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}
