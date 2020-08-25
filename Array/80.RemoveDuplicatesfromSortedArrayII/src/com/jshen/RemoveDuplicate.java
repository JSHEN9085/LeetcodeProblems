package com.jshen;

public class RemoveDuplicate {
    //question requirement: only remove duplicated appear >= 3 times
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int len = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[len - 2]){
                nums[len++] = nums[i]; // this same as first nums[len] = nums[i]; and then len++;
            }
        }
        return len;
    }
}


/*
explanation: for array [0, 0, 1, 1, 1, 2, 2, 3], since max allowed duplicated is two, so the first 2 position is 100% valid
so I set len and i starting from index 2 (the 3rd position). Since array is sorted, if nums[2] == nums[2 - 2], it means 0, 1, 2 all 3 position are same
so we only need to capture where nums[i] != nums[len - 2], and then set nums[len] to nums[i]
*/