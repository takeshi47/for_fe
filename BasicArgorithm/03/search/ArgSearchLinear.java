/**
 * search linear
 * 2020/03/15
 */
public class ArgSearchLinear {

  public static int search(int data[], int target) {

    int ret = -1;

    for (int i = 0; i < data.length; i++) {
      if (data[i] == target) {
        ret = i;
      }
    }
    return ret + 1;
  }

  public static void main(String[] args) {
    int[] data = {
      12, 34, 67, 8, 4, 5, 34, 56, 7, 9
    };

    System.out.println(search(data, 56));
    System.out.println(search(data, 12));
    System.out.println(search(data, 100));
  }
}