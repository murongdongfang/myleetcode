package com.whpu.dp;

import java.util.Arrays;

/**
 *@author xxh
 *@since 2020/7/7
 *@discription:
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Solution300 {
  public int lengthOfLIS(int[] nums) {
    /**
     * dp[i]表示以nums[i]为结尾的前[0...i]个数构成的子序列中最长上升子序列的长度
     * 状态转移方程
     * dp[i] = max(1+dp[j],dp[i] if nums[i]>nums[j])
     *         j<i
     * eg
     * 10   9   2   5   3   7   101   18
     * 1    1   1   2   2   3   4     4
     * 思考：其实我们不仅可以求出最长上升子序列，还可以根据这个dp数组反推出这个最长上升子序列
     * 例如：这个案例中最长上升子序列为4，dp数组中所有比4小的数字都是这个子序列的一部分(dp相等选一个）
     */
    int[] dp = new int[nums.length];
    //nums[0...i]最短上升子序列的长度为1
    Arrays.fill(dp,1);
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if(nums[i] > nums[j]){
          dp[i] = Integer.max(dp[i],dp[j] + 1);
        }
      }
    }
    int res = 0;
    for (int i = 0; i < dp.length; i++) {
      res = Integer.max(res,dp[i]);
    }

    return res;
  }

}
