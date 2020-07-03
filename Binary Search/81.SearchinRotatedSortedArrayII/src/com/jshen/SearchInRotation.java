package com.jshen;

public class SearchInRotation {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;

        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(nums[mid] == target) return true;

            if(nums[start] < nums[mid]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid;
                } else {
                    start = mid;
                }
            } else if(nums[start] > nums[mid]) {
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid;
                } else {
                    end = mid;
                }
            } else { //as num could be duplicated, so in case we have this [1, 3, 1, 1, 1], origin should be [1, 1, 1, 1, 3]
                start++;
            }
        }
        if(nums[start] == target || nums[end] == target) return true;
        return false;
    }
}
