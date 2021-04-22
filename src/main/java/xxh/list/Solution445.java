package xxh.list;

import java.util.Stack;

/**
 *@author xxh
 *@date 2020/5/25
 *@discription:
 * 给你两个非空链表来代表两个非负整数。
 * 数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 示例：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 */
public class Solution445 {
  //逆转单链表的方式解决
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head1 = reverseList(l1);
    ListNode head2 = reverseList(l2);
    ListNode cur1= head1;
    ListNode cur2 = head2;
    ListNode retNode = null;
    int carry = 0;
    while(cur1 != null || cur2 != null || carry > 0){
      int sum = 0;
      sum += carry;//加上进位
      sum += (cur1 == null ? 0 : cur1.val);
      sum += (cur2 == null ? 0 : cur2.val);
      carry = sum / 10;
      ListNode listNode = new ListNode(sum % 10);
      listNode.next = retNode;
      retNode = listNode;
      if(cur1 != null)
        cur1 = cur1.next;
      if(cur2 != null)
        cur2 = cur2.next;
    }
    return retNode;
  }
  //
  public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    ListNode cur1 = l1;
    ListNode cur2 = l2;
    while (cur1 != null || cur2 != null){
      if (cur1 != null) {
        stack1.push(cur1.val);
        cur1 = cur1.next;
      }
      if (cur2 != null) {
        stack2.push(cur2.val);
        cur2 = cur2.next;
      }

    }

    ListNode retNode = null;
    int carry = 0;
    //必须要有carry > 0 防止 list1 5 list2 5这种情况
    while(!stack1.isEmpty() || !stack2.isEmpty() || carry > 0){
      int sum = 0;
      sum += (stack1.isEmpty() ? 0 : stack1.pop());
      sum += (stack2.isEmpty()? 0 : stack2.pop());
      sum += carry;
      carry = sum / 10;
      ListNode listNode = new ListNode(sum % 10);
      listNode.next = retNode;
      retNode = listNode;
    }

    return retNode;
  }
  //使用递归反转链表
  ListNode reverseList(ListNode head){
    if(head == null || head.next == null){
      return head;
    }
    ListNode temp = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return temp;
  }

  //使用指针逆转单链表
  ListNode reverse(ListNode head){
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
    return tail;
  }

}
