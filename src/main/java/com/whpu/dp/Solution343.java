package com.whpu.dp;

/**
 *@author xxh
 *@since 2020/7/6
 *@discription:
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 */
public class Solution343 {

  int[] flag;
  
  public int integerBreak(int n) {
    flag = new int[n + 1];
    for (int i = 0; i < flag.length; i++) {
      flag[i] = -1;
    }

    //使用动态规划的方法求解
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j < i ; j++) {
        //将i分割成j和i-j两个部分 比较j*(i-j)，flag[i]和j*flag[i-j]三者的关系
        flag[i] = max3(j*(i-j),flag[i],j*flag[i-j]);

      }
      
    }
    return flag[n];
    //return helper(n);
  }

  public int max3(int x,int y,int z){
    return Integer.max(Integer.max(x,y),z);
  }
  //使用递归+记忆化搜索优化
  public int helper(int n){
    if(n == 1){
      return 1;
    }
    if(flag[n] != -1){
      return flag[n];
    }
    //也可以把这个res当成一个成员变量
    int res = -1;
    for(int i = 1;i <= n - 1;i++){
      res = max3(i*(n-i),i*helper(n - i),res);
    }

    flag[n] = res;
    return res;
  }

}
