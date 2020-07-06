package com.whpu.queue;

import com.whpu.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *@author HP
 *@date 2020/5/28
 *@discription:
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class Solution199 {

  List<Integer> res = new ArrayList<>();

  //DFS
  public List<Integer> rightSideView1(TreeNode root) {
    dfs(root, 0); // 从根节点开始访问，根节点深度是0
    return res;
  }

  private void dfs(TreeNode root, int depth) {
    if (root == null) {
      return;
    }
    // 先访问 当前节点，再递归地访问 右子树 和 左子树。
    if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
      res.add(root.val);
    }
    depth++;
    dfs(root.right, depth);
    dfs(root.left, depth);
  }

  //BFS
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if(root == null){
      return res;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){
      int level = queue.size();
      //下面是右孩子先入栈的，所以每一层开始之前只需要取出第一个元素就是就是这一层的最后一个元素
      res.add(queue.peekFirst().val);
      while(level > 0){
        TreeNode node = queue.removeFirst();
        //交换左右孩子节点的入栈顺序
        if(node.right != null){
          queue.add(node.right);
        }
        if(node.left != null){
          queue.add(node.left);
        }
        level--;
      }

    }

    return res;
  }

}
