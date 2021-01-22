package com.jshen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Majority {

    //Boyer-Moore, Time: O(n), Space: O(1)
    public int majorityElement(int[] nums){
        int majority = nums[0];
        int count = 1;

        for(int num : nums){
            if(majority == num){
                count++;
            } else {
                count--;
            }

            if(count == 0){
                majority = num;
                count = 1;
            }
        }
        return majority;
    }

    //Time: O(n), Space: O(n)
//    public int majorityElement(int[] nums){
//        Map<Integer, Integer> count = new HashMap<>();
//        int len = nums.length;
//
//        for(int num : nums){
//            if(count.containsKey(num)){
//                count.replace(num, count.get(num) + 1);
//            } else {
//                count.put(num, 1);
//            }
//        }
//
//        for(int num : count.keySet()){
//            if(count.get(num) > len / 2){
//                return num;
//            }
//        }
//        return -1;
//    }

    //Time (NlogN), Space(logN)
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums); //sort method use stack space, so space complexity is logN
//        return nums[nums.length / 2];
//    }
}
