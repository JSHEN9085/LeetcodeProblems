package com.jshen;

public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

//group all odd nodes together followed by the even nodes.
//Please note we are talking about the node number(position) and not the value in the nodes

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode continus = even;

        while(even != null && even.next != null){ //even pointer is one position faster than odd, if even.next != null, odd.next.next != null for sure. by this while condition, even will be at the exact last node or null.
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = continus;
        return head;
    }
}
