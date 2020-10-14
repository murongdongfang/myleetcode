package com.whpu.sort;

import java.util.Arrays;

/**
 *@author xxh
 *@since 2020/6/14
 *@discription:
 * 如果数组中存在多个要搜索的数target，不同的写法返回的索引值是不相同的
 * 注意两点：
 * 第一：left是否可以等于right
 * 第二：mid的赋值
 */
public class BinarySearch {
  //在[left...right]为边界的数组中寻找target
  public int binarySearch2(int[] arr,int target){
    int left = 0;
    int right = arr.length - 1;

    //判断条件必须为<=不能是<，因为left可以等于right 当left=right的时候[left,left]有元素
    while(left <= right){
      //left+right可能两个整型相加可能会造成整型溢出的问题
      int mid = (left + right) / 2;
//      int mid = left + (right - left)/2;
      if(arr[mid] == target){
        return mid;
      }
      if(arr[mid] < target){
        //在[mid+1...right]中寻找
        left = mid + 1;

      }else{
        //在[left...mid-1]中寻找
        right = mid - 1;
      }
    }

    return -1;
  }

  //在[left...right)为边界的数组中寻找target
  public int binarySearch1(int[] arr,int target){
    int left = 0;
    int right = arr.length ;
    //此时left不能等于right 当left = right的时候 [left,left)区间没有元素
    while(left < right){
      int mid = (left + right) / 2;
//      int mid = left + (right - left)/2;
      if(arr[mid] == target){
        return mid;
      }
      if(arr[mid] < target){
        //在[mid+1...right）总找寻target
        left = mid + 1;
      }else{
        //在[left...mid)中寻找，此时left不能写mid - 1，
        right = mid;
      }
    }

    return -1;
  }

  /**
   * 采用递归的方式在[begin,end)范围内二分查找
   */
  public static int binarySearch3(int[] arr,int target, int low, int high){
    // 这种情况下必须是low>=high，只有在low<high时候才能继续递归，因为[low,low)此时没有元素
    if (arr == null || arr.length <= 0 || low >= high){
      return -1;
    }
    int mid = (low + high) >> 1;
    if (arr[mid] == target){
      return mid;
    }else if (arr[mid] > target){
      return binarySearch3(arr, target, low, mid);
    }else {
      return binarySearch3(arr, target, mid + 1, high);
    }
  }
  public static void main(String[] args) {
    BinarySearch obj = new BinarySearch();
    int arr[] = {1,2,3,4,4,5,6,7,7};
    Arrays.sort(arr);
//    Arrays.stream(arr).forEach(System.out::println);
    System.out.println(binarySearch3(arr, 1, 0, arr.length));
    System.out.println(obj.binarySearch2(arr,1));
    System.out.println(obj.binarySearch1(arr, 1));

  }

}
