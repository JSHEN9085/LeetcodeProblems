package com.jshen;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTravel {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);

        while(!treeStack.isEmpty()){
            TreeNode cur = treeStack.pop();
            result.add(0, cur.val); //if result is declared as linked list, use result.addFirst
            if(cur.left != null){
                treeStack.push(cur.left);
            }
            if(cur.right != null){
                treeStack.push(cur.right);
            }
        }
        return result;
    }
}
