package com.jshen;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Majority {

    public List<Integer> majorityElement(int[] nums){
        List<Integer> res = new LinkedList<>();
        int candidate1 = nums[0];
        int count1 = 0;
        int candidate2 = nums[0];
        int count2 = 0;

        for(int num : nums){
            if(candidate1 == num){
                count1++;
                continue;
            }
            if(candidate2 == num){
                count2++;
                continue;
            }

            if(count1 == 0){
                candidate1 = num;
                count1++;
                continue;
            }
            if(count2 == 0){
                candidate2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }

        count1 = 0;
        count2 = 0;

        for(int num : nums){
            if(candidate1 == num){
                count1++;
            } else if(candidate2 == num){
                count2++;
            }
        }
        if(count1 > nums.length / 3){
            res.add(candidate1);
        }
        if(count2 > nums.length / 3){
            res.add(candidate2);
        }
        return res;
    }

    //Time: O(n), Space: O(n)
//    public List<Integer> majorityElement(int[] nums){
//        List<Integer> res = new LinkedList<>();
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
//            if(count.get(num) > len / 3){
//                res.add(num);
//            }
//        }
//        return res;
//    }
}
