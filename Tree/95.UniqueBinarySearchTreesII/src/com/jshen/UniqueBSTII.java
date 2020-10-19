package com.jshen;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class UniqueBSTII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){val = x;}
    }

    public List<TreeNode> generateTrees(int n){
        if(n == 0) return new LinkedList<TreeNode>();

        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> allTrees = new LinkedList<>();

        if(start > end){
            allTrees.add(null);
            return allTrees;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    allTrees.add(cur);
                }
            }
        }
        return allTrees;
    }
}
