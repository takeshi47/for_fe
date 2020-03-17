/**
 * selection sort
 * 2020/03/16
 */
public class ArgSortSelection {

  /**
   * sort()
   * @param data [description]
   */
  public static void sort(int[] data) {

    for (int i = 0; i < data.length; i++) {
      int min = i;
      //最小値を見つけるループ
      for (int j = i + 1; j < data.length; j++) {
        System.out.println("i:" + i + ", min:" + min + ", j:" + j  );
        System.out.println("data[min]:" + data[min] + ", data[j]:" + data[j]);
        if (data[min] > data[j]) {
          min = j;
        }
      }
      int tmp = data[i];
      data[i] = data[min];
      data[min] = tmp;

      for (int element : data) System.out.print(element + ",");
      System.out.println("\n");
    }
  }
  /**
   * [main ]
   * @param args []
   */
  public static void main(String[] args) {
    int[] data = {
      1, 4, 2, 5, 3
    };

    sort(data);

    for (int element : data) System.out.print(element + ",");
  }
}