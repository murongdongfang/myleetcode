package com.whpu.tree;

/**
 *@author HP
 *@date 2020/6/2
 *@discription:
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 示例：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class Solution437 {
  public int pathSum(TreeNode root, int sum) {
    if(root == null) {
      return 0;
    }

    //遍历的当前节点在最终的路径中
    int res = findPath(root,sum);

    //遍历的当前不在最终路径中
    res += pathSum(root.left,sum);
    res += pathSum(root.right,sum);
    return  res;
  }

  public int findPath(TreeNode node,int sum){

    if(node == null) {
      return 0;
    }
    int res = 0;
    if(node.val == sum) {
      res++;
    }

    res += findPath(node.left,sum-node.val);
    res += findPath(node.right,sum-node.val);

    return res;
  }
}
