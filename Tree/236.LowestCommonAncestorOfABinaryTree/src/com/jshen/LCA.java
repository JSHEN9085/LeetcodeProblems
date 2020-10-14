package com.jshen;

import java.util.*;

public class LCA {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){val = x;}
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//        if(root == null || root.val == p.val || root.val == q.val){
//            return root;
//        }
//
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//
//        if(left != null && right != null){
//            return root;
//        }
//
//        return left == null ? right : left;
//    }

    //iterative
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Stack<TreeNode> s = new Stack<>();
        parent.put(root, null);
        s.push(root);

        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode cur = s.pop();

            if(cur.left != null){
                s.push(cur.left);
                parent.put(cur.left, cur);
            }

            if(cur.right != null){
                s.push(cur.right);
                parent.put(cur.right, cur);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();
        while(p != null){
            ancestor.add(p);
            p = parent.get(p);
        }

        while(!ancestor.contains(q)){
            q = parent.get(q);
        }
        return q;
    }
}
