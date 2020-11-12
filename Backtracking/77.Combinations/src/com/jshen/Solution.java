package com.jshen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //treat n is an int[] from [1, ..., n]
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if(k == 0) return res;

        List<Integer> combo = new ArrayList<>();
        helper(res, combo, n, k, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> combo,
                        int n, int k, int start){

        if(k == 0){
            res.add(new ArrayList<Integer>(combo));
            return;
        }

        for(int i = start; i <= n; i++){
            combo.add(i);
            helper(res, combo, n, k - 1, i + 1);
            combo.remove(combo.size() - 1);
        }
    }

//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> res = new LinkedList<>();
//        if(k == 0) return res;
//
//        List<Integer> combo = new ArrayList<>();
//        helper(res, combo, n, k, 1);
//        return res;
//    }
//
//    private void helper(List<List<Integer>> res, List<Integer> combo,
//                        int n, int k, int start){
//
//        if(combo.size() == k){
//            res.add(new ArrayList<Integer>(combo));
//            return;
//        }
//
//        if(start > n) return;
//
//        //not choose current num
//        helper(res, combo, n, k, start + 1);
//
//        //choose current num
//        combo.add(start);
//        helper(res, combo, n, k, start + 1);
//        combo.remove(combo.size() - 1);
//    }
}
