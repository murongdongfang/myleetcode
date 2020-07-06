package com.whpu.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@author xxh
 *@date 2020/5/18
 *@discription:
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Solution90 {
  private static List<List<Integer>> res = new ArrayList<>();
  public static void generateSubSetsWithDup(int k,int index,int[] nums,List<Integer> list){
    if(list.size() == k){
      res.add(new ArrayList<>(list));
    }
    for (int start = index; start < nums.length; start++) {
      //最重要的一句：去重，要先好排序
      if(start > index && nums[start] == nums[start-1]){
        continue;
      }
      list.add(nums[start]);
      generateSubSetsWithDup(k,start+1,nums,list);
      list.remove(list.size() - 1);
    }

  }
  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    if(nums == null && nums.length == 0){
      return null;
    }
    //去重先排序
    Arrays.sort(nums);
    res.add(new ArrayList<>());

    for (int i = 1; i <= nums.length; i++) {
      generateSubSetsWithDup(i,0,nums,new ArrayList<>());

    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr = {2,1,2};
    System.out.println(subsetsWithDup(arr));
  }
}
