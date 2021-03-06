package com.jshen;

import java.util.Arrays;

public class Longest {

    //version 1, O(n^2) solution
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n]; //using an array to store each length up to each index
//
//        int maxLen = 0;
//
//        for(int i = 0; i < n; i++){
//            int len = 1;
//            for(int j = 0; j < i; j++){// the main idea is calculate max length that up to each index
//                if(nums[j] < nums[i]){
//                    len = Math.max(len, dp[j] + 1); //update the length if the current num is less than nums[i]
//                }
//            }
//            dp[i] = len; //after the 2nd for loop, len is the maximum length that up to index i, so update dp[i] as the longest length
//            if(dp[i] > maxLen) maxLen = dp[i]; //compare len and maxLen now, so we don't need to iterate dp[] to find out the max at the end
//        }
//        return maxLen;
//    }

    //version 2 O(nlogn)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        int len = 0;
        for(int num : nums){
            int index = Arrays.binarySearch(dp, 0, len, num);
            //searching num from dp, range is from 0 to len

            if(index < 0){
                index = -(index + 1);
            }

            dp[index] = num;

            if(index == len){
                len++;
            }
        }
        return len;
    }

}
