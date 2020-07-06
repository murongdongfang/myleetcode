package com.whpu.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 *@author xxh
 *@date 2020/5/18
 *@discription:
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution216 {
  List<List<Integer>> res = new ArrayList<>();
  public void generateCombinationSum3(int k,int n,int index,List<Integer> list){
    if(list.size() == k && n == 0){
      res.add(new ArrayList<>(list));
      return;
    }
    for (int start = index; start <= 9; start++) {
      //剪枝
      if(n < 0){
        continue;
      }
      list.add(start);
      generateCombinationSum3(k,n-start,start+1,list);
      list.remove(list.size()-1);
    }


  }
  public List<List<Integer>> combinationSum3(int k, int n) {
    if(k < 0 || n < 0){
      return null;
    }
    generateCombinationSum3(k,n,1,new ArrayList<>());
    return res;
  }
}
