package com.jshen;

public class BinarySearch {
    public int searchInsert(int[] nums, int target) {
        int head = 0;
        int tail = nums.length;
        int mid = (head + tail) / 2;

        if(target < nums[0]) return 0;

        while(nums[mid] != target){
            if(nums[mid] < target && tail - head != 1){
                head = mid;
                mid = (head + tail) / 2;
            } else if(nums[mid] > target && tail - head != 1){
                tail = mid;
                mid = (head + tail) / 2;
            } else if(tail - head == 1){
                return tail;
            } else {
                return mid;
            }
        }
        return mid;
    }
}
