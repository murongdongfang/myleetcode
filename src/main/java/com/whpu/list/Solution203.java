package com.whpu.list;

/**
 *@author xxh
 *@date 2020/5/20
 *@discription:
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */

public class Solution203 {
  //使用普通方法删除单链表中指定的节点
  public ListNode removeElements(ListNode head, int val) {
    //如果待删除的节点是头节点
    while (head != null && head.val == val){
      ListNode delNode = head;
      head = delNode.next;
      delNode.next = null;
    }
    //必须要做这个判断
    if(head == null)
      return null;

    ListNode cur = head;
    //如果待删除的节点不是头节点
    while(cur.next != null){
      ListNode delNode = cur.next;
      if(delNode.val == val){
        cur.next = delNode.next;
      }else{
        cur = cur.next;
      }
    }

    return head;
  }
  //使用虚拟头节点删除
  public ListNode removeElements1(ListNode head, int val) {
    if(head == null){
      return null;
    }
    ListNode dummyNode = new ListNode(-1);
    dummyNode.next = head;
    ListNode cur = dummyNode;
    while(cur.next != null){
      ListNode delNode = cur.next;
      if(delNode.val == val){
        cur.next = delNode.next;
        //delNode = cur.next;
      }else{
        cur = delNode;
      }
    }
    ListNode retNode = dummyNode.next;
    //置为空，系统自动垃圾回收
    dummyNode.next = null;

    return retNode;
  }

  //使用递归删除链表中指定的节点
  public ListNode removeElements2(ListNode head, int val) {
    if(head == null){
      return head;
    }
    if(head.val == val){
      head.next = removeElements2(head.next,val);
      return head.next;
    }else{
      head.next = removeElements2(head.next,val);
      return head;
    }
  }
}
