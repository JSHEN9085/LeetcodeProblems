package com.jshen;

import java.util.*;

public class RecoverTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){val = x;}
    }

//    public void recoverTree(TreeNode root){
//        if(root == null) return;
//
//        Stack<TreeNode> treeStack = new Stack<>();
//        TreeNode first = null;
//        TreeNode second = null;
//        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
//        TreeNode cur = root;
//
//        while(cur != null || !treeStack.isEmpty()){
//            while(cur != null){
//                treeStack.push(cur);
//                cur = cur.left;
//            }
//
//            cur = treeStack.pop();
//
//            if(first == null && pre.val > cur.val) first = pre;
//            if(first != null && pre.val > cur.val) second = cur;
//
//            pre = cur;
//            cur = cur.right;
//        }
//
//            int tem = first.val;
//            first.val = second.val;
//            second.val = tem;
//
//    }

    //Morris Traversal O(1) space
    public void recoverTree(TreeNode root){
        if(root == null) return;

        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);

        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode temp = cur.left;
                while(temp.right != null && temp.right != cur){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = cur;
                    cur = cur.left;
                } else {
                    temp.right = null;
                    if(prev.val > cur.val && first == null){
                        first = prev;
                    }
                    if(prev.val > cur.val && first != null){
                        second = cur;
                    }
                    prev = cur;
                    cur = cur.right;
                }
            } else {
                if(prev.val > cur.val && first == null){
                    first = prev;
                }
                if(prev.val > cur.val && first != null){
                    second = cur;
                }
                prev = cur;
                cur = cur.right;
            }
        }

        if(first != null && second != null){
            int swap = first.val;
            first.val = second.val;
            second.val = swap;
        }
    }
}
