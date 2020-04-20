package com.jshen;

import java.util.HashMap;
import java.util.Map;

public class ReorderList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //brute force solution, O(n) but it actually O(2n)
    public void reorderList(ListNode head) {
        if(head == null) return;

        int index = 0;
        ListNode current = head.next;
        Map<Integer, ListNode> storage = new HashMap<>();

        while(current != null){
            index++;
            storage.put(index, current);
            current = current.next;
        }

        int counter = 1;
        while(!storage.isEmpty()){
            head.next = storage.remove(index);
            index--;
            head = head.next;

            head.next = storage.remove(counter);
            counter++;
            head = head.next;
        }
        if(head != null) head.next = null;
    }
}
