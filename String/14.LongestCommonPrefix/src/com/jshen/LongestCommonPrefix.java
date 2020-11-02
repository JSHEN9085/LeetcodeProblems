package com.jshen;


public class LongestCommonPrefix {

    //Horizontal scanning
//    public String longestCommonPrefix(String[] strs) {
//        if(strs == null || strs.length == 0) return "";
//
//        String prefix = strs[0];
//        for(int i = 1; i < strs.length; i++){
//            while(strs[i].indexOf(prefix) != 0){ //based on the testing, the question actually want common prefix starting from the beginning, that is why we set != 0 here instead of < 0
//                prefix = prefix.substring(0, prefix.length() - 1);
//            }
//        }
//        return prefix;
//    }

    //Vertical scanning
    public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }


}
