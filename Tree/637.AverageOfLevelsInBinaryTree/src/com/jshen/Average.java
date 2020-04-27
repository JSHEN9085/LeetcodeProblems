package com.jshen;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<>();
        if(root == null) return result;

        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);

        while(!treeQueue.isEmpty()){
            int size = treeQueue.size();
            double total = 0;

            for(int i = 0; i < size; i++){
                TreeNode current = treeQueue.poll();
                total += current.val;
                if(current.left != null){
                    treeQueue.add(current.left);
                }
                if(current.right != null){
                    treeQueue.add(current.right);
                }
            }
            result.add(total / size); //When you operate on two integers, Java will produce an integer result. But if either side is a double , Java will produce a double result
        }
        return result;
    }
}
