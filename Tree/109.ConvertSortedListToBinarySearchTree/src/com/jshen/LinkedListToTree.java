package com.jshen;

import java.util.ArrayList;
import java.util.List;

public class LinkedListToTree {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){val = x;}
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){val = x;}
    }

//    public TreeNode sortedListToBST(ListNode head) {
//        if(head == null) return null;
//
//        ArrayList<Integer> arr = new ArrayList<>();
//        while(head != null){
//            arr.add(head.val);
//            head = head.next;
//        }
//
//        //we converted list to array;
//
//        return getTreeNode(arr, 0, arr.size() - 1);
//    }
//
//    private TreeNode getTreeNode(List<Integer> arr, int start, int end){
//        if(start > end) return null;
//
//        int mid = (end - start)/2 + start;
//        TreeNode node = new TreeNode(arr.get(mid));
//        node.left = getTreeNode(arr, start, mid-1);
//        node.right = getTreeNode(arr, mid+1, end);
//
//        return node;
//    }


    public TreeNode sortedListToBST(ListNode head){
        if(head == null) return null;
        return getTreeNode(head, null);
    }

    private TreeNode getTreeNode(ListNode head, ListNode tail){
        if(head == tail) return null;
        ListNode fast = head;
        ListNode slow = head;

        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = getTreeNode(head, slow);
        node.right = getTreeNode(slow.next, tail);
        return node;
    }

}
