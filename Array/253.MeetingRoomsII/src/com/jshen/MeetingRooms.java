package com.jshen;

//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
//
//Example 1:
//Input: [[0, 30],[5, 10],[15, 20]]
//Output: 2

//Example 2:
//Input: [[7,10],[2,4]]
//Output: 1

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    public int minMeetingRooms(int[][] intervals){
        if(intervals == null || intervals.length == 0) return 0;

        //sorting based on starting time
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        //create priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>( (int[] a, int[] b) -> a[1] - b[1] );
        pq.offer(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= pq.peek()[1]){
                pq.poll();
            }
            pq.offer(intervals[i]);
        }
        return pq.size();
    }

}
