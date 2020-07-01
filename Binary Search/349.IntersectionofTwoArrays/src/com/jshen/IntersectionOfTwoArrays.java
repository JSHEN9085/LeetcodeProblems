package com.jshen;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    //Binary search O(NlogN), actually is 2NlogN, because Arrays.sort(nums2) does take NlogN time
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> intersect = new HashSet<>();
//        Arrays.sort(nums2);
//
//        for(Integer num : nums1){
//            if(binarySearch(nums2, num)){
//                intersect.add(num);
//            }
//        }
//
//        int i = 0;
//        int[] result = new int[intersect.size()];
//        for(Integer num : intersect){
//            result[i++] = num;
//        }
//        return result;
//
//    }
//
//    private boolean binarySearch(int[] nums, int num){
//        int start = 0;
//        int end = nums.length - 1;
//
//        while(start <= end){
//            int mid = (end - start) / 2 + start;
//
//            if(nums[mid] == num) return true;
//
//            if(nums[mid] < num){
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        return false;
//    }


//    O(n) solution, actually it is 2n, disadvantage in memory because used 2 HashSet
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intersect = new HashSet<>();

        Set<Integer> nums1Set = new HashSet();
        for(int i = 0; i < nums1.length; i++){
            nums1Set.add(nums1[i]);
        }

        for(int j = 0; j < nums2.length; j++){
            if(nums1Set.contains(nums2[j])){
                intersect.add(nums2[j]);
            }
        }

        int[] result = new int[intersect.size()];
        int pointer = 0;
        for(Integer num : intersect){
            result[pointer++] = num;
        }
        return result;
    }
}
