package com.jshen;

import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;

public class NextTreeNode {
    public class Node{
        int val;
        Node left;
        Node right;
        Node next;
        public Node(int x){val = x;}
    }

    public Node connect(Node root){
        if(root == null) return null;

        Node leftHead = root;

        while(leftHead.left != null){
            Node pointer = leftHead;
            while(pointer != null){
                pointer.left.next = pointer.right; //example root.left.next = root.right
                if(pointer.next != null){
                    pointer.right.next = pointer.next.left;
                }
                pointer = pointer.next;
            }
            leftHead = leftHead.left; //go to the next level after current level finished
        }
        return root;
    }

}
