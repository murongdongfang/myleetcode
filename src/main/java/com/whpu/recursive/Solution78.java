package com.whpu.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 *@author xxh
 *@date 2020/5/18
 *@discription:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Solution78 {
  private List<List<Integer>> res = new ArrayList<>();
  public void generateSubSets(int[] nums,int k,int index,List<Integer> list){
    if(list.size() == k){
      res.add(new ArrayList<>(list));
    }
    for (int start = index; start < nums.length; start++) {
      list.add(nums[start]);
      generateSubSets(nums,k,start+1,list);
      list.remove(list.size() - 1);
    }

  }
  public List<List<Integer>> subsets(int[] nums) {
    if(nums == null || nums.length == 0){
      return null;
    }
    res.add(new ArrayList<Integer>());
    for (int i = 1; i <= nums.length; i++) {
      generateSubSets(nums,i,0,new ArrayList<Integer>());
    }

    return res;
  }

  //方法二
  //input：[1,2,3]
  //output：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
  public static List<List<Integer>> subsets2(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for (int i = 0; i < nums.length; i++) {
      int len = result.size();
      for (int j = 0; j < len; j++) {
        List<Integer> cur = new ArrayList<>(result.get(j));
        cur.add(nums[i]);
        result.add(cur);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int [] arr = {1,2,3,4};
    System.out.println(subsets2(arr));
  }
}
