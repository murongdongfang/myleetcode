package xxh.tree;

/**
 *@author xxh
 *@since 2020/10/9
 *@discription:
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度 2.
 */
public class Solution111 {
  public int minDepth(TreeNode root) {
    if (root == null)
      return 0;
    // null节点不参与比较
    if (root.left == null && root.right != null) {
      return 1 + minDepth(root.right);
    }
    // null节点不参与比较
    if (root.right == null && root.left != null) {
      return 1 + minDepth(root.left);
    }
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }
}
