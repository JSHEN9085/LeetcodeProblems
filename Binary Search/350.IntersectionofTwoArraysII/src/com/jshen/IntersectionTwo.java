package com.jshen;

import java.util.*;

public class IntersectionTwo {

    //O(nlogn + n or m) depend on which one is larger
//    public int[] intersect(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//
//        List<Integer> list = new ArrayList<>();
//
//        int i = 0;
//        int j = 0;
//        while(i < nums1.length && j < nums2.length){
//            if(nums1[i] == nums2[j]){
//                list.add(nums1[i]);
//                i++;
//                j++;
//            } else if(nums1[i] < nums2[j]){
//                i++;
//            } else {
//                j++;
//            }
//        }
//
//        int[] result = new int[list.size()];
//        int pointer = 0;
//        for(Integer num : list){
//            result[pointer++] = num;
//        }
//        return result;
//    }



    //O(n + m)
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();
        //count the frequency of each number in nums1
        for(Integer i : nums1){
            int freq = count.getOrDefault(i, 0);
            count.put(i, freq + 1);
        }

        List<Integer> list = new ArrayList<>();
        //run through nums2 here, if number is common, add it into the ArrayList
        for(Integer j : nums2){
            if(count.containsKey(j) && count.get(j) > 0){
                list.add(j);
                count.put(j, count.get(j) - 1); //key step, update the frequency in HashMap count, so it ensure the lesser frequency is added into the ArrayList
            }
        }

        int[] result = new int[list.size()];
        int pointer = 0;
        for(Integer num : list){
            result[pointer++] = num;
        }
        return result;
    }
}
