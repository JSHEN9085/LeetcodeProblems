package com.jshen;

import java.util.ArrayList;
import java.util.List;

public class FindFirstAndLast {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return new int[] {-1, -1};
        }
        //perform 2 times of binary search in this nums array, first is to find the starting position, second is to find the last position
        int start = findFirst(nums, target); //finding the start position here
        if(start == -1) return new int[] {-1, -1}; //if findFirst reture -1, it means target is not in the array, so just return [-1, -1]
        int end = findLast(nums, target); //finding last position here, since we ensure target is in the array, so no need to compare if end == -1
        return new int[] {start, end};
    }

    private int findFirst(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){ //determind the condition that end the loop, it narrow down the range to 2 integer
            int mid = (end - start) / 2 + start;
            if(nums[mid] < target){ //only when nums[mid] < target we reset start = end, this is to narrow the range
                start = mid;
            } else {
                end = mid;
            }
        }

        //after the while loop ends, we have a range of 2 int, like [start, end], to find the first position, we of course check the start first.
        //for example, if we narrow down to a range like this [8, 8] and target is 8, the 8 at left is the starting position,
        //if ending with [7, 8], target is 8, end is the starting position we are looking for
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }

    private int findLast(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(nums[mid] > target){ //slightly different from above function, it keep narrow down the range to the right
                end = mid;
            } else {
                start = mid;
            }
        }
        //after the while loop ends, we have a range of 2 int, like [start, end], to find the last position, we of course check end first.
        //for example, if we narrow down to a range like this [8, 8] and target is 8, the 8 at right is the ending position,
        //if ending with [8, 9], target is 8, start is the ending position we are looking for
        if(nums[end] == target) return end;
        if(nums[start] == target) return start;
        return -1;
    }
}
