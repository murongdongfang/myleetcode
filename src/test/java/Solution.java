import com.whpu.list.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@author xxh
 *@date 2020/5/24
 *@discription:
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Solution {
  private List<List<Integer>> res = new ArrayList<>();
  public void backTrance(int[] candidates, int target,int index,List<Integer> list){
    if (target == 0){
      res.add(new ArrayList<>(list));
    }
    for (int start = index; start < candidates.length; start++) {
      if(target-candidates[start]<0){
        return;
      }
      if(start > index && candidates[start] == candidates[start-1]){
        continue;
      }
      list.add(candidates[start]);
      backTrance(candidates,target-candidates[start],start+1,list);
      list.remove(list.size()-1);
    }

  }
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if(candidates == null || candidates.length == 0){
      return res;
    }
    //方便后来的去重
    Arrays.sort(candidates);
    backTrance(candidates,target,0,new ArrayList<>());

    return res;
  }

  public ListNode insertionSortList(ListNode head) {
    if(head == null){
      return head;
    }

    ListNode dymmyHead = new ListNode(0);
    dymmyHead.next = head;
    while(head != null && head.next != null){
      //直到head.val > head.next.val
      if(head.val < head.next.val){
        head = head.next;
        continue;
      }
      ListNode p = dymmyHead;
      while(p.next.val < head.next.val){
        p = p.next;
      }
      ListNode cur = head.next;
      head.next = head.next.next;
      cur.next = p.next;
      p.next = cur;

    }
    return dymmyHead.next;
  }
}
