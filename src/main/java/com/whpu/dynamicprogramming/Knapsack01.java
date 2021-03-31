package com.whpu.dynamicprogramming;

/**
 *@author xxh
 *@since 2020/7/7
 *@discription: 01背包问题
 *背包所能容纳的最大重量为c，现在有一列物品(每样一件)，第i件物品的重量为w[i]，价值为v[i]
 * 在背包所能容纳的重量范围内求所能装下物品的最大值
 * F(n,C)所表示的意义：考虑将前n个物品放进容量为C的背包
 * 背包问题的状态状态转移方程：F(i,c) = max(F(i-1,c),F(i-1,c-w[i])+v[i])
 * eg：
 * 容量C：5  最大值为22
 * id         0       1       2
 * weight     1       2       3
 * value      6       10      12
 *
 * 动态规划填充dp数组过程
 *      0   1   2    3    4   5
 *
 * 0    0   6   6    6    6   6
 * 1    0   6   10   16   16  16
 * 2    0   6   10   16   18  22
 *
 */
public class Knapsack01 {

  int[][] memo;
  public int knapsack01(int[] w,int[] v,int c){
    int size = w.length;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < c; j++) {
        memo[i][j] = -1;
        
      }
    }
    bestValue(w,v,c,size - 1);

    return 0;
  }
  //递归+记忆化搜索
  //用[0...index]物品去填充背包所获得的最大价值
  public int bestValue(int[] w,int[] v,int c,int index){
    //index < 0而c <= 0
    if(index < 0 || c <= 0){
      return 0;
    }
    if(memo[index][c] != -1){
      return memo[index][c];
    }
    /**
     * 对于index物品可以选择放入背包中，也可以不放入背包中
     * 1.如果不放入背包则最大价值就在[0..index-1]
     * 1.如果放入背包中最大价值max([0...index-1]中的最大价值+v[index]，index不放入背包中的最大价值)
     */
    int val = bestValue(w, v, c, index - 1);
    if(c > w[index]){
      //index不放入背包中的最大价值
      val = Integer.max(
        val,
        bestValue(w,v,c - w[index],index - 1) + v[index]
      );
    }
    memo[index][c] = val;
    return val;
  }



  /*动态规划的方式解决，下面的代码就是这个数组填充的过程
   * 动态规划填充dp数组过程
   *      0   1   2    3    4   5
   *
   * 0    0   6   6    6    6   6
   * 1    0   6   10   16   16  16
   * 2    0   6   10   16   18  22
   *
   * 可以根据这个dp数组反推出最大价值的背包中包含了哪些问题
   * 但是我们使用下面两种优化的时候是无法反推出这些解的
   *
   */
  public int knapsack(int[] w,int[] v,int c){
    int n = w.length;
    //dp[i][j]表示前[0..i]个物品在背包容量为j的时候所获的最大价值
    int[][] dp = new int[n][c+1];
    for (int i = 0; i <= c; i++) {
      dp[0][i] = (i < w[i] ? 0 : v[0]);
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= c; j++) {
        dp[i][j] = dp[i - 1][j];
        if(w[i] >= j){
          dp[i][j] = Integer.max(
            dp[i][j],
            v[i] + dp[i - 1][j - w[i]]
          );
        }
      }
    }
    return dp[n - 1][c];
  }
  /**
   * 01背包问题动态规划方法优化思路：
   * 空间优化：
   * F(i,c) = max(F(i-1,c),F(i-1,c-w[i])+v[i])
   * 根据状态转移方程可知F(i,c)依赖F(i-1,) ，也就是说dp数组下一行求出的值依赖于上一行
   * 因此只需要开辟一个两行的二维数组即可
   */

  public int knapsack1(int[] w,int[] v,int c){

    int n = w.length;
    //int[i][j]表示前[0...i]个物品填充重量为j的背包所获的最大值
    int[][] dp = new int[2][c+1];
    //0号物品分别去填充容量1.2.3.。。c的背包
    for (int i = 0; i <= c; i++) {
      dp[0][i] = (w[0] <= i ? v[0] : 0);
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= c; j++) {
        //只有两行根据奇偶来回覆盖，第i个物品重量为j的时候应该放到i%2跟他有关系的上一行(i-1)%2
        dp[i%2][j] = dp[(i-1)%2][j];
        if(w[i] <= j){
          dp[i%2][j] = Integer.max(
            dp[i%2][j],//dp[i][j]在判断之前已经被dp[i-1][j]填充过
            dp[(i-1)%2][j - w[i]] + v[i]
          );
        }
      }
    }

    return dp[(n-1)%2][c];
  }

  /**
   * 继续优化只使用一个一维数组解决01背包问题
   */
  public int knapsack2(int[] w,int[] v,int c){
    //dp[i]表示当背包的容量为i的时候使用w数组物品填充所获得最大价值
    int[] dp = new int[c+1];
    int n = w.length;
    for (int j = 0; j <= c; j++) {
      dp[j] = (j >= w[0] ? v[0] : 0);
    }
    //i表示使用[0...i]个物品填充容量为j的背包所获的最大价值
    for (int i = 0; i < n; i++) {
      //注意终止条件是j >= w[i]当j<w[i]时无法放下不用更新，也可以写j>0只不过后面要判断
      for (int j = c; j >= w[i]; j--) {
//        if(j >= w[i]) 前面终止条件就是j>=w[i]当条件时j>0的时候需要判断
          dp[j] = Integer.max(
            dp[j],
            dp[j - w[i]] + v[i]
          );         
        }
    }
    return 0;
  }
}
