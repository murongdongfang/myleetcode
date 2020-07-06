package com.whpu.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *@author HP
 *@date 2020/6/2
 *@discription:
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Solution257 {
  public List<String> binaryTreePaths(TreeNode root) {
    ArrayList<String> res = new ArrayList<>();
     if (root == null){
       return res;
     }

   if(root.left == null && root.right == null){
     res.add(root.val + "");
     return res;
   }

    List<String> leftPath = binaryTreePaths(root.left);
    for (String path : leftPath) {
      path = root.val + "->"+ path;
      res.add(path);

    }
    List<String> rightPath = binaryTreePaths(root.right);
    for (String path : rightPath) {
      path = root.val + "->"+ path;
      res.add(path);
    }

    return res;
  }
}
