package xxh.tree;

import java.util.LinkedList;

/**
 *@author xxh
 *@since 2021/4/12
 *@discription:
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
 * （注：第 h 层可能包含 1~2h个节点。）
 * 示例 1：
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 */
public class Solution958 {
  public boolean isCompleteTree(TreeNode root) {
    if (root == null)
        return true;
    LinkedList<TreeNode> list = new LinkedList<>();
    list.add(root);
    while (!list.isEmpty()){
      TreeNode node = list.removeFirst();
      if (node != null){
        // 在BFS中只有左孩子不为空才入队，这里都需要入队。非空校验放在前面
        list.addLast(node.left);
        list.addLast(node.right);
      }else {
        // 只要有空的循环判断后边的元素是否全为null
         while (!list.isEmpty()) {
           node = list.removeFirst();
           if (node != null){
             return false;
           }
         }
      }
    }
    return true;
  }
}
