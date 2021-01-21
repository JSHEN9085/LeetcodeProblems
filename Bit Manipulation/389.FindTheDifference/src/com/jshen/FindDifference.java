package com.jshen;

public class FindDifference {
    public char findTheDifference(String s, String t) {
        char c = 0; //if both char is same the result of ^ is 0, so assign 0 here mean assume no difference at the beginning
        for(int i = 0; i < s.length(); i++){
            c ^= s.charAt(i) ^ t.charAt(i);
        }
        c ^= t.charAt(t.length() - 1);
        return c;
    }
}
