/**
 * Insert sort asc
 * 2020/03/15
 */
public class ArgSortInsert {

  public static void sort(int[] data) {

    int n = -1;  //n番目までの配列を整列済みとする

    for (int element : data) {
      int i = 0;

      //挿入位置を探す
      while (i <= n && data[i] < element) {
        i++;
        System.out.println("element:" + element + ", data[" + i + "]:" + data[i]);
      }
      System.out.println(element + "を" + (i + 1) + "番目に挿入する");

      //見つけた挿入位置まで配列をずらす
      for (int j = n; j >= i; j--) {
        data[j + 1] = data[j];
      }

      data[i] = element;
      for (int a : data) System.out.print(a + ",");
      System.out.println();
      n++;
      System.out.println((n) + "個目までを整列済みとする\n");
    }
  }

  public static void main(String[] args) {
    int[] data = {
      14, 14, 7, 3, 78, 14, 23, 3
    };
    sort(data);
    for (int element : data) {
      System.out.print(element + " ");
    }
  }
}