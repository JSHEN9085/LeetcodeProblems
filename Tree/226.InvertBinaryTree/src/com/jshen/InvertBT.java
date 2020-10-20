package com.jshen;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBT {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){val = x;}
    }

    //recursive
//    public TreeNode invertTree(TreeNode root){
//        if(root == null) return null;
//
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//
//        root.left = right;
//        root.right = left;
//
//        return root;
//    }

    //iterative
    public TreeNode invertTree(TreeNode root){
        if(root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur = root;
        q.offer(cur);

        while(!q.isEmpty()){
            cur = q.poll();
            if(cur.left != null){
                q.offer(cur.left);
            }
            if(cur.right != null){
                q.offer(cur.right);
            }

            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
        }
        return root;
    }



}
