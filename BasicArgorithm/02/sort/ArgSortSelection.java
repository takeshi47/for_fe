/**
 * selection sort
 * 2020/03/12
 */
public class ArgSortSelection {

  public static void sort(int[] data) {
    for (int i = data.length - 1; i > 0; i--) {
      int max = i;
      for (int j = i - 1; j >= 0; j--) {
        if (data[max] < data[j])
          max = j;
      }
      int tmp = data[i];
      data[i]  = data[max];
      data[max] = tmp;
      for (int element : data) System.out.print(element + ",");
      System.out.println();
    }
  }

  /**
   * [main ]
   * @param args []
   */
  public static void main(String[] args) {
    int[] data = {
      2, 5, 3, 8, 6, 9, 2, 10, 14, 1
    };

    sort(data);

    for (int element : data) System.out.print(element + ",");
  }
}