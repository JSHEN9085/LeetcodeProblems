package com.jshen;

public class Search {
    //version 1, find the rotation point first
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;

        while(start < end){ //this while loop is finding the rotation point
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[end]){ //if nums[mid] > nums[end], means rotation point is at right side of mid, so we set start = mid + 1 to narrow down the range again
                start = mid + 1;
            } else {
                end = mid;
            }
        } //after this loop start(index) is the index of the rotation point

        int left = 0;
        int right = 
    }



//    version 2
//    public int search(int[] nums, int target) {
//        if(nums == null || nums.length == 0) return -1;
//
//        int start = 0;
//        int end = nums.length - 1;
//
//        while(end > start + 1){
//            int mid = start + (end - start)/2;
//            if(nums[mid] == target) return mid;
//
//            if(nums[start] < nums[mid]){ //we are in the ascending portion that doesn't have the rotation point
//                if(nums[start] <= target && target <= nums[mid]){ //if target is within the range between start and mid
//                    end = mid;
//                } else { //if target is outside the range of start and mid
//                    start = mid;
//                }
//            } else { //else condition, nums[start] > nums[mid] that means this portion contain the rotation point
//                if(nums[mid] <= target && target <= nums[end]){ //this means both mid point and target are sitting after the rotation point, example: [4, 0, 1, 2, 3], target is #2
//                    start = mid;
//                } else {
//                    end = mid;
//                }
//            }
//        }
//        if(nums[start] == target) return start;
//        if(nums[end] == target) return end;
//        return -1;
//    }
}
