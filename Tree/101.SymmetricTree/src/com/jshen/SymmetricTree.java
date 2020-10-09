package com.jshen;

import javax.swing.tree.TreeNode;
import java.util.Stack;

public class SymmetricTree {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        Stack<TreeNode> s = new Stack<>();

        s.push(root.right);
        s.push(root.left);

        while(!s.isEmpty()){
            TreeNode n1 = s.pop(); //this is left
            TreeNode n2 = s.pop(); //this is right

            if(n1 == null && n2 == null){
                continue;
            } else if(n1 == null || n2 == null || n1.val != n2.val) {
                return false;
            }

            s.push(n2.right);
            s.push(n1.left);
            s.push(n2.left);
            s.push(n1.right);
        }
        return true;
    }



//    public boolean isSymmetric(TreeNode root) {
//        if(root == null) return true;
//        return isMirror(root.left, root.right);
//
//    }
//
//    private boolean isMirror(TreeNode left, TreeNode right){
//        if(left == null && right == null){
//            return true;
//        } else if(left == null || right == null || left.val != right.val){
//            return false;
//        } else {
//            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
//        }
//    }
}
