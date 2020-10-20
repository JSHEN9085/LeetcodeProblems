package com.jshen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new LinkedList<>();
        dfs(nums, res, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int start, List<Integer> temp){
        res.add(new ArrayList<Integer>(temp));
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            dfs(nums, res, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
