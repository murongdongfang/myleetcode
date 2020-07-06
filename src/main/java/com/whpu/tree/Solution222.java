package com.whpu.tree;

import java.util.LinkedList;

/**
 *@author HP
 *@date 2020/6/6
 *@discription: 
 * 给出一个完全二叉树，求出该树的节点个数。
 * 说明：
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * 示例:
 * 输入: 
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 */
public class Solution222 {
  //正规解法，利用完全二叉树的性质
  public int countNodes(TreeNode root) {
    if(root == null) {
      return 0;
    }
    int depth = getDepth(root);
    int deep = getDepth(root.right);
    if(deep == depth - 1) {
      return (1 << (depth-1)) + countNodes(root.right);
    }
    return (1 << deep) + countNodes(root.left);
  }
  public int getDepth(TreeNode root) {
    int res = 0;
    while(root != null) {
      root = root.left;
      res++;
    }
    return res;
  }
  //暴力解法一：DFS
  public int countNodes2(TreeNode root) {
    if(root == null){
      return 0;
    }

    return (countNodes2(root.left) + countNodes2(root.right)) + 1;
  }
  //暴力解法二：BFS
  public int countNodes1(TreeNode root) {
    if(root == null){
      return 0;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    int count = 0;
    while (!queue.isEmpty()){
      TreeNode node = queue.removeFirst();
      count++;
      if(node.left != null){
        queue.addLast(node.left);
      }
      if(node.right != null){
        queue.addLast(node.right);
      }
    }

    return count;
  }
}
