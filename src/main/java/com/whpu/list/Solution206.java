package com.whpu.list;


/**
 *@author xxh
 *@date 2020/5/20
 *@discription:
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution206 {
  public ListNode reverseList1(ListNode head) {
    if(head == null){
      return head;
    }
    //工作指针
    ListNode cur = head;
    //指向工作指针前一个结点
    ListNode tail = null;
    //cur不能为空，但是pre不能为空
    while(cur != null){
      ListNode pre = cur.next;
      //指向工作指针后一个节点
      cur.next = tail;
      tail = cur;
      cur = pre;
    }
    //运行到最后cur和pre最终都为null
    return tail;
  }

  //使用递归的方式逆转单链表，本质上就是利用了栈
  public ListNode reverseList(ListNode head) {
    if(head == null || head.next == null)
      return head;
    //所有的递归调用返回的都是最后一个节点的指针
    ListNode p = reverseList(head.next);
    head.next.next = head;
    //不要忘了这一步
    head.next = null;
    return p;
  }
}
