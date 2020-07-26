package com.jshen;


import java.util.HashMap;

//each input would have exactly one solution, the result is the index of those 2 numbers
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length == 0 || nums == null) return result;

        HashMap<Integer, Integer> storage = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!storage.containsKey(nums[i])){
                storage.put(target - nums[i], i);
            } else {
                result[0] = storage.get(nums[i]);
                result[1] = i;
            }
        }
        return result;
    }
}
