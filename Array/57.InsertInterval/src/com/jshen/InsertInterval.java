package com.jshen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//You may assume that the intervals were initially sorted according to their start times.

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval){
        if(newInterval == null || newInterval.length == 0) return intervals;

        List<int[]> list = new ArrayList<>();

        int[] toAdd = newInterval;

        for(int i = 0; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(cur[0] > toAdd[1]){
                list.add(toAdd);
                toAdd = cur;
            } else if(cur[1] >= toAdd[0]){
                toAdd[0] = Math.min(cur[0], toAdd[0]);
                toAdd[1] = Math.max(cur[1], toAdd[1]);
            } else {
                list.add(cur);
            }
        }
        list.add(toAdd);

        return list.toArray(new int[list.size()][2]);
    }

//cur[1] >= toAdd[0], cur[0] < toAdd[1]
    //used the method applied in leetcode 56, since input intervals is non-overlapping and already sorted,
    //we don't use below solution for this question, but it is still functional for overlapping and unsorted input
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        int[][] merge = new int[intervals.length + 1][2];
//        for(int i = 0; i < intervals.length; i++){
//            merge[i] = intervals[i];
//        }
//        merge[intervals.length] = newInterval;
//        Arrays.sort(merge, (i1, i2) -> i1[0] - i2[0]);
//
//        List<int[]> list = new ArrayList<>();
//        int[] pre = merge[0];
//        for(int i = 1; i < merge.length; i++){
//            int[] cur = merge[i];
//            //if overlap
//            if(pre[1] >= cur[0]){
//                cur[0] = pre[0];
//                cur[1] = Math.max(cur[1], pre[1]);
//            } else {
//                list.add(pre);
//            }
//            pre = cur;
//        }
//        list.add(pre);
//
//        int[][] res = new int[list.size()][2];
//        for(int i = 0; i < list.size(); i++){
//            res[i] = list.get(i);
//        }
//        return res;
//    }
}
