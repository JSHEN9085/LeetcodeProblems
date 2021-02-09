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
    //priority queue
//    public int minMeetingRooms(int[][] intervals){
//        if(intervals == null || intervals.length == 0) return 0;
//
//        //sorting based on starting time
//        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
//
//        //create priority queue
//        PriorityQueue<int[]> pq = new PriorityQueue<>( (int[] a, int[] b) -> a[1] - b[1] );
//        pq.offer(intervals[0]);
//
//        for(int i = 1; i < intervals.length; i++){
//            if(intervals[i][0] >= pq.peek()[1]){
//                pq.poll();
//            }
//            pq.offer(intervals[i]);
//        }
//        return pq.size();
//    }

    //2 arrays solution
    public int minMeetingRooms(int[][] intervals){
        if(intervals == null || intervals.length == 0) return 0;

        int res = 0; //final result: the number of rooms

        //assign 2 arrays to sort starting time and ending time
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        //check overlap
        for(int i = 0, j = 0; i < intervals.length; i++){
            if(start[i] >= end[j]){
                j++;
            } else {
                res++;
            }
        }
        return res;
    }


}
