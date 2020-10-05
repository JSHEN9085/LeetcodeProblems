package com.jshen;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTravel {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;

        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);

        while(!treeStack.isEmpty()){
            TreeNode current = treeStack.pop();
            result.add(current.val);

            if(current.right != null){
                treeStack.push(current.right);
            }
            if(current.left != null){
                treeStack.push(current.left);
            }
        }
        return result;
    }

    //recursive
//    public List<Integer> preorderTraversal(TreeNode root){
//        List<Integer> result = new LinkedList<>();
//
//        helper(root, result);
//        return result;
//    }
//
//    private void helper(TreeNode node, List<Integer> list){
//        if(node == null) return;
//        list.add(node.val);
//        helper(node.left, list);
//        helper(node.right, list);
//    }
}
