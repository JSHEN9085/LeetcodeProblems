package com.jshen;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums){
        List<Integer> res = new LinkedList<>();
        if(nums.length == 0 || nums == null) return res;

        int len = nums.length;
        int can1 = nums[0];
        int count1 = 0;
        int can2 = nums[0];
        int count2 = 0;

        for(int num : nums){
            if(can1 == num){
                count1++;
            } else if(can2 == num){
                count2++;
            } else if(count1 == 0){
                can1 = num;
                count1 = 1;
            } else if(count2 == 0){
                can2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int num : nums){
            if(can1 == num){
                count1++;
            } else if(can2 == num){
                count2++;
            }
        }
        if(count1 > len/3){
            res.add(can1);
        }
        if(count2 > len/3){
            res.add(can2);
        }
        return res;
    }
}
