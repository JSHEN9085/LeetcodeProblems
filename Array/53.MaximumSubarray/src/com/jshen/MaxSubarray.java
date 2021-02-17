package com.jshen;

public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int max = nums[0];
        int curSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            curSum = Math.max(curSum + nums[i], nums[i]);
            max = Math.max(max, curSum);
        }
        return max;
    }
}
