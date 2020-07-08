package com.whpu.tree;

import java.util.Stack;

/**
 *@author xxh
 *@since 2020/7/13
 *@discription:
 * 二叉树的非递归遍历方式
 */
public class ThreeOrder {
  //二叉树非递归中序遍历
  public void inOrder(TreeNode root){
    if(root == null){
      return;
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode node = root;
    while(!stack.isEmpty() || node != null){
      if(node != null){
        stack.add(node);
        node = node.left;
      }else{
        node = stack.pop();
        System.out.println(node.val);
        node = node.right;
      }
    }
  }

  //二叉树非递归先序遍历
  public void preOrder(TreeNode root){
    if(root == null){
      return;
    }
    TreeNode node = root;
    Stack<TreeNode> stack = new Stack<>();
    if(!stack.isEmpty() || node != null){
      if(node != null){
        System.out.println(node.val);
        stack.add(node);
        node = node.left;
      }else{
        node = stack.pop();
        node = node.right;
      }
    }
  }
  //二叉树非递归后序遍历，三种非递归遍历方式中最难的一种
  public void postOrder(TreeNode root){
    if(root == null){
      return;
    }
    TreeNode node = root,pre = null;
    Stack<TreeNode> stack = new Stack<>();
    while(node != null || !stack.isEmpty()){
      if(node != null){
        stack.add(node);
        node = node.left;
      } else{
        node = stack.peek();
        //如果存在右子树并且右子树没有被访问就继续入栈
        if(node.right != null && node.right != pre){
          node = node.right;
          stack.add(node);
          node = node.left;
        }else{
          //如果右子树为空，或者右子树被访问过就出栈并且访问当前节点
          node = stack.pop();
          System.out.println(node.val);
          pre = node;
          //node必须置为null，否则就会死循环
          node = null;
        }
      }
    }


  }
}
