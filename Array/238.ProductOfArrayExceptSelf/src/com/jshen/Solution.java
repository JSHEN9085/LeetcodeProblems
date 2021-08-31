package com.jshen;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] res = new int[l];
        res[0] = 1;

        for(int i = 1; i < l; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }

        int r = 1;
        for(int i = l - 1; i >= 0; i--){
            res[i] = res[i] * r;
            r *= nums[i];
        }
        return res;
    }
}
