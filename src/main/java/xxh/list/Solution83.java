package xxh.list;

/**
 *@author xxh
 *@date 2020/5/22
 *@discription:
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Solution83 {
  //采用虚拟头节点的方式删除
  public ListNode deleteDuplicates1(ListNode head) {
    if(head == null){
      return null;
    }
    ListNode dummyHead = new ListNode(Integer.MAX_VALUE);
    dummyHead.next = head;
    ListNode cur = dummyHead;
    while(cur.next != null){
      int val = cur.val;
      ListNode delNode = cur.next;
      if(delNode.val == val){
        cur.next = delNode.next;
        delNode.next = null;
      }else {
        cur = cur.next;
      }

    }

    ListNode retNode = dummyHead.next;
    dummyHead.next = null;
    return retNode;
  }

  //采用递归的方式删除

  public ListNode deleteDuplicates2(ListNode head) {
    if(head == null || head.next == null){
      return head;
    }
    head.next = deleteDuplicates2(head.next);
    //必须要把这个判断放到回归的时候执行，否则类似于[1,1,1]用例无法通过
    if(head.val == head.next.val){
      head.next = head.next.next;
      //head = head.next; 这样写也行
    }
    return head;
  }
}
