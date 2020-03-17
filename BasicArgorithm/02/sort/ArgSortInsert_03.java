/**
 * Insert Sort 3
 * 2020/03/04
 */
public class ArgSortInsert_03 {

  public static void sort(int[] data) {
    int n = -1;

    for (int element:data) {
      int i = 0;
      while (i <= n && data[i] > element) {
        i++;
      }
      int j = n;
      while (j >= i) {
        data[j + 1] = data[j];
        j--;
      }
      data[i] = element;
      n++;
    }
  }

  public static void main(String[] args) {
    int[] data = {
      1, 3, 2, 6,4, 8, 78, 5, 5
    };

    sort(data);

    for (int element: data) System.out.print(element + ", ");
  }
}
