package com.jshen;

public class MergeSortedArray {
//    The number of elements initialized in nums1 and nums2 are m and n respectively.
//    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//    Input: size of array is fixed in Java, that is why we need to know how many position is initialized in array1
//    nums1 = [1,2,3,0,0,0], m = 3
//    nums2 = [2,5,6],       n = 3
//    both nums 1 and nums 2 are already sorted

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m + n -1; //this is the index of our final array;
        m--; //getting the index of nums1
        n--; //getting the index of nums2

        while(m >= 0 && n >= 0){
            if(nums1[m] > nums2[n]){ //starting from the end, so we don't need extra space to store num1 data
                nums1[l] = nums1[m];
                l--;
                m--;
            } else {
                nums1[l] = nums2[n];
                l--;
                n--;
            }
        }

        for(int i = 0; i <= n; i++){
            nums1[i] = nums2[i];
        }
    }
}
