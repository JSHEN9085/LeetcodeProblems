package com.jshen;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){val = x;}
    }

    public List<String> binaryTreePaths(TreeNode root){
        LinkedList<String> res = new LinkedList<>();
        if(root == null) return res;

        StringBuilder sb = new StringBuilder();
        helper(res, sb, root);

        return res;
    }

    private void helper(LinkedList<String> res, StringBuilder sb, TreeNode node){
        if(node == null) return;

        int length = sb.length();
        sb.append(node.val);

        if(node.left == null && node.right == null){
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, sb, node.left);
            helper(res, sb, node.right);
        }
        sb.setLength(length);
    }

    //iterative, but space costly, because manipulate the string every time
//    public List<String> binaryTreePaths(TreeNode root){
//        List<String> res = new LinkedList<>();
//        if(root == null) return res;
//
//        Stack<TreeNode> treeStack = new Stack<>();
//        treeStack.push(root);
//
//        Stack<String> paths = new Stack<>();
//        paths.push("");
//
//
//        while(!treeStack.isEmpty()){
//            TreeNode cur = treeStack.pop();
//            String curPath = paths.pop();
//            System.out.println(cur.val);
//            if(cur.left == null && cur.right == null){
//                res.add(0, curPath + cur.val);
//            }
//
//            if(cur.left != null){
//                treeStack.push(cur.left);
//                paths.push(curPath + cur.val + "->");
//            }
//
//            if(cur.right != null){
//                treeStack.push(cur.right);
//                paths.push(curPath + cur.val + "->");
//            }
//        }
//        return res;
    }
}
