package com.jshen;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums.length == 0 || nums == null) return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++){

            while(q.size() > 0 && nums[i] >= nums[q.getLast()]){
                q.removeLast();
            }

            q.add(i);

            if(i - k + 1 >= 0){
                res[i - k + 1] = nums[q.getFirst()];
            }

            if(i - k + 1 >= q.getFirst()){
                q.removeFirst();
            }
        }
        return res;
    }



    //brute force, exceed time limit
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(nums.length == 0 || nums == null) return new int[0];
//
//        int[] res = new int[nums.length - k + 1];
//
//        for(int i = 0; i < nums.length - k + 1; i++){
//            int max = nums[i];
//            for(int j = i + 1; j < i + k; j++){
//                max = Math.max(nums[j], max);
//            }
//            res[i] = max;
//        }
//        return res;
//    }
}
