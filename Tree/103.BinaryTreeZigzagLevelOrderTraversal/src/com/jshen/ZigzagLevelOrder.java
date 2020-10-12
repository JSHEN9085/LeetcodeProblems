package com.jshen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){val = x;}
    }

//    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
//        List<List<Integer>> res = new LinkedList<>();
//        if(root == null) return res;
//
//        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        boolean forward = true;
//
//        while(!queue.isEmpty()){
//            int len = queue.size();
//            List<Integer> curLevel = new LinkedList<>();
//
//            for(int i = 0; i < len; i++){
//                TreeNode cur = queue.poll();
//                if(forward == true){
//                    curLevel.add(cur.val);
//                } else {
//                    curLevel.add(0, cur.val);
//                }
//
//                if(cur.left != null){
//                    queue.offer(cur.left);
//                }
//                if(cur.right != null){
//                    queue.offer(cur.right);
//                }
//            }
//            res.add(curLevel);
//            forward = !forward;
//        }
//        return res;
//    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        dfs(res, root, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, TreeNode node, int height){
        if(node == null) return;

        if(height >= res.size()){
            res.add(new LinkedList<>());
        }

        if(height % 2 == 1){
            res.get(height).add(0, node.val);
        } else {
            res.get(height).add(node.val);
        }

        dfs(res, node.left, height+1);
        dfs(res, node.right, height+1);

    }

}
