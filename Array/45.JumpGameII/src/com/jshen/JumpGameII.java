package com.jshen;

public class JumpGameII {
    public int jump(int[] nums){
        if(nums.length < 2) return 0;

        int minStep = 0; //this will be the answer we output
        int cur = 0; //this is the current position(index) we are at
        int max = 0; //this is the max index we can jump to for each index (same as the max we used in 55 Jump Game)

        for(int i = 0; i < nums.length; i++){

            if(i > max){
                return -1;
            } //this means even farthest jump can't reach to current index, impossible to reach to the end

            max = Math.max(max, i + nums[i]);
            if( cur == i ){
                minStep++;
                cur = max;
            }

            if (cur >= nums.length - 1) {
                break;
            } //if the cur already reach the end, no need to continue, break
        }
        return minStep;
    }
}
