package com.whpu.list;

import java.util.Stack;

/**
 *@author xxh
 *@date 2020/5/25
 *@discription:
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Solution234 {
  //采用辅助栈进行比较
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode slow = head;
    ListNode fast = head;
    Stack<Integer> s = new Stack<Integer>();
    while (fast.next != null && fast.next.next != null) {
      s.push(slow.val);
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast.next != null) {
      s.push(slow.val);
    }
    slow = slow.next;
    while (slow != null) {
      if (s.pop() != slow.val) {
        return false;
      }
      slow = slow.next;
    }
    return true;
  }
  //反转链表不适用额外空间
  public boolean isPalindrome1(ListNode head) {
    if(head == null || head.next == null){
      return true;
    }

    ListNode fast = head;
    ListNode slow = head;
    //使用快慢指针找到中点，快指针速度是满指针两倍，快指针到终点，满指针到中点
    while (fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }

    //将中点slow到尾节点的链表反转
    //1->2->3<-2<-1  slow指向尾巴，fast指向头
    //1->2->3->3<-2<-1
    ListNode p = reverse(slow);//尾
    ListNode q = head;//头
    boolean flag = true;
    while(p.next != null && q.next != null){
      if(p.val != q.val){
        return false;
      }
      p = p.next;
      q = q.next;
    }

    //还原链表
    reverse(slow);

    return p.val == q.val;
  }
  public ListNode reverse(ListNode head){
    if(head == null || head.next == null){
      return head;
    }
    ListNode cur = head;
    ListNode tail = null;
    while(cur != null){
      ListNode pre = cur.next;
      cur.next = tail;
      tail = cur;
      cur = pre;
    }

    //最终cur和pre都为null，最终指向新的头节点的是tail
    return tail;
  }
}
