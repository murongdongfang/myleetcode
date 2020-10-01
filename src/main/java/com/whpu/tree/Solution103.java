package com.whpu.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *@author HP
 *@date 2020/5/28
 *@discription:
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Solution103 {
//  使用BFS实现
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     LinkedList<List<Integer>> res = new LinkedList<>();
     if(root == null){
       return res;
     }
     boolean flag = true;
     LinkedList<TreeNode> queue = new LinkedList<>();
     queue.add(root);
     while(!queue.isEmpty()){
       int level = queue.size();
       List<Integer> list = new ArrayList<>();
       while(level > 0){
         TreeNode node = queue.removeFirst();
         if(res.size() % 2 == 0){
           //放到最后
           list.add(node.val);
         }else{
           //放到最前
           list.add(0,node.val);
         }
         if(node.left != null){
           queue.add(node.left);
         }
         if(node.right != null){
           queue.add(node.right);
         }
         level--;
       }
       res.add(list);
     }
    return res;
  }

//  使用DFS实现
  public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    traversal(root, res, 0);
    return res;
  }

  private void traversal(TreeNode root, List<List<Integer>> res, int level) {
    if (root == null) {
      return;
    }

    if (res.size() == level) {
      res.add(new ArrayList<Integer>());
    }

    if ((level & 1) == 1){
      res.get(level).add(0, root.val);
    } else {
      res.get(level).add(root.val);
    }

    traversal(root.left, res, level + 1);
    traversal(root.right, res, level + 1);
  }
}
