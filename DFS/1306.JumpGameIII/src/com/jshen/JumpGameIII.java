package com.jshen;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {

        if(start < 0 || start > arr.length - 1 || arr[start] == -1){
            return false;
        }

        if(arr[start] == 0){
            return true;
        }

        int x = arr[start];
        arr[start] = -1;

        return canReach(arr, start + x) || canReach(arr, start - x);

    }
}
