package com.whpu.array;

import java.util.Arrays;

/**
 *@author xxh
 *@since 2020/6/14
 *@discription: leetcode
 */
public class BinarySearch {
  public int binarySearch(int[] arr,int target){
    int left = 0;
    int right = arr.length - 1;
    //在[left...right]为边界的数组中寻找target
    //left可以等于right 当left=right的时候[left,left]有元素
    while(left <= right){
      //left+right可能两个整型相加可能会造成整型溢出的问题
//      int mid = (left + right) / 2;
      int mid = left + (right - left)/2;
      if(arr[mid] == target){
        return mid;
      }
      if(arr[mid] < target){
        //在[left...mid-1]中寻找
        left = mid - 1;
      }else{
        //在[mid+1...right]中寻找
        right = mid + 1;
      }
    }

    return 0;
  }

  public int binarySearch1(int[] arr,int target){
    int left = 0;
    int right = arr.length ;
    //在[left...right)为边界的数组中寻找target
    //此时left不能等于right 当left = right的时候 [left,left)区间没有元素
    while(left < right){
      //int mid = (left + right) / 2;
      int mid = left + (right - left)/2;
      if(arr[mid] == target){
        return mid;
      }
      if(arr[mid] < target){
        //在[left...mid)中寻找，此时left不能写mid - 1，
        left = mid;
      }else{
        //在[mid+1...right]总找寻target
        right = mid + 1;
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    BinarySearch obj = new BinarySearch();
    int arr[] = {1,34,123,234,55,2343,9,23,34,3};
    Arrays.sort(arr);
    Arrays.stream(arr).forEach(System.out::println);
    System.out.println(obj.binarySearch1(arr, 123));
    System.out.println(obj.binarySearch(arr,123));

  }

}
