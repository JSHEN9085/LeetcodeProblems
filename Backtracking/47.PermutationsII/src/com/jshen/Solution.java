package com.jshen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums.length == 0 || nums == null) return res;

        Arrays.sort(nums);
        List<Integer> combo = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(res, combo, visited, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> combo,
                        boolean[] visited, int[] nums){

        if(combo.size() == nums.length){
            res.add(new ArrayList<Integer>(combo));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if( visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) ){
                continue;
            } else {
                combo.add(nums[i]);
                visited[i] = true;
                helper(res, combo, visited, nums);
                combo.remove(combo.size() - 1);
                visited[i] = false;
            }
        }
    }
}
