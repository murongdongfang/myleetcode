package com.whpu.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@author xxh
 *@date 2020/5/18
 *@discription:
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */
public class Solution40 {
  private List<List<Integer>> res = new ArrayList<>();
  public void backTrance(int[] candidates, int target,int index,List<Integer> list){
    if (target == 0){
      res.add(new ArrayList<>(list));
    }
    for (int start = index; start < candidates.length; start++) {
      //剪枝优化
      if(target-candidates[start]<0){
        return;
      }
      /**
       * 必须要有start>index的前置条件，否则会有数组越界异常，因为第一次的时候index=0
       * 而且每次开始start都是等于index，下一次的时候数组中start=start-1就代表start-1已经被使用过
       * index表示每次进入递归函数第一个元素，start每次回归的时候index都要增加
       */
      if(start > index && candidates[start] == candidates[start-1]){
        continue;
      }
      list.add(candidates[start]);
      backTrance(candidates,target-candidates[start],start+1,list);
      list.remove(list.size()-1);
    }

  }
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if(candidates == null || candidates.length == 0){
      return res;
    }
    //方便后来的去重
    Arrays.sort(candidates);
    backTrance(candidates,target,0,new ArrayList<>());

    return res;
  }
//=============方法二，关键是去重，排序去重
  public static List<List<Integer>> combinationSum22(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    backtrack(res, candidates, target, 0, 0, new ArrayList<Integer>());
    return res;

  }

  private static void backtrack(List<List<Integer>> res, int[] candidates, int target, int i, int tmp_sum, ArrayList<Integer> tmp_list) {
    if (tmp_sum == target) {
      res.add(new ArrayList<>(tmp_list));
      return;
    }
    for (int start = i; start < candidates.length; start++) {
      if (tmp_sum + candidates[start] > target) break;
      //去重，保证一个数字只出现一次
      if (start > i && candidates[start] == candidates[start - 1]) continue;
      tmp_list.add(candidates[start]);
      backtrack(res, candidates, target, start + 1, tmp_sum + candidates[start], tmp_list);
      tmp_list.remove(tmp_list.size() - 1);
    }
  }



  public static void main(String[] args) {
    int [] arr = {10,1,2,7,6,1,5};
    System.out.println(combinationSum22(arr, 8));
  }

  //方法三
  class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public void backTrance(int index,int[] candidates,int target,List<Integer> list){
      if(target == 0){
        res.add(new ArrayList(list));
      }
      for(int start = index;start < candidates.length;start++){
        //剪枝，target<0说明此后当前集合中的元素值和大于target，此时应该跳出循环，回溯寻找下一个数
        if(target < 0)
          break;
        //最重要的一步：去重,必须要有start>index的判断防止数组越界
        if(start > index && candidates[start] == candidates[start - 1])
          continue;
        list.add(candidates[start]);
        //递归
        backTrance(start+1,candidates,target-candidates[start],list);
        //回溯
        list.remove(list.size() - 1);
      }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      if(target < 0 || candidates == null || candidates.length == 0)
        return null;
      Arrays.sort(candidates);
      backTrance(0,candidates,target,new ArrayList());

      return res;
    }
  }
}
