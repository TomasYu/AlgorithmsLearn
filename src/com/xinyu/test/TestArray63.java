package com.xinyu.test;

public class TestArray63 {

    public static void main(String[] args) {
        System.out.println(findPos(new int[]{1,2,3,3,3,3,9, 9,8,6}));
    }

    public static int findPos(int arr[]){
        int mid;
        int left = 0,right = arr.length-1;

        if(right < 0 ){
            return -1;
        }

        while(left < right){
            mid = (left + right) / 2;
            if(mid -1 >= 0 && mid+1 <= right){
                if(arr[mid] > arr[mid-1] && arr[mid] >arr[mid+1]){
                    return mid;
                }else if(arr[mid-1]>= arr[mid]){
                    right = mid;
                }else if(arr[mid] <= arr[mid + 1 ]){
                    left = mid;
                }
            }
            return mid;
        }
        return -1;

    }
}
