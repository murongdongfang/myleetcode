package com.whpu.list;

/**
 *@author xxh
 *@date 2020/5/22
 *@discription:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Solution24 {
  //采用虚拟头节点的方式交换链表相邻节点
  public ListNode swapPairs1(ListNode head) {
    if(head == null || head.next == null){
      return head;
    }
    //要是不设置虚拟头节点，最后的返回值不好确定，因为head交换了位置
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode cur = dummyHead;
    while(cur.next != null && cur.next.next != null){
      ListNode pre = cur;
      //node1和node2是两个待交换节点
      ListNode node1 = cur.next;
      ListNode node2 = node1.next;
      node1.next = node2.next;
      node2.next = pre.next;
      pre.next = node2;
      cur = node1;
    }

    ListNode retNode = dummyHead.next;
    dummyHead.next = null;

    return retNode;
  }

  //采用递归的方式交换链表中相邻的节点
  public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null){
      return head;
    }

    //交换当前head和它下一个节点pre的位置
    ListNode pre = head.next;
    //以下两句不能交换位置否则会造成stackoverflow
    head.next = swapPairs(pre.next);
    pre.next = head;

    return pre;
  }
}
