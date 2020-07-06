package com.whpu.queue;

import com.whpu.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *@author HP
 *@date 2020/5/28
 *@discription:
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Solution107 {
  //和二叉树的层次遍历方式一致,只是在最后添加的时候res.addFirst(list);将层次倒着放
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> res = new LinkedList<>();
    if(root == null){
      return res;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
      int count = queue.size();
      List<Integer> list = new ArrayList<>();
      //count>0就表示当前队列中所有节点是同一层的
      while(count > 0){
        TreeNode node = queue.removeFirst();
        list.add(node.val);
        if(node.left != null){
          queue.add(node.left);
        }
        if(node.right != null){
          queue.add(node.right);
        }
        count--;
      }
      //把层次倒着放
      res.addFirst(list);
    }

    return res;
  }
}
