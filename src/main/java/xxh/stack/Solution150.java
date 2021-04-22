package xxh.stack;

import java.util.Objects;
import java.util.Stack;

/**
 *@author xxh
 *@date 2020/5/24
 *@discription:
 *根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class Solution150 {
  public static void main(String[] args) {
    String[] tokens = {"4","13","5","/","+"};
    evalRPN(tokens);
  }
  public static int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      if(!isOper(token)){
        stack.push(Integer.parseInt(token));
      }else {
        Integer num1 = stack.pop();
        Integer num2 = stack.pop();
        Integer val = calculate(num1, num2, token);
        stack.push(val);
      }
      
    }

    return stack.pop();
  }

  public static Integer calculate(Integer num1,Integer num2,String op){
    if(Objects.equals("+",op)){
      return num1 + num2;
    }else if (Objects.equals("-",op)){
      //不要写成num1-num2
      return num2 - num1;
    }else if(Objects.equals("*",op)){
      return num1 * num2;
    }else {
      //不要写成num1-num2
      return num2 / num1;
    }

  }
  public static boolean isOper(String str){
    boolean flag = Objects.equals("+",str)
                  || Objects.equals("-",str)
                  || Objects.equals("*",str)
                  || Objects.equals("/",str);
    return flag;

  }
}
