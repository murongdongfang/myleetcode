package com.whpu.array;

/**
 *@author xxh
 *@since 2020/6/17
 *@discription:
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class Solution209 {
  public int minSubArrayLen(int s, int[] nums) {
    //[l...r]表示滑动窗口，注意l，r的初始值
    int l = 0,r = -1;
    //size代表所求滑动窗口（连续子数组）的长度，初始化为nums.length+1是为了方便判断是否有解
    int size = nums.length + 1;
    int sum = 0;
    //注意边界的条件是由滑动窗口的左边界决定的，因为l=nums.length-1=的时候[l,r]有意义
    while(l < nums.length){
      if(sum < s && r+1 < nums.length){
        //防止++r造成数组越界，if条件里边必须要判断
        sum += nums[++r];
      }else {
        sum -= nums[l++];
      }

      if(sum >= s) {
        size = Integer.min(size, r - l + 1);
      }
    }
    if(size < nums.length + 1){
      return size;
    }
    return 0;
  }
  /**
   * 这是一段错误的逻辑，和上面方法中的逻辑是不相等的
   * 原因：if(a > 0){...}else{...}
   * 不能等价于
   * if(a >0){...}
   * if(a <= 0){...}
   */
  public int minSubArrayLen1(int s, int[] nums) {
    //[l...r]表示滑动窗口，注意l，r的初始值
    int l = 0,r = -1;
    //size代表所求滑动窗口（连续子数组）的长度，初始化为nums.length+1是为了方便判断是否有解
    int size = nums.length + 1;
    int sum = 0;
    //注意边界的条件是由滑动窗口的左边界决定的，因为l=nums.length-1=的时候[l,r]有意义
    while(l < nums.length){
      if(sum < s && r+1 < nums.length){
        //防止++r造成数组越界，if条件里边必须要判断
        sum += nums[++r];
      }


      if(sum >= s){
        size = Integer.min(size,r - l + 1);
        sum -= nums[l++];
      }

    }
    if(size < nums.length + 1){
      return size;
    }
    return 0;
  }

  public static void main(String[] args) {
    Solution209 sol = new Solution209();
    int[] arr = {2,3,1,2,4,3};
    sol.minSubArrayLen(7,arr);
  }


}
