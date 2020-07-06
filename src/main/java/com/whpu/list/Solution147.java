package com.whpu.list;

/**
 *@author HP
 *@date 2020/5/26
 *@discription:
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Solution147 {
  //效率高
  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;
//   可以简化为 ListNode dummy = new ListNode(0),pre;
    dummy.next = head;

    while(head != null && head.next != null) {
      //寻找待插入节点，顺着单链表前后两两比较，直到找到当前节点大于他的后置节点，后置节点就是待插入节点
      if(head.val <= head.next.val) {
        head = head.next;
        continue;
      }
      pre = dummy;

      //插入排序必须要找到第一个比待插入节点大节点的前置节点
      while (pre.next.val < head.next.val) {
        pre = pre.next;
      }

      //将待插入节点删除，并保留当前待插入节点
      ListNode curr = head.next;
      head.next = curr.next;
      //将待插入合适位置
      curr.next = pre.next;
      pre.next = curr;
    }
    return dummy.next;
  }
  //简单，粗暴
  public ListNode insertionSortList1(ListNode head) {
    if(head == null || head.next == null){
      return head;
    }
    ListNode dummyHead = new ListNode(0);

    while(head != null){
      ListNode p = dummyHead;
      ListNode q = head;
      while(p.next != null && p.next.val < head.val){
        p = p.next;
      }
      head = head.next;
      q.next = p.next;
      p.next = q;

    }

    return dummyHead.next;
  }
}
