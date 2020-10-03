package com.jshen;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3 || nums == null) return false;

        int min = nums[0];
        int secondMin = Integer.MAX_VALUE;
        
        for(int num : nums){
            if(num <= min){
                min = num;
            } else if(num > min && num < secondMin){
                secondMin = num;
            } else if(num > secondMin){
                return true;
            }
        }
        return false;
    }
}
