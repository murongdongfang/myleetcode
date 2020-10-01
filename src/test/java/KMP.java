public class KMP {

  public static void main(String[] args) {
    String s = "acbbabaacbcacccabca";
    String t = "baac";
    int index = index(s, t, 0);
    System.out.println(index);
  }
  public int kmp(){

    return 0;
  }
  /**
   * 模式串匹配的暴力算法
   * @param s
   * @param t
   * @param pos
   * @return
   */
  public static int index(String s, String t, int pos){
    char[] source = s.toCharArray();
    char[] target = t.toCharArray();
    int i = pos, j = 0;
    while (i < source.length && j < target.length){
      if (source[i] == target[j]){
        i++;
        j++;
      }else{
        i = i - j + 1;
        j = 0;
      }
      if (j >= target.length - 1){
        return i - target.length + 1;
      }

    }
    return 0;
  }

}
