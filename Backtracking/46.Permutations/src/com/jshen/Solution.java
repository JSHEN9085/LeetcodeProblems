package com.jshen;

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length == 0 || nums == null) return res;

        List<Integer> combo = new ArrayList<>();
        boolean[] tracker = new boolean[nums.length];
        helper(res, combo, nums, tracker);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> combo,
                        int[] nums, boolean[] tracker){

        if(combo.size() == nums.length){
            res.add(new ArrayList<Integer>(combo));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(tracker[i] == true){
                continue;
            }
            combo.add(nums[i]);
            tracker[i] = true;
            helper(res, combo,nums, tracker);
            combo.remove(combo.size() - 1);
            tracker[i] = false;
        }
    }


}
