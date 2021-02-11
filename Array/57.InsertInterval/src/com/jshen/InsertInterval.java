package com.jshen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] merge = new int[intervals.length + 1][2];
        for(int i = 0; i < intervals.length; i++){
            merge[i] = intervals[i];
        }
        merge[intervals.length] = newInterval;
        Arrays.sort(merge, (i1, i2) -> i1[0] - i2[0]);
        
        List<int[]> list = new ArrayList<>();
        int[] pre = merge[0];
        for(int i = 1; i < merge.length; i++){
            int[] cur = merge[i];
            //if overlap
            if(pre[1] >= cur[0]){
                cur[0] = pre[0];
                cur[1] = Math.max(cur[1], pre[1]);
            } else {
                list.add(pre);
            }
            pre = cur;
        }
        list.add(pre);

        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;

    }
}
