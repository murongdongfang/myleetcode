package com.whpu.sort;

import java.util.Random;

/**
 *@author xxh
 *@since 2020/10/12
 *@discription:
 * 快速排序，不稳定
 */
public class QuickSort {
  public static void main(String[] args) {
    Random random = new Random();
  /*  int arr[] = new int[9];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(100);
    }*/
    int[] arr = {24, 50, 61, 78, 4, 78, 30, 58, 77};
    printArr(arr);
    quickSort(arr, 0, arr.length - 1);
    printArr(arr);
  }


  public static void quickSort(int[] arr,int low,int high){
    if(low < high){
      int pivotIndex = partition(arr, low, high);
      quickSort(arr, low, pivotIndex - 1);
      quickSort(arr, pivotIndex + 1, high);
    }
  }
  public static int partition(int[] arr,int low,int high){
    int pivot = arr[low];
    while(low < high){
      // 必须要有low<high否则可能出现数组越界，必须使用>=否则死循环
      // eg：int[] arr = {24, 50, 61, 78, 4, 78, 30, 58, 77};
      while(low < high && arr[high] >= pivot){
        high--;
      }
      arr[low] = arr[high];
      while(low < high && arr[low] <= pivot){
        low++;
      }
      arr[high] = arr[low];
    }
    arr[low] = pivot;
    return low;
  }

  public static void printArr(int[] arr){
    if (arr == null){
      return;
    }
    for (int i : arr) {
      System.out.print(i + ", ");
    }
    System.out.println();
  }
}
