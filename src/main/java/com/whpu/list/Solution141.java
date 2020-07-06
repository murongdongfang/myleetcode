package com.whpu.list;

import java.util.HashSet;
import java.util.Set;

/**
 *@author HP
 *@date 2020/5/25
 *@discription:
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 */
public class Solution141 {
  //使用快慢指针判断链表中是否有环
  public boolean hasCycle(ListNode head){
    if(head == null || head.next == null){
      return false;
    }
    ListNode fast = head;
    ListNode slow = head;
    while(fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
      if(fast == slow){
        return true;
      }
    }
    //当fast为null说明链表中不存在环
    return false;
  }
  //使用Hashset判断是链表中是否有环
  public boolean hasCycle1(ListNode head) {
    Set<ListNode> nodesSeen = new HashSet<>();
    while (head != null) {
      if (nodesSeen.contains(head)) {
        return true;
      } else {
        nodesSeen.add(head);
      }
      head = head.next;
    }
    return false;
  }
}
