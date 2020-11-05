package com.jshen;

import java.util.HashMap;

public class Solution {

    //time: O(2n), space: O(2n)
    public boolean isIsomorphic(String s, String t){
        if(s.length() != t.length()) return false;

        return helper(s, t) && helper(t, s);
    }

    private boolean helper(String s, String t){
        HashMap<Character, Character> match = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(match.containsKey(charS)){
                if(match.get(charS) != charT){
                    return false;
                }
            } else {
                match.put(charS, charT);
            }
        }
        return true;
    }
}
