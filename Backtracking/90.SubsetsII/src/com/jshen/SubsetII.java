package com.jshen;

import java.util.*;

public class SubsetII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0) return res;

        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, res, 0, path, false);
        return res;
    }

    private void dfs(int[] nums, int len, List<List<Integer>> res,
                     int i, Deque<Integer> path, boolean chosen){

        if(i >= len){
            res.add(new ArrayList<Integer>(path));
            return;
        }

        //not select this num
        dfs(nums, len, res, i + 1, path, false);

        //selecting this num
        if(i >= 1 && nums[i] == nums[i - 1] && !chosen) return;
        path.push(nums[i]);
        dfs(nums, len, res, i + 1, path, true);
        path.pop();
    }
}
