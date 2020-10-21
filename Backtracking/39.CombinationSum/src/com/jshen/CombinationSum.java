package com.jshen;

import java.util.*;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(candidates.length == 0 || candidates == null) return res;

        Deque<Integer> combination = new ArrayDeque<>();
        dfs(candidates, res, combination, 0, target);
        return res;
    }

    private void dfs(int[] candidates, List<List<Integer>> res, Deque<Integer> combination,
                     int index, int target){

        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<Integer>(combination));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            combination.push(candidates[i]);
            dfs(candidates, res, combination, i, target - candidates[i]);
            target += candidates[index];
            combination.pop();
        }
    }

}
