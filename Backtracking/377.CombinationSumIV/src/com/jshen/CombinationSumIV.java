package com.jshen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {

    }









    //DFS, but O(n^n) exceed time limit
//    public int count;
//    public int combinationSum4(int[] nums, int target) {
//        if(nums.length == 0 || nums == null) return count;
//
//        List<Integer> combo = new ArrayList<>();
//        dfs(nums, target, combo);
//        return count;
//    }
//
//    private void dfs(int[] nums, int target, List<Integer> combo){
//        if(target == 0){
//            count++;
//            return;
//        }
//
//        if(target < 0) return;
//
//        for(int i = 0 ; i < nums.length; i++){
//            combo.add(nums[i]);
//            dfs(nums, target - nums[i], combo);
//            combo.remove(combo.size() - 1);
//        }
//    }


}
