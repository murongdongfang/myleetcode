import java.util.Arrays;

/**
 *@author xxh
 *@date 2020/5/23
 *@discription: leetcode
 */
public class Test {
  public static void main(String[] args) {
    int[] arr = {12,34,2,545,64,5,23,344,22,1234};
    quickSort(arr,0,arr.length - 1);
    Arrays.stream(arr).forEach(x -> System.out.print(x+","));
    System.out.println();
  }
  public static void quickSort(int[] arr,int low,int high){
    if(low < high){
      int pos = partition(arr, low, high);
      partition(arr,low,pos - 1);
      partition(arr,pos+1,high);
    }

  }
  public static int partition(int[] arr,int low,int high){
    int pivot = arr[low];
    while(low < high){
      while(low<high && arr[high] >= pivot){
        high--;
      }
        arr[low] = arr[high];

      while(low<high && arr[low] <= pivot){
        low++;
      }
        arr[high] = arr[low];

    }
    arr[low] = pivot;
    Arrays.stream(arr).forEach(x -> System.out.print(x+","));
    System.out.println();
    return low;
  }
}
