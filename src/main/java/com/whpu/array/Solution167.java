package com.whpu.array;

/**
 *@author xxh
 *@since 2020/6/15
 *@discription:
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Solution167 {
  /**
   * 解法一：使用二分搜索，遍历数组假设当前位置为i
   * 在[i...arr.length-1]中使用二分搜索寻找target - arr[i]
   * 解法二：对撞指针，利用数组有序的特性
   */
  public int[] twoSum(int[] numbers, int target) {
    int[] res=new int[2];
    int i=0,j=numbers.length-1;
    while(i<j){
      if(numbers[i]+numbers[j]==target) {
        break;
      }
      if(numbers[i]+numbers[j]>target) {
        j--;
      }
      if(numbers[i]+numbers[j]<target) {
        i++;
      }
    }
    res[0]=i+1;
    res[1]=j+1;
    return res;
  }
}
