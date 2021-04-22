package xxh.array;

/**
 *@author xxh
 *@since 2021/4/6
 *@discription: 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */

public class Solution88 {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m-1;
    int j = n-1;
    int k = m+n-1;
    while (i >= 0 && j >= 0) {
      if(nums1[i] >= nums2[j]) {
        nums1[k--] = nums1[i--];
      }else {
        nums1[k--] = nums2[j--];
      }
    }
    while (i >= 0) {
      nums1[k--] = nums1[i--];
    }
    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }
  }
}
