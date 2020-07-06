package com.whpu.list;

/**
 *@author xxh
 *@date 2020/5/22
 *@discription:
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 算法：设置两个虚拟头节点dummyHead1和dummyHead2
 * 依次遍历当前链表如果当前节点val<x把这个节点挂在dummyHead1上，反之挂在dummyHead2上
 * 最后合并当前dummyHead1和dummyHead2即可
 */
public class Solution86 {
  public ListNode partition(ListNode head, int x) {
    if(head == null)
      return head;
    ListNode dummyHead1 = new ListNode(0);
    ListNode tail1 = dummyHead1;
    ListNode dummyHead2 = new ListNode(0);
    ListNode tail2 = dummyHead2;

    ListNode cur = head;
    while(cur != null){
      //把小于x的节点挂在dummyHead上
      if(cur.val < x){
        tail1.next = cur;
        tail1 = cur;
        cur = cur.next;
        tail1.next = null;
      }else {
        tail2.next = cur;
        tail2 = cur;
        cur = cur.next;
        tail2.next = null;
      }
    }

    //将dummyHead1和dummyHead2合并为一个链表
    tail1.next = dummyHead2.next;
    //释放两个虚拟头节点
    ListNode retNode = dummyHead1.next;
    dummyHead1.next = null;
    dummyHead2.next = null;
    dummyHead1 = null;
    dummyHead2 = null;

    return retNode;
  }
}
