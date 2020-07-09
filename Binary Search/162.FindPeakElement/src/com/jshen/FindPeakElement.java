package com.jshen;
//based on the question, in such array, [..., 2ndLast, Last], if Last > 2ndLast, Last is one of the answer too
public class FindPeakElement {

    //version 2 simplify, same run time, less code, this will end up with 1 digit interval [start], so just return start
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }


    //version own solution, this solution will end up with 2 digit interval [start, end], so we need to compare it at the end
//    public int findPeakElement(int[] nums) {
//        if(nums == null || nums.length == 0) return -1;
//
//        int start = 0;
//        int end = nums.length - 1;
//
//        while(start + 1 < end){
//            int mid = (end - start) / 2 + start;
//
//            if(nums[mid] < nums[mid - 1]){
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//
//        if(nums[start] > nums[end]){
//            return start;
//        } else {
//            return end;
//        }
//    }
}
