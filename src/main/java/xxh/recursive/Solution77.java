package xxh.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 *@author xxh
 *@date 2020/5/18
 *@discription:
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Solution77 {
  private static List<List<Integer>> res = new ArrayList<>();
  public static void generateCombinations(int n,int k,int start,List<Integer> list){
    if(list.size() == k){
      //注意：不能直接res.add(list)否则res里边全是null
      ArrayList<Integer> integers = new ArrayList<>(list);
      res.add(integers);
      return;
    }
    //剪枝优化，当前list中已经由list.size()个元素，还需要从从[i...n]寻找k-list.size()个元素
    for (int i = start; i <= n-(k-list.size())+1; i++) {
      list.add(i);
      //注意是i+1而非start+1
      generateCombinations(n,k,i+1,list);
      //一定要记得清楚上一次的值
      list.remove(list.size()-1);
    }


  }
  public static List<List<Integer>> combine(int n, int k) {
    if(k > n || n <= 0 || k <= 0){
      return null;
    }
    List<Integer> list = new ArrayList<>();
    generateCombinations(n,k,1,list);
    return res;
  }

  public static void main(String[] args) {
    System.out.println(combine(3, 2));
  }
}
