package com.jshen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTravel {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new LinkedList<>();
//        if(root == null) return result;
//
//        Queue<TreeNode> treeQueue = new LinkedList<>();
//        treeQueue.add(root);
//
//        while(!treeQueue.isEmpty()){
//            int size = treeQueue.size();
//            List<Integer> currentLevel = new ArrayList<>();
//
//            for(int i = 0; i < size; i++){
//                TreeNode currentNode = treeQueue.poll();
//                currentLevel.add(currentNode.val);
//                if(currentNode.left != null){
//                    treeQueue.add(currentNode.left);
//                }
//                if(currentNode.right != null){
//                    treeQueue.add(currentNode.right);
//                }
//            }
//            result.add(currentLevel);
//        }
//        return result;
//    }

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode node, int height){
        if(node == null) return;
        //1st add a list into res, and then add the value of the node inside the sublist
        if(height >= res.size()){
            res.add(new LinkedList<>());
        }
        res.get(height).add(node.val);
        helper(res, node.left, height+1);
        helper(res, node.right, height+1);
    }


}
