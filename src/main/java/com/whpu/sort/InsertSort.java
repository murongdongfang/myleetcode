package com.whpu.sort;

/**
 *@author xxh
 *@since 2020/10/12
 *@discription:
 * 插入排序
 */
public class InsertSort {

  public void insertSort(int[] arr){
    for (int begin = 1; begin < arr.length; begin++) {
      int cur = begin;
      while (cur > 0 && arr[cur] < arr[cur - 1]){
        int temp = arr[cur - 1];
        arr[cur - 1] = arr[cur];
        arr[cur] = temp;
        cur --;
      }
    }
  }
}
