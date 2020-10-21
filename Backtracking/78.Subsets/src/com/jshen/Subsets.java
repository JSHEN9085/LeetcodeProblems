package com.jshen;

import java.util.*;

public class Subsets {
    //
//    public List<List<Integer>> subsets(int[] nums){
//        List<List<Integer>> res = new LinkedList<>();
//        dfs(nums, res, 0, new ArrayList<>());
//        return res;
//    }
//
//    private void dfs(int[] nums, List<List<Integer>> res, int start, List<Integer> temp){
//        res.add(new ArrayList<Integer>(temp));
//        for(int i = start; i < nums.length; i++){
//            temp.add(nums[i]);
//            dfs(nums, res, i + 1, temp);
//            temp.remove(temp.size() - 1);
//        }
//    }

    //DFS
    public List<List<Integer>> subsets(int[] nums){
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, res, 0, path);
        return res;
    }

    private void dfs(int[] nums, int len, List<List<Integer>> res,
                     int start, Deque<Integer> path){

        if(start >= len){
            res.add(new ArrayList<>(path));
            return;
        }

        //not selecting this num
        dfs(nums, len, res, start + 1, path);

        //selecting this num
        path.push(nums[start]);
        dfs(nums,len, res, start + 1, path);
        path.pop();
    }
}
