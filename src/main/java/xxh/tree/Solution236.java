package xxh.tree;

/**
 *@author HP
 *@date 2020/6/7
 *@discription:
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树: root =[3,5,1,6,2,0,8,null,null,7,4]
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class Solution236 {

  /**
   * 两种情况p是q的父节点（或者q是p的父节点）此时lca就是p，第二种情况pq分别分别位于lca的左右两边
   * p 和 q 在 root 的子树中，且分列 rootroot 的 异侧（即分别在左、右子树中）；
   * p = root p=root ，且 q 在 root 的左或右子树中；
   * q = root q=root ，且 p 在 root 的左或右子树中；
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    /**
     * LCA问题
       注意p,q必然存在树内, 且所有节点的值唯一!!!
       递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
       表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
       1. 左右子树的返回值都不为null, 由于值唯一左右子树的返回值就是p和q, 此时root为LCA
       2. 如果左右子树返回值只有一个不为null, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为LCA
       3. 左右子树返回值均为null, p和q均不在树中, 返回null
     **/
    if (root == p || root == q || root == null) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
      return root;
    } else if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    }
    return null;
  }
}
