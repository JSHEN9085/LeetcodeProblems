package com.jshen;

public class FindMin {
    //the array was sorted, but now rotated, that means finding min is same as finding the rotation point
    //so we need to located the interval that is not ascending

    //Version 2, starting from the end, with less code
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;

        while(start < end){
            int mid = (end - start) / 2 + start;
            if(nums[mid] < nums[end]){ //starting from the end can also take care the condition that without rotation
                end = mid;
            } else {
                //geting into here means nums[mid] >= nums[end], which means nums[mid] is not the smallest number in the array, so jumping into start = mid + 1 is totally fine
                start = mid + 1; //setting start < end, so we need to + 1 here, otherwise will have time limit error
            }
        }
        return nums[start];
    }


    //Version 1, own solution, but with more code
//    public int findMin(int[] nums) {
//        if(nums == null || nums.length == 0) return -1;
//
//        int start = 0;
//        int end = nums.length - 1;
//
//        while(start + 1 < end){
//            int mid = (end - start) / 2 + start;
//
////            if(nums[mid] < nums[mid - 1]){  this portion is not necessary, in fact without this portion, function requires less memory
////                return nums[mid];
////            }
//
//            if(nums[start] < nums[mid] && nums[mid] > nums[end]){
//                start = mid;
//            } else {
//                end = mid;
//            }
//        }
//
//        if(nums[start] < nums[end]){
//            return nums[start];
//        } else {
//            return nums[end];
//        }
//    }
}
