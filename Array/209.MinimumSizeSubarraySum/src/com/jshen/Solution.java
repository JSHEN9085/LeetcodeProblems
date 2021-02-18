package com.jshen;

public class Solution {
    //two pointers
    public int minSubArrayLen(int target, int[] nums){
        if(nums == null || nums.length == 0) return 0;

        int res = Integer.MAX_VALUE; //this is the final answer

        int sum = 0;
        int l = 0; //left pointer

        for(int r = 0; r < nums.length; r++){ //r is the right pointer
            sum += nums[r];

            while(sum >= target){
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
