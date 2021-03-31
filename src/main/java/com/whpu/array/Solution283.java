package com.whpu.array;

/**
 *@author xxh
 *@since 2020/6/14
 *@discription:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Solution283 {
  /**
   * k=0，[0,k)中保存非0元素
   * i指针遍历数组，如果arr[i]为0 交换arr[i]和arr[k]，k自增
   * 注意：只有交换arr[i]和arr[k]的时候k自增，i在任何情况下都自增
   */
  public static void moveZeroes(int[] nums) {
    int k = 0;//[0,k)中保存的都是非0的元素
    for (int i = 0; i < nums.length; i++) {
      if(nums[i] != 0 ){
        //简单优化
        if(i != k){
          int temp = nums[k];
          nums[k++] = nums[i];
          nums[i] = temp;
        }else{
          k++;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = {0,1,0,3,12};
    moveZeroes(nums);
  }
}
