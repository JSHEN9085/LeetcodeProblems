package com.jshen;

public class Solution {
    public int maxProduct(int[] nums){
        if(nums.length == 0 || nums == null) return 0;

        int min = nums[0];
        int max = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            int tempMin = Math.min(Math.min(min * nums[i], max * nums[i]), nums[i]);
            int tempMax = Math.max(Math.max(min * nums[i], max * nums[i]), nums[i]);
            min = tempMin;
            max = tempMax;
            res = Math.max(res, max);
        }
        return res;
    }
}
