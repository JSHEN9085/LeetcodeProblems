package com.jshen;

import java.util.Arrays;

public class HIndex {
//requirement of h:
//N papers have at least h citations each, and the other N − h papers have no more than h citations each.
//Note: If there are several possible values for h, the maximum one is taken as the h-index.

    //O(n) 
    public int hIndex(int[] citations){
        int n = citations.length;

        //buckets size at n+1, because buckets[n] will be store the citation that is greater than n
        //based on the definition of h-index, citation that is > than n will be satisfied the requirement
        int[] buckets = new int[n+1];

        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        //for citations [3, 0, 6, 1, 5]
        //the buckets will be [1, 1, 0, 1, 0, 2], it means we have 2 papers with citations more than 5, 1 paper with citations of 3 and so on
        //the buckets is the count of paper with certain citations


        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i]; //add up the count, total number of papers with more than i citations
            if(count >= i) {
                return i; //if count >= i, return i， because i is the max h-index at this point
            }
        }
        return 0;
    }


//    //O(nlogn)
//    public int hIndex(int[] citations){
//        if(citations == null || citations.length == 0) return 0;
//
//        Arrays.sort(citations);
//        int h = 0;
//        int result = 0;
//
//        for(int i = citations.length - 1; i >= 0; i--){
//            h++;
//            if(citations[i] >= h){
//                result = Math.max(h, result);
//            }
//        }
//        return result;
//    }

}
