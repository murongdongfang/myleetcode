package xxh.tree;

/**
 *@author HP
 *@date 2020/6/2
 *@discription:
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class Solution226 {
  //两种写法，形式不一样，实质却一样
  public TreeNode invertTree(TreeNode root) {
    if(root == null){
      return root;
    }
    invertTree(root.left);
    invertTree(root.right);
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    return root;
  }
  public TreeNode invertTree1(TreeNode root) {
    if(root == null) {
      return root;
    }
    TreeNode leftNode = invertTree(root.left);
    TreeNode rightNode = invertTree(root.right);
    root.left = rightNode;
    root.right = leftNode;
    return root;
  }
}
