package xxh.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *@author HP
 *@date 2020/6/2
 *@discription:
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class Solution347 {
  public List<Integer> topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(
      (a,b)->map.get(a)-map.get(b)
    );
    //统计数字出现的频率  key:数字  value:数字出现的频率
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    }

    //遍历map，取出前10条词频
    Set<Integer> sets = map.keySet();
    for (Integer num : sets) {
      if(pq.size() < k){
        pq.add(num);
      }else if(map.get(num) > map.get(pq.peek())){
        pq.remove();
        pq.add(num);
      }

    }

    ArrayList<Integer> list = new ArrayList<>();
    while(!pq.isEmpty()){
      list.add(pq.remove());
    }


    return list;

  }
}
