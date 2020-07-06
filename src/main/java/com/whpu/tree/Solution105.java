package com.whpu.tree;

import java.util.HashMap;
import java.util.Map;

/**
 *@author xxh
 *@since 2020/6/17
 *@discription:
 *根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * https://mp.weixin.qq.com/s/QHt9fGP-q8RAs8GI7fP3hw
 */
public class Solution105 {
  /**
   * 前序遍历 preorder = [3,9,20,15,7]
   * 中序遍历 inorder = [9,3,15,20,7]
   * 先序遍历数组中先出现的就是根节点，中序遍历数组中中任意一个元素左边所有的元素就是它的左子树，右边所有的元素就是他的右子树
   */
 public Map<Integer,Integer> map = new HashMap<>();
  public int[] preorder = null;
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    this.preorder = preorder;
    //key：中序遍历数组值，value为数组值的索引
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i],i);
    }


    return recursive(0,0,preorder.length -1);
  }

  /**
   * 根据先序和中序遍历顺序递归重建二叉树重建
   * @param preRootIdx 根节点在preorder数组中的索引 同理inRootIdx表示根节点在inorder数组中的索引
   * @param left 在inorder数组[left...inRootIdx-1]表示root节点的左子树
   * @param right 在inorder数组中[inRootIdx+1...right]表示当前root节点的右子树
   * @return
   */
  public TreeNode recursive(int preRootIdx,int left,int right){
    if(right < left){
      return null;
    }
    //根节点在inorder数组中的索引
    Integer rootVal = preorder[preRootIdx];
    Integer inRootIdx = map.get(rootVal);
    TreeNode node = new TreeNode(rootVal);
    //root右子树的根节点在preorder中的索引=根节点root在preorder中索引+1
    node.left = recursive(preRootIdx+1,left,inRootIdx - 1);
    //root右子树的根节点在preorder中的索引=根节点root在preorder中的索引+左子树节点的个数+1
    //在inroder数组中[left...inRootIdx-1]为左子树，左子树节点个数inRootIdex-left
    node.right = recursive((inRootIdx-1-left+1)+preRootIdx+1,inRootIdx+1,right);

    return node;
  }

}
