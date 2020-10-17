package com.jshen;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepth {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){val = x;}
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    //iterative BFS
//    public int maxDepth(TreeNode root){
//        if(root == null) return 0;
//
//        //level traversal
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        int depth = 0;
//
//        while(!q.isEmpty()){
//            depth++;
//            int len = q.size();
//            for(int i = 0; i < len; i++){
//                TreeNode cur = q.poll();
//
//                if(cur.left != null){
//                    q.offer(cur.left);
//                }
//                if(cur.right != null){
//                    q.offer(cur.right);
//                }
//            }
//        }
//        return depth;
//    }

    //DFS, slowest one
//    public int maxDepth(TreeNode root) {
//        if(root == null) return 0;
//
//        ArrayDeque<TreeNode> treeStack = new ArrayDeque<>();
//        treeStack.push(root);
//        ArrayDeque<Integer> currentDepthStack = new ArrayDeque<>();
//        currentDepthStack.push(1);
//        int maxDepth = 0;
//
//        while(!treeStack.isEmpty()){
//            TreeNode currentNode = treeStack.pop();
//            int currentDepth = currentDepthStack.pop();
//            maxDepth = Math.max(maxDepth, currentDepth);
//
//            if(currentNode.left != null){
//                treeStack.push(currentNode.left);
//                currentDepthStack.push(currentDepth + 1);
//            }
//            if(currentNode.right != null){
//                treeStack.push(currentNode.right);
//                currentDepthStack.push(currentDepth + 1);
//            }
//        }
//        return maxDepth;
//    }
}
