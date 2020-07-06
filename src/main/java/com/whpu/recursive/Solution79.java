package com.whpu.recursive;

import java.util.Objects;

/**
 *@author xxh
 *@date 2020/5/19
 *@discription:
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class Solution79 {
  private  static int m;//边界长度
  private  static int n;//边界宽度
  private static boolean[][] used;//二维边界中每一个点是否被访问过，初始值未false
  private static int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};//按照顺时针方向搜索
  /**
   * 从指定坐标递归搜索相应的字母（word的index下标处的字母）
   * @param board  二维边界
   * @param word  要搜索的字符串
   * @param x 开始搜索位置横坐标
   * @param y  开始搜索位置纵坐标
   * @param index  要搜索word字符串中指定的字母，从0开始
   * @return
   */
  /*
    abcced
   * a b c e
   * s f c s
   * a d e f
   * */
  public static boolean searchWord(char[][] board,String word,int x,int y,int index){
    //递归终止条件
    if(index == word.length() - 1){
      return Objects.equals(board[x][y],word.charAt(index));
    }
    if(Objects.equals(word.charAt(index),board[x][y])){
      used[x][y] = true;
      for (int i = 0; i < 4; i++) {
        int newx = direction[i][0] + x;
        int newy = direction[i][1] + y;
          if(inArea(newx,newy) && !used[newx][newy]){
            if(searchWord(board,word,newx,newy,index+1))
              return true;
          }
      }
      used[x][y] = false;
    }
    //当前位置的上下左右都没有找到指定的字符这个位置搜索失败
    return false;
  }

  private static boolean inArea(int x, int y) {
    return x>=0 && x < m && y>=0 && y < n;
  }

  public static boolean exist(char[][] board, String word) {
     m = board.length;
     n = board[0].length;
    used = new boolean[m][n];
    for (int i = 0; i < used.length; i++) {
      for (int j = 0; j < used[0].length; j++) {
        used[i][j] = false;
      }
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
         if(searchWord(board,word,i,j,0)){
            return true;
         }
      }

    }
    return false;
  }

  public static void main(String[] args) {
    /*
    * a b c e
    * s f c s
    * a d e f
    * */
    char[][] board = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','f'}};
    String word = "abcced";
    boolean flag = exist(board,word);
    System.out.println(flag);
  }
}
