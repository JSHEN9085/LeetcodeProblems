package com.jshen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length == 0 || nums == null) return res;

        Arrays.sort(nums);
        List<Integer> combo = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(res, combo, nums, used);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> combo, int[] nums, boolean[] used){
        if(combo.size() == nums.length){
            res.add(new ArrayList<Integer>(combo));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] == true || i > 0 && nums[i] == nums[ i - 1] && used[i - 1] == false){
                continue;
            } else {
                combo.add(nums[i]);
                used[i] = true;
                backtracking(res, combo, nums, used);
                combo.remove(combo.size() - 1);
                used[i] = false;
            }
        }
    }
}
