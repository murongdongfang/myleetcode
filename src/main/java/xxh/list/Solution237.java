package xxh.list;

/**
 *@author xxh
 *@date 2020/5/23
 *@discription:
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *  
 *
 * 说明:
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 */
public class Solution237 {
  /**
   * 算法；将当前节点的后继节点的值赋值给当前节点
   * 然后删除当前节点的后继节点即可
   * @param node  要删除的节点
   */
  public void deleteNode(ListNode node) {

    //题目中要求：node合法而且node是非尾节点
    ListNode delNode = node.next;
    node.val = delNode.val;
    node.next = delNode.next;
    delNode.next = null;
    delNode = null;

  }
}
