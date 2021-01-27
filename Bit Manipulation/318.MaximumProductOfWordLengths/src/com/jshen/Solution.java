package com.jshen;

public class Solution {
    public int maxProduct(String[] words) {
        //edge case check
        if (words == null || words.length == 0) return 0;

        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        return maxProduct;
    }
}

//for anyone who doesn't understand why value[i] |= 1 << (tmp.charAt(j) - 'a');
//I can give some example results
// a 1->1
// b 2->10
// c 4->100
// ab 3->11
// ac 5->101
// abc 7->111
// az 33554433->10000000000000000000000001