package com.whpu.array;

/**
 *@author xxh
 *@since 2021/3/31
 *@discription:
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 链接：https://leetcode-cn.com/problems/remove-element
 */
public class Solution27 {
  public int removeElement(int[] nums, int val) {
    if (nums.length == 0 || nums == null){
      return 0;
    }
    // 当data[k] != x的时候自增，i不管何值都自增，
    // 当前遍历的元素是x的时候i自增k不自增，当前遍历的元素是x的时候将data[i]赋值给data[k]后i，k一起自增
    int k = 0;
    for (int i = 0;i < nums.length; i++){
      if (nums[i] != val){
        nums[k] = nums[i];
        k++;
      }
    }
    // 只有data[i] != x的时候k才自增因此k最终就是删除所有x后数组的长度
    return k;
  }
  public int removeElement2(int[] nums, int val) {
    if (nums.length == 0 || nums == null){
      return 0;
    }
    // k记录了遍历到i时候，i号元素应该向前移动的个数
    int k = 0;
    for (int i = 0;i < nums.length; i++){
      if (nums[i] == val){
        k++; // 记录了i号元素之前有几个待删除的元素
      }else {
        nums[i - k] = nums[i];
      }
    }
    return nums.length - k;
  }
}
