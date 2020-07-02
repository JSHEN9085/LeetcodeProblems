package com.jshen;

public class Search {
    //own solution at second trial
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = (end - start) / 2 + start;

            if(nums[mid] == target) return mid;

            if(nums[start] < nums[mid]){ //this means start and mid is still at ascending order
                if(nums[start] <= target && target <= nums[mid]){ //if target is also between start and mid, this will be traditional binary search
                    end = mid;
                } else {
                    start = mid;
                }
            } else { //representing nums[start] > nums[mid], rotation point is sitting between start and mid, but it still means between mid and end is still ascending order
                if(nums[mid] <= target && target <= nums[end]){ //if target is within mid and end, it is also the traditional binary search
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if(nums[start] == target) return start; //if target is at the rotation border we would need this
        if(nums[end] == target) return end; //if target is at the rotation border we would need this
        return -1;
    }

//** same as other binary search questions, this question also try to narrow down the interval.
//in the interval where the rotation point is located at, we try to find where the target is, between start and mid, or mid and end
//and then keep narrowing down the interval



//    solution example
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
