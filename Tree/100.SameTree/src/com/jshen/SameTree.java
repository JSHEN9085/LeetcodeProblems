package com.jshen;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while(!queue.isEmpty()){
            TreeNode pCurrent = queue.poll();
            TreeNode qCurrent = queue.poll();

            if(pCurrent == null && qCurrent == null){
                continue;
            } else if(pCurrent == null || qCurrent == null || pCurrent.val != qCurrent.val){
                return false;
            }
            queue.offer(pCurrent.left);
            queue.offer(qCurrent.left);
            queue.offer(pCurrent.right);
            queue.offer(qCurrent.right);
        }
        return true;
    }

    //recursive, this method works in Leetcode, not sure why Intellij shows error
//    public boolean isSameTree(TreeNode p, TreeNode q){
//        if(p == null && q == null){
//            return true;
//        } else if(p == null || q == null || p.val != q.val){
//            return false;
//        } else {
//            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//        }
//    }
}
