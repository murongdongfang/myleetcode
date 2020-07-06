package com.whpu.queue;


import javafx.util.Pair;

import java.util.LinkedList;

/**
 *@author HP
 *@date 2020/5/30
 *@discription:
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class Solution279 {
  //构造一个图，然后使用图的BFS遍历，BFS能够保证完全平方数的个数最少
  public int numSquares1(int n) {

    boolean[] visited = new boolean[n+1];
    visited[n] = true;
    //表示0,1,2...n这n+1个数字是否被访问过
    Pair<Integer,Integer> p = new Pair<>(n,0);
    LinkedList<Pair<Integer,Integer>> queue = new LinkedList<>();
    queue.add(p);
    while(!queue.isEmpty()){
      //key当前数组，value表示当前数字到n的跳数
      //eg：表示当前数字n到给定的n跳数为0
      Pair<Integer, Integer> pair = queue.removeFirst();
      Integer num = pair.getKey();
      Integer step = pair.getValue();
      if(num == 0){
        return step;
      }
      //优化算法细节
      for (int i = 1;  ; i++) {
        int val = num-i*i;
        if(val < 0){
          break;
        }
        if(val == 0) {
          return step + 1;
        }
        if(!visited[val]){
          queue.addLast(new Pair<>(val,step+1));
          visited[val] = true;
        }
      }
    }
    //抛异常不用返回值
    return 0;
  }
}
