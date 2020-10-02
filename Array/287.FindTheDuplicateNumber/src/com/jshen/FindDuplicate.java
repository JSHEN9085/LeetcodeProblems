package com.jshen;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int s = nums[0];
        int f = nums[nums[0]];

        while(s != f){
            s = nums[s];
            f = nums[nums[f]];
        }
        //***remember s and f is the actual value in nums
        //***first while loop, if s means f, that means we do have a loop in nums, but not means they meet at the point with duplicated value;

        f = 0;
        while(s != f){
            f = nums[f];
            s = nums[s];
        } //Mathematics rule: Floyd's cycle detection，https://www.youtube.com/watch?v=LUm2ABqAs1w&t=1050s
        return s;

    }
}