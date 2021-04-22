package xxh.sort;

/**
 *@author xxh
 *@since 2020/10/11
 *@discription:选择排序
 * 稳定排序
 */
public class SelectionSort {
  public static void main(String[] args) {
    int[] arr = {1,23,4,233,53,5,778,9,10};
    selectionSort2(arr);
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
  public static void selectionSort(int[] arr){
    // n个元素只需要排n-1轮即可，n-1个元素有序，最后一个元素一定有序，所以只需要>无需>=
    for (int end = arr.length - 1; end > 0; end--) {
      // 不能放到外边
      int maxIndex = 0;
      // 每次选择最大值都需要n，可以用堆来优化此时nlogn
      for (int begin = 1; begin <= end; begin++) {
        if (arr[maxIndex] <= arr[begin]){
          maxIndex = begin;
        }
      }
      int temp = arr[maxIndex];
      arr[maxIndex] = arr[end];
      arr[end] = temp;
    }
  }
  public static void selectionSort2(int[] arr){
    // n个元素只需要排n-1轮即可，n-1个元素有序，最后一个元素一定有序，所以只需要<无需<=
    for (int i = 0; i < arr.length - 1; i++) {
      // 不能放到外边
      int minIndex = i;
      // 每次选择最大值都需要n，可以用堆来优化此时nlogn
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[minIndex] > arr[j]){
          minIndex = j;
        }
      }
      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
  }
}
