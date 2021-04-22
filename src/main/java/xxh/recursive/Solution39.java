package xxh.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 *@author xxh
 *@date 2020/5/18
 *@discription:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class Solution39 {
  private List<List<Integer>> res = new ArrayList<>();
  public void helper(int[] candidates,int target,List<Integer> list,int start){
    if(target < 0){
      return ;
    }
    if(target == 0){
      ArrayList<Integer> integers = new ArrayList<>(list);
      res.add(integers);
    }
    for (int i = start; i < candidates.length; i++) {
      list.add(candidates[i]);
      //由于一个数字能够使用多次，所以下次递归也是从这个i开始，如果每一个数字只能使用一次那就是从i+1开始
      helper(candidates,target-candidates[i],list,i);
      //回溯
      list.remove(list.size()-1);
    }

  }
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if(target <= 0){
      return null;
    }
    ArrayList<Integer> integers = new ArrayList<>();
    helper(candidates,target,integers,0);
    return res;
  }
}
