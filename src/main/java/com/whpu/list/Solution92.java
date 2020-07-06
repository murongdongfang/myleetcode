package com.whpu.list;

/**
 *@author xxh
 *@date 2020/5/20
 *@discription:
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Solution92 {
  private ListNode last = null;
  //采用递归的方式求解，首先需要理解206题中的递归逆转单链表的思路
  public ListNode reverseBetween(ListNode head, int m, int n) {
    //先采用递归的方式找到第m个节点，
    if(m == 1){
      //返回的temp就是原来链表中第n个节点的指针
      ListNode temp = reverseList(head,n);
      //逆转之后将原来链表中第m个节点执行原来链表中的第n+1个节点
      head.next = last;
      //此时[m,n]阶段的链表已经逆转好了，只需要把节点n的指针返回
      return temp;
    }
    //原链表中第[1,m-1]顺序连接，第m-1个节点指向原来的第n个节点
    head.next = reverseBetween(head.next,m-1,n-1);
    return head;
  }

  //递归逆转单链表，206题中的递归逆转单链表思路
  public ListNode reverseList(ListNode head,int n){
    if(n == 1){
      //last：原来第n+1个节点的指针
      last = head.next;
      return head;
    }

    //tail是原链表的尾节点也是整个链表逆转之后的头节点，所以要将其返回
    ListNode tail = reverseList(head.next,n-1);
    head.next.next = head;
    head.next = null;

    return tail;
  }
}
