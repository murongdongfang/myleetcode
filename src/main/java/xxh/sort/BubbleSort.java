package xxh.sort;

/**
 *@author xxh
 *@since 2020/10/11
 *@discription:
 * 冒泡排序
 * 时间复杂度n2
 * 稳定
 */
public class BubbleSort {
  public static void main(String[] args) {
    int[] arr = {1,23,4,233,53,5,778,9,10};
    bubbleSort(arr);
    printArr(arr);
  }

  public static void printArr(int[] arr){
    if (arr == null){
      return;
    }
    for (int i : arr) {
      System.out.print(i + ", ");
    }
  }

  /**
   * 冒泡排序的两个优化优化
   * 1.如果本身是有序的就提前终止排序
   * 2.如果某一趟排序过程中没有发生数据交换，说明这个数组已经有序，提前终止排序
   * @param arr
   */
  public static void bubbleSort(int[] arr){
    // n个元素只需要排n-1轮即可，n-1个元素有序，最后一个元素一定有序，所以只需要<无需<=
    for (int i = 0; i < arr.length - 1; i++) {
      boolean flag = true;
      // 第i轮就有i个元素已经排好序了
      for (int j = 0; j < arr.length - i - 1; j++) {
        // 如果判断条件改成>=那么这个冒泡排序就是不稳定的
        if (arr[j] > arr[j + 1]){
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
          flag = false;
        }
      }
      // 一旦是某一趟排序没有发生交换就说明数组已经是有序的了
      if (flag){
        return;
      }
    }
  }

}
