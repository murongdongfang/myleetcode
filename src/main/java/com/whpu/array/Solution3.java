package com.whpu.array;

/**
 *@author xxh
 *@since 2020/6/17
 *@discription:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution3 {
  public int lengthOfLongestSubstring(String s) {
    if(s == null || s.length() == 0){
      return 0;
    }
    char[] chars = s.toCharArray();
    /**
     * 技巧：判断一个字符数组中某个字符是否重复或者统计一个字符数组中各个字符出现的频率
     * 1.维护一个长度为256的int数组，下标代表这个字符（字符的ASC码），值代表这个字符出现的频率
     * 遍历这个字符数组每次遍历到相应的字符freq加1
     * 2.使用HashMap
     */
    int[] freq = new int[256];


    int l = 0,r = -1;
    int size = 0;
    while(l < chars.length){
      if(r+1 < chars.length && freq[chars[r+1]] == 0){
        freq[chars[++r]]++;
      }else{
        //freq减少到0，滑动窗口的左边界l正好移动到这个重复字母的一个字母
        freq[chars[l++]]--;
      }
      size = Integer.max(size,r - l + 1);
    }

    return size;
  }
}
