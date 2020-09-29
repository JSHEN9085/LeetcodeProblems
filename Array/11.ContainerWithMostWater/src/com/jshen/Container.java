package com.jshen;

public class Container {
    //version 2: without helper
    public int maxArea(int[] height){
        if(height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int result = Math.min(height[left], height[right]) * (right - left);

        while(left < right){
            if(height[left] <= height[right]){
                left++;
            } else {
                right--;
            }
            result = Math.max( result, Math.min(height[left], height[right]) * (right - left) );
        }
        return result;
    }
    ywo

//    public int maxArea(int[] height){
//        if(height == null || height.length == 0) return 0;
//
//        int left = 0;
//        int right = height.length - 1;
//
//        int result = containerSize(left, right, height);
//
//        while(left < right){
//            if(height[left] <= height[right]){
//                left++;
//            } else {
//                right--;
//            }
//            result = Math.max(result, containerSize(left, right, height));
//        }
//        return result;
//    }
//
//    private int containerSize(int left, int right, int[] height){
//        if(height[left] <= height[right]){
//            return (right - left) * height[left];
//        } else {
//            return (right - left) * height[right];
//        }
//    }
}
