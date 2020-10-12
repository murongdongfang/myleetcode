package com.whpu.sort;

import java.util.Random;

/**
 *@author xxh
 *@since 2020/10/11
 *@discription:
 * 归并排序
 */
public class MergeSort {
  private static int[] leftArr;
  private static int[] arr;

  public static void main(String[] args) {
    Random random = new Random();
    arr = new int[10];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(100);
    }
    leftArr = new int[arr.length >> 1];
    mergeSort(0, arr.length);
    printArr(arr);
  }

  public static void printArr(int[] arr){
    if (arr == null){
      return;
    }
    for (int i : arr) {
      System.out.print(i + ", ");
    }
  }
  public static void mergeSort(int begin, int end){
    // 数组元素数量小于2不继续划分
    if (end - begin < 2){
      return;
    }
    // 求中点，防止begin+end出现溢出
    int mid = (begin + end) >> 1;
//    int mid = begin + (end - begin)>>1;
    mergeSort(begin, mid);
    mergeSort(mid, end);
    merge(begin, mid, end);
  }

  /**
   * 将两个有序序列[begin,mid) [mid,end)和合并成一个有序序列[begin,end)
   * 先将[begin,mid)拷贝到leftArr中，然后将leftArr和[mid,end)，合并到[begin,end)中
   */
  public static void merge(int begin, int mid, int end){
    // 指向leftArr数组的开始和结束
    int li = 0, le = mid - begin;
    int ri = mid, re = end;
    // 指向[begin,end)表示大数组中已经排序号的元素个数
    int ai = begin;
    // 备份左边的数组
    for (int i = li; i < le; i++) {
      leftArr[i] = arr[begin + i];
    }
    // 两个数组进行归并排序不用考虑ri<re
    // 当li>le的时候数组本次归并完毕，ri>re的时候会依次把li的元素移动到ai++
    while (li < le){
      // while条件保证了li不会越界，if必须保证ri不会越界
      // >升序排列 <降序排列
      if (ri < re && leftArr[li] > arr[ri]){
        arr[ai++] = arr[ri++];
      }else{
        arr[ai++] = leftArr[li++];
      }
    }
  }
}
