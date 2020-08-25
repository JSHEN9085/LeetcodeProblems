package com.jshen;

public class RemoveDeplicate {
    //question requirement: It doesn't matter what you leave beyond the returned length.
    //just make sure no duplicated within the targeted range, everything beyond that is not matter
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        //using 2 pointer here, one is len, the number of non-duplicated # we totally have
        //the other pointer is i, the one iterating the array
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[len]){
                len++;
                nums[len] = nums[i];
            }
        /*explanation on this for loop: len and i are starting from 0, also the first element is impossible to duplicated as it is the only one
        therefore, as i increasing, once we found nums[i] != nums[len], that means we found the second non-duplicated number
        we increase len first, moving len to next position, and then assign nums[len] = nums[i], and then index of 2 will have the
        second non-duplicated number
        */
        }

        return len + 1; //len is used to represent the index, as question want the size, so we need to return index + 1;
    }
}
