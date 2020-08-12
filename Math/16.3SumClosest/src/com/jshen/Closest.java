package com.jshen;

import java.util.Arrays;

public class Closest {
    //O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2]; //just create a res (sum of any number of nums), this is for the comparison, initial value is not matter
        Arrays.sort(nums); //sorting

        for(int i = 0; i < nums.length; i++){
            int start = i + 1, end = nums.length - 1; //lock i in each loop, and then try the sum of nums[i], nums[start], and nums[end]
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target){
                    end--;
                } else {
                    start++;
                }
                if(Math.abs(sum - target) < Math.abs(res - target)){ //if the difference is smaller, update the res
                    res = sum;
                }
            }
        }
        return res;
    }
}
