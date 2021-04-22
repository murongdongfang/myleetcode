package xxh.recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *@author xxh
 *@date 2020/5/23
 *@discription:
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 示例:
 * 输入: 4
 * 输出:
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * row:[[1,3,0,2],[2,0,3,1]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 提示：
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。
 * 当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。
 */
public class Solution51 {

  private static List<List<String>> res = new ArrayList<>();
  //当前位置正下方是否有皇后
  private static boolean[] col;
  //当前位置斜下方（/）是否有皇后
  private static boolean[] dia1;
  //当前位置斜下方（\）是否有皇后
  private static boolean[] dia2;

  /**
   * 在第index行中放入皇后
   * @param n 皇后个数
   * @param index 第index行
   * @param row 第index行的皇后应该放到rot.get(index)列
   */
  /**
   * 00 01 02 03
   * 10 11 12 13
   * 20 21 22 23
   * 30 31 32 33
   * row:[[1,3,0,2],[2,0,3,1]]
   */
  public static void putQueue(int n, int index, LinkedList<Integer> row){
    if(index == n){
      res.add(generateQueue(row,n));
      return;
    }

    for(int i = 0; i < n ; i ++)
      // 尝试将第index行的皇后摆放在第i列,  (index,i)表示当前坐标,index为行坐标，i为纵坐标
      if(!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]){
        row.addLast(i);
        col[i] = true;
        dia1[index + i] = true;
        dia2[index - i + n - 1] = true;
        putQueue(n, index + 1, row);
        col[i] = false;
        dia1[index + i] = false;
        dia2[index - i + n - 1] = false;
        row.removeLast();
      }

//    return; 写不写都行

  }
  public static List<String> generateQueue(List<Integer> row,int n){
    List<String> list = new ArrayList<>();
    System.out.println("the row is");
    System.out.println(row);
    if (row == null){
      return list;
    }
    for (Integer temp : row) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < n; i++) {
        if (i == temp) {
          sb.append("Q");
        }else {
          sb.append(".");
        }
      }
      list.add(sb.toString());
    }

      return list;
  /*
    这种方法也可以
    assert row.size() == n;
    ArrayList<String> board = new ArrayList<String>();
    for(int i = 0 ; i < n ; i ++){
      char[] charArray = new char[n];
      Arrays.fill(charArray, '.');
      charArray[row.get(i)] = 'Q';
      board.add(new String(charArray));
    }
    return board;*/
  }
  public static List<List<String>> solveNQueens(int n) {

    res = new ArrayList<List<String>>();
    col = new boolean[n];
    dia1 = new boolean[2 * n - 1];
    dia2 = new boolean[2 * n - 1];

    LinkedList<Integer> row = new LinkedList<Integer>();
    putQueue(n,0,row);
    return res;
}

  private static void printBoard(List<String> board){
    for(String s: board)
      System.out.println(s);
    System.out.println();
  }

  public static void main(String[] args) {
    int n = 10;
    solveNQueens(n);
    for(List<String> board: res)
      printBoard(board);
  }
}
