package com.jshen;

public class FindDuplicate {
    //Floyd's cycle detection
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


    //binary search O(NlogN)
//    public int findDuplicate(int[] nums){
//        int l = 1;
//        int r = nums.length - 1;
//
//        while(l < r){
//            int mid = l + (r - l)/2;
//            int count = 0;
//
//            for(int num : nums){
//                if(num <= mid){
//                    count++;
//                }
//            }
//            if(count > mid){
//                r = mid;
//            } else {
//                l = mid+1;
//            }
//        }
//        return l;
    }
}