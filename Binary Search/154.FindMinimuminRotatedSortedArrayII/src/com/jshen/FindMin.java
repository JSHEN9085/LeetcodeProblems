package com.jshen;

public class FindMin {

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = (end - start) / 2 + start;

            if(nums[mid] < nums[end]){
                end = mid;
            } else if(nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end--; // skip duplicated, in case we have nums[mid] == nums[end]
            }
        }
        return nums[start];
    }
}
