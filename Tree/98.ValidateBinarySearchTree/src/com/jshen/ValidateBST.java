package com.jshen;

import java.util.ArrayDeque;
import java.util.Queue;

public class ValidateBST {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root){
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null) return true;

        if(min != null && min > root.val) return false;
        if(max != null && max < root.val) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);

    }

    //iterative
//    public boolean isValidBST(TreeNode root){
//        if(root == null) return true;
//
//        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
//        TreeNode cur = root;
//        double min = -Double.MAX_VALUE;
//
//        while(cur != null || !stack.isEmpty()){
//            while(cur!= null){
//                stack.push(cur);
//                cur = cur.left;
//            }
//
//            cur = stack.pop();
//            if(cur.val <= min) return false;
//            min = cur.val;
//            cur = cur.right;
//        }
//        return true;
//    }

}
