package com.jshen;

import java.util.Arrays;

public class HIndex {
//requirement of h:
//N papers have at least h citations each, and the other N − h papers have no more than h citations each.
//Note: If there are several possible values for h, the maximum one is taken as the h-index.

    //O(nlogn)
    public int hIndex(int[] citations){
        if(citations == null || citations.length == 0) return 0;

        Arrays.sort(citations);
        int h = 0;
        int result = 0;

        for(int i = citations.length - 1; i >= 0; i--){
            h++;
            if(citations[i] >= h){
                result = Math.max(h, result);
            }
        }
        return result;
    }

}
