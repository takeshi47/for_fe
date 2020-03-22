/**
 * Arg H27 Autumn
 * 2020/03/22
 */
public class H27Spring {

  static int change ;

  /**
   * [select ]
   * @param  data
   * @param  n
   * @param  k
   * @return data[k]
   */
  public static int select(int[] data, int n, int k) {

    int top = 1;
    int last = n - 1;
    int pivot = data[k];

    while (top < last) {

      pivot = data[k];

      System.out.println(pivot);
      int i = top;
      int j = last;

      while (true) {

        while (data[i] < pivot)i++;
        while (data[j] > pivot)j--;

        if (i >= j) break;

        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;

        i++;
        j--;

        for (int element : data)System.out.print(element  + ",");
        System.out.println();
      }

      if (i <= k) top = j + 1;
      if (j >= k) last = i - 1;
    }
    return data[k];
  }

  /**
   * main()
   * @param args strng
   */
  public static void main(String[] args) {

    int[] data = { 0, 1, 3, 2, 4, 2, 2, 2};
    final int k = 3;

    System.out.println(k + "番目に小さい数字は" + select(data, data.length, k));
  }
}