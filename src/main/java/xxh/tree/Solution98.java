package xxh.tree;

/**
 *@author HP
 *@date 2020/6/7
 *@discription:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例2:
 *
 * 输入:
 *     5
 *    / \
 *   1  4
 *     / \
 *    3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *     根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class Solution98 {
  long pre = Long.MIN_VALUE;
//  二叉排序树的中序遍历结果是一个有序数组，且有序数组的前一个元素一定小于后一个元素。
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    // 访问左子树
    if (!isValidBST(root.left)) {
      return false;
    }
    // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
    if (root.val <= pre) {
      return false;
    }
    pre = root.val;
    // 访问右子树
    return isValidBST(root.right);
  }
  //常规方法
  public boolean isValidBST2(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean validate(TreeNode node, long min, long max) {
    if (node == null) {
      return true;
    }
    if (node.val <= min || node.val >= max) {
      return false;
    }
    return  validate(node.left, min, node.val) && validate(node.right, node.val, max);
  }

  //错误写法 只保证了一个节点一定大于或小于直系左右节点未保证大于或者小于所有孩子节点，错误详见
  //https://leetcode-cn.com/problems/validate-binary-search-tree/solution/bao-zhun-sheng-guo-guan-fang-ti-jie-by-novice2mast/
  public boolean isValidBST3(TreeNode root){
    if(root == null){
      return true;
    }
    if(root.left != null && root.left.val >= root.val){
      return false;
    }
    if(root.right != null && root.right.val >= root.val){
      return false;
    }

    return isValidBST3(root.left) && isValidBST3(root.right);
  }

}
