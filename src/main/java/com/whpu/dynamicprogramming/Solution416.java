package com.whpu.dynamicprogramming;

/**
 *@author xxh
 *@since 2020/7/7
 *@discription:
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class Solution416 {
  /**
   * 转化为背包问题，不过注意的是此时背包必须要填满sum/2
   * 状态F(n,c)表示考虑使用nums[0...n)个物品填满容量为c(c=sum/2)的背包
   * 状态转移方程
   * F(n,c) = F(i-1,c) || F(i-1,c-w(i))
   */
  public int[][] memo;
  public boolean canPartition1(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    if(sum % 2 != 0){
      return false;
    }

    int n = nums.length;
    //-1表示未计算，0表示不可以填充，1表示可以填充
    //memo[i][j]表示在[0...index]范围的物品是否可以填满容积未j的背包
    memo = new int[n][sum/2+1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < sum/2+1; j++) {
        memo[i][j] = -1;
      }

    }
    return helper(nums,sum/2,n-1);
  }

  //尝试使用[0...index]范围的物品填满背包（填满背包：nums为0）
  public boolean helper(int[] nums,int sum,int index){
    //当sum=0表示背包已经填满，此时数组可以分割成为相等两部分
    if(sum == 0){
      return true;
    }
    //无法填满
    if(index < 0 || sum < 0){
      return false;
    }
    if(memo[index][sum] != -1){
      return memo[index][sum] == 1;
    }
    /**
     * 对于第index个物品（nums[index]）来说此时有两种选择
     * 不放入背包此时[0..index-1]范围中的物品可以填满背包
     * F(index,c) = F(index-1,c)
     * 放入背包
     * F(index,c) = F(index-1,c-w[index])
     * 对于上面两种任意一种成立都代表可以分割
     */
    boolean flag1 = helper(nums,sum,index-1);
    //nums[index]物品放入背包中
    boolean flag2 = helper(nums,sum - nums[index],index-1);

    memo[index][sum] = (flag1 || flag2) ? 1 : 0;

    return memo[index][sum] == 1;
  }

  /**
   *动态规划方法解决
   * 没有经过优化的dp数组是一个二维数组
   */
  public boolean canPartition2(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    if (sum % 2 != 0) {
      return false;
    }
    int n = nums.length;
    int c = sum / 2 ;
    //dp[i][j]表示在[0...i]范围内选择物品是否能够填满容积是j的背包
    //false表示无法填满填满，true表示可以填满
    boolean[][] dp = new boolean[n][c + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= c; j++) {
        dp[i][j] = false;
      }
    }
   //用0号物品去填充背包，这样做的好处可以在下边的代码中防止数组下标越界
    for (int i = 0; i <= c; i++) {
      dp[0][i] = (nums[0] == i);
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= c; j++) {
        dp[i][j] = dp[i-1][j];
        if(j >= nums[i]){
          dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i]]);
        }
      }

    }
    return dp[n-1][c];
  }

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    if (sum % 2 != 0) {
      return false;
    }
    int n = nums.length;
    int c = sum / 2 ;
    //dp[i]表示用
    boolean[] dp = new boolean[c+1];

    //用[0...n]号物品去填充容积为i的背包
    for (int i = 0; i <= c; i++) {
      dp[i] = (nums[0] == i);
    }

    //用[0...i]范围内的物品去填充容积为j的背包，由于0号物品已经填充过从1开始
    for (int i = 1; i < n; i++) {
      for (int j = c; j >= nums[i]; j--) {
        //dp[j]表示第i个物品不放入背包，dp[j-num[i]]表示第i个物品放入背包
        dp[j] = (dp[j] || dp[j - nums[i]]);
      }
    }

    return dp[c];
  }
}
