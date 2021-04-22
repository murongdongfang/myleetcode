package xxh.queue;

import xxh.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *@author HP
 *@date 2020/5/28
 *@discription:
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Solution102 {


  public List<List<Integer>> levelOrder(TreeNode root) {
     List<List<Integer>> res = new ArrayList<>();
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
      res.add(list);
    }


    return res;
  }
}
