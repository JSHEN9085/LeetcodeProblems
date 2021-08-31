package com.jshen;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int num : nums){
            s.add(num);
        }

        int longest = 1;
        for(int num : nums){
            if(s.remove(num)){
                int cur = num;
                int curLongest = 1;
                while(s.remove(cur - 1)){
                    cur--;
                    curLongest++;
                }

                cur = num;
                while(s.remove(cur + 1)){
                    cur++;
                    curLongest++;
                }
                longest = Math.max(longest, curLongest);
            }
        }
        return longest;
    }
}
