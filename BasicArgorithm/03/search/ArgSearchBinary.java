/**
 * Binary search
 * 2020/03/15
 */
public class ArgSearchBinary {

  /**
   * @value
   */
  private static final int[] data = {
    10, 11, 12, 14, 16, 21, 32, 47, 56, 78, 90
  };

  /**
   * search
   * @param int target [description]
   */
  public static  int search(int target) {
    int ret = -1;
    int low = 1;
    int high = data.length;

    while (low <= high) {
      int mid = (low + high) / 2;
      if (data[mid] == target) {
        return mid;
      } else {
        if (target < data[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }
    return ret;
  }

  public static void main(String[] args) {

    System.out.println(search(32));
  }
}