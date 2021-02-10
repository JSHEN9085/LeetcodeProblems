package com.jshen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals){
        //check edge case
        if(intervals == null || intervals.length == 0) return new int[0][0];

        List<int[]> list = new ArrayList<>();
        //sort based on the starting point
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        //for loop
        int[] pre = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            //if overlap
            if(pre[1] >= cur[0]){
                cur[0] = pre[0];
                cur[1] = Math.max(pre[1], cur[1]);
            } else {
                //if no overlap
                list.add(pre);
            }
            pre = cur;
        }
        list.add(pre);

        //convert list to int[]
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
