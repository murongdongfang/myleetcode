package com.whpu.list;

/**
 *@author xxh
 *@date 2020/5/25
 *@discription:
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Solution82 {
  private int res;
  //采用递归的方法
  public ListNode deleteDuplicates(ListNode head) {

    if(head == null){
      return head;
    }
    backTrance(head.next);
    return head;
  }

  //这种递归不行，只能删除偶数个重复的元素[1111]可以正确，但是[111]不正确
  public ListNode backTrance(ListNode head){
    res = head.val;
    if(head == null || head.next == null){
      return head;
    }

    head.next = backTrance(head.next);
    if(head.val == res || head.val == head.next.val){
      //删除后边的重复元素
//      head.next = head.next.next;
      head.val = res;
      //删除本身
      head = head.next;
    }


    return head;
  }
}
