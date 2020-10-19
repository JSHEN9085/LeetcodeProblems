package com.jshen;

import java.util.LinkedList;
import java.util.Queue;

public class NextNode {

    public class Node{
        int val;
        Node left;
        Node right;
        Node next;
        public Node(int x){val = x;}
    }

    public Node connect(Node root) {
        if (root == null) return null;

        Node upperLevel = root;
        Node currentLevel = new Node(0);
        Node pointer = currentLevel;

        while (upperLevel != null) {
            if(upperLevel.left != null){
                currentLevel.next = upperLevel.left;
                currentLevel = currentLevel.next;
            }
            if(upperLevel.right != null){
                currentLevel.next = upperLevel.right;
                currentLevel = currentLevel.next;
            }

            if(upperLevel.next != null){
                upperLevel = upperLevel.next;
            } else {
                upperLevel = pointer.next;
                pointer.next = null;
                currentLevel = pointer;
            }
        }
            return root;
    }

        //using queue
//    public Node connect(Node root){
//        if(root == null) return null;
//
//        Queue<Node> q = new LinkedList<>();
//        q.offer(root);
//
//        while(!q.isEmpty()){
//            int len = q.size();
//
//            while(len > 0){
//                Node cur = q.poll();
//                if(len > 1){
//                    cur.next = q.peek();
//                }
//
//                if(cur.left != null){
//                    q.offer(cur.left);
//                }
//                if(cur.right != null){
//                    q.offer(cur.right);
//                }
//                len--;
//            }
//        }
//        return root;
//    }
}
