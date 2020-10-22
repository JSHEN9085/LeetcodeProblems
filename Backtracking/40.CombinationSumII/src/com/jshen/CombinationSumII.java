package com.jshen;

import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(candidates.length == 0 || candidates == null) return res;

        Arrays.sort(candidates);
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
            if (i > index && candidates[i] == candidates[i-1]) continue;
            combination.push(candidates[i]);
            dfs(candidates, res, combination, i + 1, target - candidates[i]);
            combination.pop();
        }
    }
}
