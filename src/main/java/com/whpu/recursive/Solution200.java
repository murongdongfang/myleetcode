package com.whpu.recursive;

import java.util.Objects;

/**
 *@author xxh
 *@date 2020/5/19
 *@discription:
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class Solution200 {
  private static boolean[][] used;
  private static int m,n;
  private static int res = 0;
  private static int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};//按照顺时针方向搜索

  public static boolean inArea(int x,int y){
    return x>=0 && x<m && y>=0 && y<n;
  }
  /*
   * 1 1 1 1 0
   * 1 1 0 1 0
   * 1 1 0 0 0
   * 0 0 0 0 0
   * */
  public static void dfs(char[][] grid,int x,int y){
    used[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int newx = x + direction[i][0];
      int newy = y + direction[i][1];
      if(inArea(newx,newy) && !used[newx][newy] && Objects.equals(grid[x][y],'1')){
        /**
         * 注意：这个DFS递归没有显示的递归终止条件，但是却不会造成死递归，
         * 因为只有满足条件才会递归，如果不满足条件递归函数体为空直接返回，类似于二叉树的递归遍历
         * 这个递归也不用回溯将used[x][y]=false；不同于79题。因为值要满足条件就要遍历，然后标记
         */
        dfs(grid,newx,newy);
      }
    }
    return;
  }
  /*
   * 1 1 1 1 0
   * 1 1 0 1 0
   * 1 1 0 0 0
   * 0 0 0 0 0
   * */
  public static  int numIslands(char[][] grid) {
    if(grid == null || grid.length == 0){
      return 0;
    }
    m = grid.length;
    n = grid[0].length;
    used = new boolean[m][n];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        used[i][j] = false;
      }
    }

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if(Objects.equals(grid[i][j],'1') && !used[i][j]){
          dfs(grid,i,j);
          res++;
        }

      }
    }
    return res;
  }

  public static void main(String[] args) {
    /*
    * 1 1 1 1 0
    * 1 1 0 1 0
    * 1 1 0 0 0
    * 0 0 0 0 0
    * */
    char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    numIslands(grid);
    System.out.println(res);
  }

}
