package com.jshen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
//Only numbers 1 through 9 are used.
//Each number is used at most once.

//    public List<List<Integer>> combinationSum3(int k, int n){
//        List<List<Integer>> res = new LinkedList<>();
//        List<Integer> combine = new ArrayList<>();
//        dfs(k, n, 1, res, combine);
//        return res;
//    }
//
//    private void dfs(int k, int n, int start, List<List<Integer>> res,
//                     List<Integer> combine){
//
//        if(combine.size() == k && n == 0){
//            res.add(new ArrayList<Integer>(combine));
//            return;
//
//        }
//
//        for(int i = start; i <= 9; i++){
//            combine.add(i);
//            dfs(k, n - i, i+1, res, combine);
//            combine.remove(combine.size() - 1);
//        }
//    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> combo = new ArrayList<>();
        dfs(k, n, 1, res, combo);
        return res;
    }

    private void dfs(int k, int n, int start, List<List<Integer>> res, List<Integer> combo){
        if(combo.size() == k && n == 0){
            res.add(new ArrayList<Integer>(combo));
            return;
        }

        if(start > 9 || combo.size() > k || n < 0) return;

        //not choose i
        dfs(k, n, start + 1, res, combo);

        //choose i
        combo.add(start);
        dfs(k, n - start, start + 1, res, combo);
        combo.remove(combo.size() - 1);
    }
}
