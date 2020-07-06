package com.whpu.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 *@author xxh
 *@since 2020/6/16
 *@discription:
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Solution93 {
  private List<String> res = new ArrayList<>();
  public List<String> restoreIpAddresses(String s) {
    if (s.length() < 4) //非法输入
      return res;
    backtrack(s, 0, new StringBuilder(), 0);
    return res;
  }
  private void backtrack(String s, int start, StringBuilder sb, int pointNumOfSb) {
    if (pointNumOfSb > 4) //大于三个点，则剪枝，这里大于4是因为最后一次还会加一
      return;
    if (start == s.length() && pointNumOfSb == 4) {   //pointNumOfSb==4，则是一个合法的IP
      res.add(sb.toString().substring(1));   //substring(1)是因为每次append(".xxx")，第零个位置是"."
      return ;
    }
    for (int i = start; i < s.length() && i - start < 3; i++) { //i-start < 3，如果大于三位数则返回
      String x = s.substring(start, i + 1);
      if (x.charAt(0) == '0' && x.length() > 1) //如果是0xx这种则返回
        return ;
      if (Integer.parseInt(x) <= 255) {
        sb.append("." + x);
        backtrack(s, i + 1, sb, pointNumOfSb + 1);
        //剪枝
        sb.delete(sb.lastIndexOf("."), sb.length());
      }
    }
  }
}
