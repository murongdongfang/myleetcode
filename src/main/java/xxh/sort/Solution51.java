package xxh.sort;

import java.util.Arrays;

/**
 *@author xxh
 *@since 2021/2/3
 *@discription:
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 *
 * 315（和本题一样）,327,493
 */
public class Solution51 {
  private int res = 0;

  public static void main(String[] args) {
    int[] nums = {7, 5, 6, 4};
    new Solution51().reversePairs(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i]+", ");
    }
  }
  public int reversePairs(int[] nums) {
    if (nums == null || nums.length <= 0){
      return res;
    }
    int[] copyArr = Arrays.copyOfRange(nums, 0, nums.length);
    sort(nums, copyArr, 0, nums.length - 1);
    return res;
  }
  public void sort(int[] arr, int[] copyArr, int l, int r){
    if (l >= r){
      return;
    }
    int mid = (l + r) >>> 2;
    sort(arr, copyArr, l, mid);
    sort(arr, copyArr, mid + 1, r);
    if (arr[mid] > arr[mid + 1]){
      merge(arr, copyArr, l, mid, r);
    }
  }

  /**
   * 将有序数组中的两个有序部分arr[l,mid]和arr[mid+1,r]和并成一个有序部分
   */
  private void merge(int[] arr, int[] copyArr, int l, int mid, int r) {
    System.arraycopy(arr, l, copyArr, l, r - l + 1);
    int i = l, j = mid + 1;
    for (int k = l; k <= r; k++) {
      //arr[l,mid]部分先归完，只需要依次把arr[mid+1,r]插入归并后的数组即可
      if (i > mid){
        arr[k] = copyArr[j];
        j++;
      }else if (j > r){
        arr[k] = copyArr[i];
        i++;
      }else if (copyArr[i] > copyArr[j]){
        arr[k] = copyArr[j];
        j++;
        /**
         *        i                  j
         * arr[l...mid] 有序arr[mid+1...r]
         * 若arr[j] < arr[i]则arr[i,mid]范围内的所有元素都和元素arr[j]形成逆序对
         */
        res += (mid - i + 1);
      }else{
        // 比较copyArr[i]和copyArr[j]，将较小者归并到新数组中
        arr[k] = copyArr[i];
        i++;
      }
    }
  }
}
