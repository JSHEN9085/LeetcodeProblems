package com.jshen;

public class DiameterBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){val = x;}
    }

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root){
        if(root == null) return 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node){
        if(node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
