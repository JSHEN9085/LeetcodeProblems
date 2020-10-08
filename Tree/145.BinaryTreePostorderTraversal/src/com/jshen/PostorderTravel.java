package com.jshen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTravel {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if(root == null) return result;
//
//        Stack<TreeNode> treeStack = new Stack<>();
//        treeStack.push(root);
//
//        while(!treeStack.isEmpty()){
//            TreeNode cur = treeStack.pop();
//            result.add(0, cur.val); //if result is declared as linked list, use result.addFirst
//            if(cur.left != null){
//                treeStack.push(cur.left);
//            }
//            if(cur.right != null){
//                treeStack.push(cur.right);
//            }
//        }
//        return result;
//    }

    //recursive
    public List<Integer> postorderTraversal(TreeNode root){
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root);
        return res;
    }

    private void helper(LinkedList<Integer> res, TreeNode node){
        if(node == null) return;
        res.addFirst(node.val);
        helper(res, node.right);
        helper(res, node.left);
    }
}
