/**
 * Bubble Sort
 * 2020/0316
 */
public class ArgBubbleSort {

  public static void sort(int[] data) {

    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data.length - i - 1; j++) {

        System.out.println("i:" + i + ", j:" + j);
        System.out.println("data[j-1]:" + data[j] + ", data[j + 1]:" + data[j]);
        if (data[j + 1] < data[j]) {
          int tmp = data[j];
          data[j] = data[j + 1];
          data[j + 1] = tmp;
        }
        for (int element : data ) System.out.print(element + ",");
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    int[] data = {2, 4, 3, 5, 6, 1};

    sort(data);
    for (int element : data ) System.out.print(element + ",");
  }
}