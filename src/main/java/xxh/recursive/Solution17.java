package xxh.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 *@author xxh
 *@date 2020/5/19
 *@discription:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

 */
public class Solution17 {
  private String[] strs = {
    "",//0
    "",//1
    "abc",//2
    "def",//3
    "ghi",//4
    "jkl",//5
    "mno",//6
    "pqrs",//7
    "tuv",//8
    "wxyz",//9

  };
  private List<String> res = new ArrayList<>();
  public void findCombinations(char[] digists,String s,int index){
    //终止条件是length而非length-1
    if(index == digists.length){
      res.add(s);
      return ;
    }

    char digist = digists[index];
    for (char ch : strs[digist - '0'].toCharArray()) {
      //递归
      findCombinations(digists,s+ch,index+1);
    }


  }
  public List<String> letterCombinations(String digits) {
    if(digits == null || digits.length() == 0) {
      return res;
    }
    char[] chars = digits.toCharArray();
    findCombinations(chars,"",0);

    return res;
  }

  public static void main(String[] args) {
    Solution17 sol = new Solution17();
    List<String> list = sol.letterCombinations("23");
    System.out.println(list);
  }
}
