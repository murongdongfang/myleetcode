package com.whpu.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 *@author xxh
 *@date 2020/5/23
 *@discription: leetcode
 */
public class Solution52 {
  private boolean[] col;
  private boolean[] dia1;
  private boolean[] dia2;
  private int res = 0;
  public int totalNQueens(int n) {
    col = new boolean[n];
    dia1 = new boolean[2*n-1];
    dia2 = new boolean[2*n-1];
    putQueens(n,0,new ArrayList<Integer>());
    return res;

  }

  public void putQueens(int n, int index, List<Integer> row){
    if(index == n){
      res++;
      return ;
    }

    for(int i = 0;i < n;i++){
      if(!col[i] && !dia1[i+index] && !dia2[index-i+n-1]){
        col[i] = true;
        dia1[i+index] = true;
        dia2[index-i+n-1] = true;
        row.add(i);
        putQueens(n,index+1,row);
        col[i] = false;
        dia1[i+index] = false;
        dia2[index-i+n-1] = false;
        row.remove(row.size() - 1);
      }
    }

  }
}
