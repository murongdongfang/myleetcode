package com.whpu.array;

import java.util.Arrays;

/**
 *@author xxh
 *@since 2020/6/15
 *@discription:
 *给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Solution75 {
  /**
   * [0...l]保存的是0，(l...r)保存的是1，[r...length-1]保存的是2
   * 双指针初始值l=0，r=nums.length
   * 遍历数组，如果当前位置为2，和--r交换，
   * 交换后如果是1继续遍历下一个元素
   * 如果是0和++l交换然后继续遍历下一个
   */
  public void sortColors(int[] nums) {

    int l = -1;
    int r = nums.length;
    //循环变量
    int i = 0;
    //注意是i<r而非i<nums.length如果是这样可能会造成数组越界
    while (i < r){
      if(nums[i] == 0){
        //如果nums[i] == 0就把nums[i]和nums[++l]交换
        l++;
        int temp = nums[i];
        nums[i] = nums[l];
        nums[l] = temp;
        i++;//注意别忘了i++
      }else if(nums[i] == 2){
        //如果nums[i] == 1就把nums[i]和nums[++r]交换
        r--;
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
        //没有i++
      }else if(nums[i] == 1){
        i++;
      }
    }

  }

  public void sortColors1(int[] nums) {
    //nums[0...zero) = 0,nums[zero...two)=1,nums[tow...arr.length-1] = 2
    int zero = 0;
    int two = nums.length - 1 ;
    int index = 0;
    //zero初始化为0，two初始化为nums.length -1 的时候index<=two
    //和上面的index < tow做对比
    while(index <= two){
      if(nums[index] == 2){
        int temp = nums[index];
        nums[index] = nums[two];
        nums[two] = temp;
        //two--但是index不变要继续判断交换后的元素是否为0
        two --;
      }else if(nums[index] == 0){
        //nums[index] == 0这个分支的逻辑就是第283题的逻辑，借用283题的优化思路减少交换的次数
//        if(index != zero){
          int temp = nums[index];
          nums[index] = nums[zero];
          nums[zero] = temp;
          //此时index和zero都需要自增
          index++;
          zero++;
//        }else{
//          index++;
//          zero++;
//        }

      }else if(nums[index] == 1){
        index++;
      }
    }

  }

  /**
   * 对比283题和75题两个题目之间的关联
   * 283题解决的是遍历一遍把所有的0依次移动到数组的末尾
   * 按照283题的方法我们只需要在遍历的时候把所有的2移动到数组的末尾，把所有的1移动数组开头即可
   */
  public static void main(String[] args) {
    int[] nums = {1,15,10,545,0,0,11,1234,0};
    int k = 0;//[0,k)中保存的都是非0的元素
    for (int index = 0; index < nums.length; ) {
      if(nums[index] == 0 ){
        //简单优化
        if(index != k){
          int temp = nums[k];
          nums[k] = nums[index];
          nums[index] = temp;
          k++;
          index++;
        }else{
          k++;
          index++;
        }
      }else{
        index++;
      }
    }
    Arrays.stream(nums).forEach(System.out::println);

  }




}
