package com.jshen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    //2 pointers, O(n^2), space O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) return result;

        Arrays.sort(nums); //must sort the array first, otherwise below for loop won't work

        for(int i = 0; i < nums.length; i++){ //lock one num first, and then compare 1. 0 - locked num  vs  The sum of other 2 nums, if the results are same, we add those 3 nums into array
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            //2 pointers, one start from i + 1, the other starts from the end
            int low = i + 1, high = nums.length - 1, sum = 0 - nums[i]; //target is always 0 as question requires, so sum is 0 - nums[i]
            while(low < high){
                if(nums[low] + nums[high] == sum){
                    result.add(Arrays.asList(nums[i], nums[low], nums[high])); //key function: Arrays.asList
                    while(low < high && nums[low] == nums[low - 1]) low++; //skip the duplicated
                    while(low < high && nums[high] == nums[high - 1]) high--; //skip the duplicated
                    low++;
                    high--;
                } else if(nums[low] + nums[high] < sum){ //need to have a larger sum of nums[low] and nums[high], as nums has been sorted, low++
                    low++;
                } else { //need to have a larger sum of nums[low] and nums[high], as nums has been sorted
                    high--;
                }
            }
        }
        return result;
    }
}
