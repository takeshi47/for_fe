/**
 * Search Binary
 * 2020/03/01
 */
public class ArgSearchBinary {

  public static int sort(int[] data, int target) {
    int ret = -1;
    int min = 1;
    int max = data.length - 1;

    System.out.println("max : " + max);

    while (min < max) {
      int mid = (min + max) / 2;

      System.out.println("mid : " + mid + ", data[mid] : " + data[mid]);

      if (data[mid] == target) {
        return ret = mid + 1;
      } else if (target < data[mid]) {
        max = mid;
      } else {
        min = mid + 1;
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    int[] data = {
      0,6, 14, 23, 67, 79, 89, 121
    };

    System.out.println(sort(data, 79) + "番目");
  }
}