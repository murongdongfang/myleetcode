package com.whpu.sort;

import java.util.Random;

/**
 *@author xxh
 *@since 2020/10/12
 *@discription:
 * 插入排序，插入排序的时间复杂度和逆序对的数量成正比关系
 * 逆序对(2,3,8,6,1)的逆序对(2,1)(3,1)(8,1)(8,6)(6,1)
 */
public class InsertSort {
  public static void main(String[] args) {
    Random random = new Random();
    int arr[] = new int[9];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(100);
    }
    printArr(arr);
    insertSort3(arr);
    printArr(arr);
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

  // 优化二 当前元素前面都是有序的，所以可以使用二分搜索查询比当前小的元素，然后

  public static void insertSort3(int[] arr){
    if (arr == null || arr.length <= 0){
      return;
    }
    for (int begin = 1; begin < arr.length; begin++) {
      int temp = arr[begin];
      int cur = begin;
      while (cur > searchInsertIndex(arr,cur, temp)){
        arr[cur] = arr[cur - 1];
        cur --;
      }
      arr[cur] = temp;
    }
  }

  /**
   * 在[0,index)中使用二分查找查询待插入元素的下标
   * 也就是在有序数组[begin,end)中查找第一个大于target的元素索引
   * @return
   */
  public static int searchInsertIndex(int[] arr,int index, int target){
    int begin = 0, end = index;
    while (begin < end){
      int mid = (begin + end) >> 1;
      if (target < arr[mid]){
        end = mid;
      }else {
        // 对比和二分查找的差异
        begin = mid + 1;
      }
    }
    // 最终结果begin一定等于end
    return begin;
  }

  // 优化1将交换转为覆盖
  public static void insertSort2(int[] arr){
    if (arr == null || arr.length <= 0){
      return;
    }
    for (int begin = 1; begin < arr.length; begin++) {
      int temp = arr[begin];
      int cur = begin;
//      是temp<arr[cur-1]不是arr[cur-1]<arr[cur]
      for (; cur > 0 && arr[cur] > temp ; cur--) {
        arr[cur] = arr[cur - 1];
      }
      arr[cur] = temp;
       /*
          while (cur > 0 && temp < arr[cur - 1]){
            arr[cur] = arr[cur - 1];
            cur --;
          }
      */
    }
  }

  // 对比数组的插入排序和链表的插入排序，数组使用的是交换，链表直接在目标节点的后边插入
  public static void insertSort(int[] arr){
    for (int begin = 1; begin < arr.length; begin++) {
      // 记录下begin（当前排到哪个元素），否则后面的冒泡会把这个begin覆盖
      int cur = begin;
      // 里边就是一轮冒泡排序
      while (cur > 0 && arr[cur] < arr[cur - 1]){
        int temp = arr[cur - 1];
        arr[cur - 1] = arr[cur];
        arr[cur] = temp;
        cur --;
      }
    }
  }

  private static void testInsertSort() {
    Random random = new Random();
    int arr[] = new int[9];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(100);
    }
    printArr(arr);
    insertSort2(arr);
    printArr(arr);
  }
}
