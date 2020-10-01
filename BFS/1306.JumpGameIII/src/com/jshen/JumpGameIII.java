package com.jshen;

import java.util.ArrayDeque;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length]; //default as false

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()){
            int cur = q.poll();
            if(arr[cur] == 0) return true;

            visited[cur] = true;

            if( (cur - arr[cur]) >= 0 && visited[ cur - arr[cur] ] == false){
                q.offer(cur - arr[cur]);
            }
            if( (cur + arr[cur]) <= arr.length - 1 &&  visited[ cur + arr[cur] ] == false){
                q.offer(cur + arr[cur]);
            }
        }
        return false;
    }
}
