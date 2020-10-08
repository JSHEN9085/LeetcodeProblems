package com.jshen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTravel {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if(root == null) return result;
//
//        Stack<TreeNode> treeStack = new Stack<>();
//        TreeNode current = root;
//
//        while(current != null || !treeStack.isEmpty()){
//            while(current != null){
//                treeStack.push(current);
//                current = current.left;
//            }
//            current = treeStack.pop();
//            result.add(current.val);
//            current = current.right;
//        }
//        return result;
//    }

    //recursion
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new LinkedList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode node){
        if(node == null) return;
        helper(res, node.left);
        res.add(node.val);
        helper(res, node.right);
    }
}
