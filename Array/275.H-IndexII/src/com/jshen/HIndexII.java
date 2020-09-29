package com.jshen;

public class HIndexII {
//requirement of h:
//N papers have at least h citations each, and the other N − h papers have no more than h citations each.
//Note: If there are several possible values for h, the maximum one is taken as the h-index.

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;

        int left = 0;
        int right = citations.length - 1;

        while(left < right){ //[0, 1] left = 0
            int mid = left + (right - left)/2;

            if( (citations.length - mid) <= citations[mid]){
                right = mid;
            } else {
                left = mid + 1; //to avoid infinite loop
            }
        }

        if(citations.length - left <= citations[left]){
            return citations.length - left;
        }
        return 0;
    }
}
