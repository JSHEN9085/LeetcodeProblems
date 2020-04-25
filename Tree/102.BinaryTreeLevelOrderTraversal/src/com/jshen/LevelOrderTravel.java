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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;

        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);

        while(!treeQueue.isEmpty()){
            int size = treeQueue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode currentNode = treeQueue.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.left != null){
                    treeQueue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    treeQueue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
