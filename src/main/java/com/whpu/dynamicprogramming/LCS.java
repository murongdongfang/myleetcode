package com.whpu.dynamicprogramming;

/**
 *@author xxh
 *@since 2020/7/7
 *@discription:
 * 最长公共子序列
 */
public class LCS {
  public int lcs(int[] s1,int[] s2){
    /**
     * LCS(m,n)表示s1[0..m]和s2[0..n]最长公共子序列长度
     * 此时LCS的状态转移方程为：
     * 当s1[m] = s2[n]的时候
     * LCS(m,n) = 1 + LCS(m - 1,n - 1)
     * 当s1[m] != s2[n]的时候
     * LCS(m,n) = max(LCS(m - 1,n),LCS(m,n - 1))
     */
    return 0;
  }
}
