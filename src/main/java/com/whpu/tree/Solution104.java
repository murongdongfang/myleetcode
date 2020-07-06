package com.whpu.tree;

/**
 *@author HP
 *@date 2020/6/2
 *@discription: leetcode
 */
public class Solution104 {
  public int maxDepth(TreeNode root) {
    if(root == null){
      return 0;
    }
//    return Integer.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    return Integer.max(maxDepth(root.left) + 1,maxDepth(root.right) + 1);
  }
}
