package com.jshen;

import java.util.*;

public class CombinationSumII {
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> res = new LinkedList<>();
//        if(candidates.length == 0 || candidates == null) return res;
//
//        Arrays.sort(candidates);
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
//            if (i > index && candidates[i] == candidates[i-1]) continue;
//            combination.push(candidates[i]);
//            dfs(candidates, res, combination, i + 1, target - candidates[i]);
//            combination.pop();
//        }
//    }


    //dfs: choose or not choose
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        if(candidates.length == 0 || candidates == null) return res;

        List<Integer> combine = new LinkedList<>();
        dfs(candidates, res, combine, 0, target, false);
        return res;
    }

    private void dfs(int[] candidates, List<List<Integer>> res, List<Integer> combine,
                     int index, int target, boolean chosen){

        if(target == 0){
            res.add(new ArrayList<Integer>(combine));
            return;
        }

        if(index >= candidates.length || target < 0) return;

        //not choose current #
        dfs(candidates, res, combine, index + 1, target, false);

        //choose current #
        if(index >= 1 && candidates[index] == candidates[index - 1] && chosen == false) return;
        combine.add(candidates[index]);
        dfs(candidates, res, combine, index + 1, target - candidates[index], true);
        combine.remove(combine.size() - 1);
    }
}
