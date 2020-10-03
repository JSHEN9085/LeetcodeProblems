package com.jshen;

public class DeleteNode {

    class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){ val = x;}
    }

    public void deleteNode(ListNode node) {

//        while(node.next != null){
//            node.val = node.next.val;
//
//            if(node.next.next == null){
//                node.next = null;
//            } else {
//                node = node.next;
//            }
//        }
        node.val = node.next.val;
        node.next = node.next.next; //
    }
}
