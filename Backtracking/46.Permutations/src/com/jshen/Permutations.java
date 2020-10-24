package com.jshen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length == 0 || nums == null) return res;

        List<Integer> combo = new ArrayList<>();
        backtrack(nums, res, combo);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> combo){
        if(combo.size() == nums.length){
            res.add(new ArrayList<Integer>(combo));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(combo.contains(nums[i])) continue;
            combo.add(nums[i]);
            backtrack(nums, res, combo);
            combo.remove(combo.size() - 1);
        }
    }
}
