package com.whpu.list;

/**
 *@author xxh
 *@date 2020/5/25
 *@discription:
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 * 示例1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class Solution82 {
  private int res;

  /**
   * 非递归写法
   * 定义一个 dummy 头结点，链接上原链表，cur 指向原链表头部
   * ① 当前结点value ！= 当前结点的下一结点value。那么让pre指针来到当前结点，这样就链接了前一结点和当前结点。然后当前结点移至下一结点
   * ② 当前结点value == 当前结点的下一结点value。那么就让 cur 一直往下走直到 当前结点value ！= 当前结点的下一结点value，然后此时是不能动 pre 指针的，要避免后面还有重复的，所以让 pre->next = cur->next。然后当前结点移至下一结点。
   * 循环结束的条件结合例子即可，如[1,1]
   */
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null){
      return head;
    }
    // 未赋值，dummyHead的value默认0，如果链表都节点是0就会把头节点也删除
    ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
    dummyHead.next = head;
    ListNode cur = dummyHead,pre = dummyHead;
    // 必须要有cur!=null 否则空指针异常eg：[1,1]
    while (cur != null && cur.next != null){
      if (cur.val == cur.next.val){
        while (cur.next != null && cur.next.val == cur.val){
          cur = cur.next;
        }
        pre.next = cur.next;
        // 此时cur可能是null，如果最外层循环没有cur!=null就会造成空指针异常
        cur = cur.next;
      }else{
        pre = cur;
        cur = cur.next;
      }
    }

    return dummyHead.next;
  }
  // 正确的递归写法
  public ListNode deleteDuplicates3(ListNode head) {
    if (head == null || head.next == null){
      return head;
    }
    if (head.val == head.next.val){
      while (head.next != null && head.val == head.next.val){
        head = head.next;
      }
      head = deleteDuplicates3(head.next);
    }else {
      head.next = deleteDuplicates3(head.next);
    }
    return head;
  }
    //采用递归的方法
  public ListNode deleteDuplicates2(ListNode head) {

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
