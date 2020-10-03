package com.jshen;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//	    int[] sample = {1, 3, 5, 7, 9};
//        System.out.println(Arrays.binarySearch(sample, 4));
        //Arrays.binarySearch return the index if number is found
        //and return -(insertion point) - 1;
        //for example, if we search 2 in the array, 2 should be sitting at index 1
        //but 2 is not inside the array, therefore, it will return -1 - 1 = -2
        //same rule searching 4 will return -2 - 1 = -3


        int[] sample2 = {1, 2, 5, 6, 7};
        System.out.println(Arrays.binarySearch(sample2,9));

    }
}
