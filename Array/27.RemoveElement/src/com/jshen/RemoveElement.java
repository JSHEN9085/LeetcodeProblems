package com.jshen;

public class RemoveElement {
    //question requirement: The order of elements can be changed. It doesn't matter what you leave beyond the new length.
    //that means anything after the answer(targeted length) is not matter
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int len = 0; //this will be the answer

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){ // if nums[i] != val, nums[i] is the num we want to secure
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }
    

    //bad answer, this won't work, because for [0,1,2,2,3,0,4,2], val = 2, I will just remove the last 2(index 7) to the first 2(index 2)
//    public int removeElement(int[] nums, int val) {
//        if(nums == null || nums.length == 0) return 0;
//        int result = nums.length;
//
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] == val){
//                int tem = nums[result - 1];
//                nums[result - 1] = nums[i];
//                nums[i] = tem;
//                result--;
//            }
//        }
//        return result;
//    }
}
