package com.whpu.tree;

/**
 *@author HP
 *@date 2020/6/2
 *@discription:
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Solution101 {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return cmp(root.left, root.right);
  }

  private boolean cmp(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null) {
      return true;
    }
    if (node1 == null || node2 == null || node1.val != node2.val) {
      return false;
    }
    return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
  }
}
