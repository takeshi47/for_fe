/**
  * 挿入ソート(降順)
  * 2020/01/27 作成
  */
public class ArgoSortInsert2 {
  public static int[] sort(int[] data) {
    int n = -1;
    int[] m = { -1 , -1, -1, -1};

    for (int element : data) {

      System.out.println("【element:" + element + "】");

      int i = 0;
      //要素の挿入位置を探すループ
      while (i <= n && m[i] > element) {
        System.out.println("一個目のループ");
        System.out.println("element:" + element + " < m[i]:" + m[i]);
        i++;
      }
      int j = n;

      System.out.println("n:" + n + ", i:" + i + ", j:" + j);
      //上記で見つけた挿入位置まで入れ替え処理を行う。
      while (j >= i) {
        System.out.println("2個目のループ");
        m[j + 1] = m[j];
        j --;
        for (int e : m) {
          System.out.print(e + " ");
        }
        System.out.println();
      }
      m[i] = element;
      n++;

      for (int e : m) {
        System.out.print(e + " ");
      }
      System.out.println();
    }
    return m;
  }
  /**
   * main
   */
  public static void main(String[] args) {
    int[] data = {
      14, 6, 67, 23
    };
    for (int element : sort(data)) {
      System.out.print(element + " ");
    }
  }
}