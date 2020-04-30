package com.jshen;

public class FirstBadVersion {

    //question idea is inputting version # into a check function, but try to minimize the # of function call
    public int firstBadVersion(int n) {
        int start = 0;
        int end = n;

        while(start < end){
            int mid = start + (end - start) / 2; //overflow bug: the value of L+R may exceed the range of integers of the data type used to store the midpoint, even if L and R are within the range
            if(isBadVersion(mid)){ //isBadVersion(int n) is a function provided by the question
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
