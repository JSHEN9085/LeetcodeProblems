package com.jshen;

import java.util.*;

public class CombinationSum {

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new LinkedList<>();
//        if(candidates.length == 0 || candidates == null) return res;
//
//        Deque<Integer> combination = new ArrayDeque<>();
//        dfs(candidates, res, combination, 0, target);
//        return res;
//    }
//
//    private void dfs(int[] candidates, List<List<Integer>> res, Deque<Integer> combination,
//                     int index, int target){
//
//        if(target < 0) return;
//        if(target == 0){
//            res.add(new ArrayList<Integer>(combination));
//            return;
//        }
//
//        for(int i = index; i < candidates.length; i++){
//            combination.push(candidates[i]);
//            dfs(candidates, res, combination, i, target - candidates[i]);
//            combination.pop();
//        }
//    }

    //dfs: choose or not choose
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new LinkedList<>();
        if(candidates.length == 0 || candidates == null) return res;

        List<Integer> combo = new LinkedList<>();
        dfs(candidates, res, combo, 0, target);
        return res;
    }

    private void dfs(int[] candidates, List<List<Integer>> res, List<Integer> combo,
                     int index, int target){

        if(target == 0){
            res.add(new ArrayList<Integer>(combo));
            return;
        }
        if(target < 0 || index >= candidates.length) return;

        //not choose the current num
        dfs(candidates, res, combo, index + 1, target);

        //choose the current num
        combo.add(candidates[index]);
        dfs(candidates, res, combo, index, target - candidates[index]);
        combo.remove(combo.size() - 1);
    }

}
