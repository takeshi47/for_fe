/**
 * Bubble Sort
 * 2020/03/11
 */
public class ArgBubbleSort {

  /**
   * [sort ]
   * @param data []
   */
  public static void sort(int[] data) {

    for (int i = data.length - 1; i > 0; i--) {
      for (int element : data) System.out.print(element + ",");

      for (int j = 0; j < i; j++) {
        if (data[j] > data[j + 1]) {
          int tmp = data[j];
          data[j] = data[j + 1];
          data[j + 1] = tmp;
        }
      }
      System.out.println();
    }
  }

  /**
   * [main ]
   * @param args []
   */
  public static void main(String[] args) {
    int[] data = {
      3, 4, 2, 7, 2, 9, 8, 2, 10
    };

    sort(data);

    for (int element : data) System.out.print(element + ",");
  }
}