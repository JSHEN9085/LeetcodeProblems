package com.jshen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> res = new LinkedList<>();
        if(candidates.length == 0 || candidates == null) return res;

        Arrays.sort(candidates);
        List<Integer> combo = new ArrayList<>();
        dfs(res, combo, candidates, target, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> combo, int[] candidates,
                     int target, int index){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<Integer>(combo));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            combo.add(candidates[i]);
            dfs(res, combo, candidates, target - candidates[i], i + 1);
            combo.remove(combo.size() - 1);
        }
    }
}
