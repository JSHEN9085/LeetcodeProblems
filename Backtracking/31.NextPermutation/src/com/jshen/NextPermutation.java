package com.jshen;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2; //this is the second last num in nums
        while(i >= 0 &&  nums[i] >= nums[i + 1]){
            i--;
        } //find the first pair that nums[i] >= nums[i + 1]

        if(i >= 0){
            int j = nums.length - 1; //j is the last
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            } // find the first num that is less than nums[i]
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start){
        int i = start;
        int j = nums.length - 1;

        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
