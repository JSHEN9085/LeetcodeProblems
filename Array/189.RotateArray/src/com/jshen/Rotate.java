package com.jshen;

public class Rotate {

    //using extra array, time O(n) actually is O(2n), space O(n) because created another array
    //use an extra array in which we place every element of the array at its correct position i.e.
    //the number at index ii in the original array is placed at the index (i + k) \% \text{ length of array}(i+k)% length of array.
    //Then, we copy the new array to the original one.
//    public void rotate(int[] nums, int k) { //k means index k will be the last num, and k + 1 will be the first num
//        if(nums.length < 2) return;
//
//        int[] result = new int[nums.length];
//
//        for(int i = 0; i < result.length; i++){
//            result[(i + k) % nums.length] = nums[i]; // 3 % 7 = 3, remember it is different from 7 % 3 = 1
//        }
//
//        for(int j = 0; j < nums.length; j++){
//            nums[j] = result[j];
//        }
//    }


    //time O(n), space O(1)
    //We can directly place every number of the array at its required correct position. But if we do that,
    //we will destroy the original element. Thus, we need to store the number being replaced in a temptemp variable.
    //Then, we can place the replaced number(temp) at its correct position and so on
//    public void rotate(int[] nums, int k) {
//        if(nums.length < 2) return;
//
//        int n = nums.length;
//        int start = 0;
//        int count = 0;
//
//        while(count < n){
//            int i = start;
//            int temp = nums[start];
//            while ( (i + n - k) % n != start ) {
//                nums[i] = nums[ (i + n - k) % n ];
//                i = (i + n - k) % n;
//                count++;
//            }
//            nums[i] = temp;
//            count++; // Do not forget this count++ for the last swap in the cycle.
//            start++;
//        }
//    }

    //time O(n), space O(1)
    //We can directly place every number of the array at its required correct position. But if we do that,
    //we will destroy the original element. Thus, we need to store the number being replaced in a temptemp variable.
    //Then, we can place the replaced number(temp) at its correct position and so on
    public void rotate(int[] nums, int k) {
        if(nums.length < 2) return;

        int count = 0;
        for (int start = 0; count < nums.length; start++){
            int curIndex = start;
            int prevNum = nums[start];

            do{ //do while loop will at least execute once, since start is equal to current, so do-while loop is more convenient here
                int nextIndex = (curIndex + k) % nums.length;
                int tempNum = nums[nextIndex];
                nums[nextIndex] = prevNum;
                prevNum = tempNum;
                curIndex = nextIndex;
                count++;
            } while(curIndex != start);
        }
    }
/*
the main idea is swap all element in one loop
[prev, ...., current, ..... next], the flow will be prev -> current, current -> next, next -> prev
prev -> current, and save current as temp, and then prev = temp
next = prev, because prev is the previous current.
as curIndex = nextIndex = (curIndex + k) % nums.length, curIndex will eventually turn back to 0
at the time curIndex = start, do-while loop stop
count is actually the # of times we swap numbers, if it equals to nums.length, that means we have swapped every number and good to stop
*/
}
