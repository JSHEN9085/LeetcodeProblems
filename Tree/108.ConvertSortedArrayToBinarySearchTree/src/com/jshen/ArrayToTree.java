package com.jshen;

public class ArrayToTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){val = x;}
    }

    public TreeNode sortedArrayToBST(int[] nums){
        if(nums == null || nums.length == 0) return null;

        return getTreeNode(nums, 0, nums.length - 1);
    }

    private TreeNode getTreeNode(int[] nums, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (end - start)/2 + start;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = getTreeNode(nums, start, mid-1);
        node.right = getTreeNode(nums, mid+1, end);

        return node;
    }
}
