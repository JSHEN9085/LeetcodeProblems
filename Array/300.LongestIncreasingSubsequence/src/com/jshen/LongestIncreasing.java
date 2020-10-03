package com.jshen;

import java.util.Arrays;

public class LongestIncreasing {
    //O(N logN)
    public int lengthOfLIS(int[] nums){
        if(nums.length == 0 || nums == null){
            return 0;
        }

        int[] dp = new int[nums.length];
        int len = 0;
        for(int num : nums){
            int index = Arrays.binarySearch(dp, 0, len, num);

            if(index < 0){
                index = -(index + 1); // return -insertion - 1
            }

            dp[index] = num;

            if(index == len){
                len++;
            }
        }
        return len;
    }

    //O(n^2)
//    public int lengthOfLIS(int[] nums){
//        if(nums.length == 0 || nums == null){
//            return 0;
//        }
//
//        int[] dp = new int[nums.length];
//        int maxLen = 0;
//
//        for(int i = 0; i < nums.length; i++){
//            int len = 1;
//            for(int j = 0; j < i; j++){
//                if(nums[j] < nums[i]){
//                    len = Math.max(len, dp[j] + 1);
//                }
//            }
//            dp[i] = len;
//            if(len > maxLen){
//                maxLen = len;
//            }
//        }
//        return maxLen;
//    }
}

//[3, 1, 2, 5, 4, 6]
//[1, 1, 2, 3, 1, 1]