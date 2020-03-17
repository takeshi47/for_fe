/**
 * Insert Sort 2
 * 2020/03/01
 */
public class ArgSortInsert_02 {

  public static int[] sort(int[] data) {
    int n = -1;

    for (int element : data) {
      int i = 0;
      //挿入位置を探すループ
      while (i <= n && data[i] > element ) {
        i++;
      }
      System.out.println("element:" + element + ", data[" + i + "]:" +data[i]);

      //見つけた挿入位置まで配列をひとつずつ後ろにずらす。
      int j = n;
      while (j >= i) {
        data[j + 1] = data[j];
        j--;
      }

      for (int a : data) System.out.print(a + ", ");
      System.out.println();
      data[i] = element;
      n++;
    }
    return data;
  }

  /**
   * [main ]
   * @param args
   */
  public static void main(String[] args) {
    int[] data = {
      14, 5, 7, 3, 78, 23
    };

      for (int element : sort(data)) {
      System.out.print(element + " ");
    }
  }
}