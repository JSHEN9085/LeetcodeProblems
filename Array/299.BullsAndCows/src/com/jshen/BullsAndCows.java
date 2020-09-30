package com.jshen;

import java.util.HashMap;

public class BullsAndCows {
    public String getHint(String secret, String guess){
        int bulls = 0;
        int cows = 0;

        int[] count = new int[10]; //10 means 0 ~ 9 total 10 digits
        int n = secret.length();

        for(int i = 0; i < n; i++){
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if(s == g){
                bulls++;
            } else {
                if(count[g] > 0) cows++;
                if(count[s] < 0) cows++;

                count[s]++;
                count[g]--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
