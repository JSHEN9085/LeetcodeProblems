package com.jshen;

public class Main {

    public static void main(String[] args) {
        class ListNode{
            int val;
            Cycle.ListNode next;
            ListNode(int x, ListNode next){
                val = x;
                next = next;
            }
        }

        ListNode two = new ListNode(2, null);
        ListNode one = new ListNode(1, two);

        System.out.println(two.next.next);

    }
}
