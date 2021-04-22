package xxh.list;

/**
 *@author xxh
 *@date 2020/5/23
 *@discription:
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
public class Solution19 {
  /**
   * 算法思想：双指针：头节点和正数第n个节点的间距等于尾节点和倒数第n个节点的距离
   * 使用双指针顺序查找链表找到头节点和正数n节点距离，同时移动双指针，直到一个指针为尾节点，另一个就是待删除元素
   */
  public ListNode removeNthFromEnd1(ListNode head, int n) {
    if(head == null){
      return head;
    }
    //涉及到删除链表中的节点，使用虚拟头节点省事
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode p = dummyHead;
    ListNode q = dummyHead;
    /**
     * 虚拟头节点到正树n+1节点距离等于null（尾节点下一个节点）到倒数n+1节点的距离
     */
    for (int i = 0; i < n+1; i++) {
      p = p.next;
    }
    //p移动到null（尾节点下一个节点），q移动到待删除的节点的前一个节点
    while (p != null){
      p = p.next;
      q = q.next;
    }
    //此时q指向的节点就是待删除节点的前一个节点
    ListNode delNode = q.next;
    q.next = delNode.next;
    delNode.next = null;
    delNode = null;


    ListNode retNode = dummyHead.next;
    dummyHead.next = null;
    dummyHead = null;

    return retNode;
  }

  private int cur = 0;
  //采用递归的方式
  public ListNode removeNthFromEnd(ListNode head, int n){
    if(head == null){
      return head;
    }
    head.next = removeNthFromEnd(head.next,n);
    cur++;
    //该节点就是待删除的节点
    if(cur == n){
      //此时没有前驱指针，无法通过head.next = head.next.next;
      //但是我们可以返回这个节点的后继节点
      head = head.next;
    }

    return head;
  }

  //这种递归无法通过用例[1] n=1  输出[1] 正确[]
  public int removeNode(ListNode head,int n){
    if(head == null){
      return 0;
    }else {
      int temp = removeNode(head.next,n) + 1;
      if(temp == n){
        head.next = head.next.next;
      }
      return temp;
    }

  }
}
