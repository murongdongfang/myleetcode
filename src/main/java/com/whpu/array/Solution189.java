package com.whpu.array;

/**
 *@author xxh
 *@since 2021/4/6
 *@discription: https://leetcode-cn.com/problems/rotate-array/
 */
/*
  给定一个数组，将数组中的元素向右移动位置，其中是非负数。

进阶：

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
示例 1:
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例2:
输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
提示：
1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
*/
public class Solution189 {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7};
    new Solution189().reverse(arr, 0, arr.length - 1);
    System.out.println();
  }
  public void rotate(int[] nums, int k) {
    int n = nums.length;
    // 注意：k是可以大于nums.length的
    k %= n;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
  }

  // 将nums[left..right]数组逆置
  public void reverse(int[] nums, int left, int right){
    if (left < 0 || right >= nums.length){
      return;
    }
    while (left < right){
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      left ++;
      right --;
    }
  }
  // 将nums[left...right]部分的数组逆置
  void reverse2(int[] arr, int left, int right){
    int mid = (right + left) / 2 - left;
    for (int i = 0; i <= mid; i++) {
      int temp = arr[left + i];
      arr[left + i] = arr[right - i];
      arr[right - i] = temp;
    }
  }
}
