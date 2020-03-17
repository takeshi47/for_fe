/**
 * 二分探索
 * 2020/01/28 作成
 */
public class ArgoSearchBinary {
  /**
   * sort()
   * @param  data
   * @param  target
   * @return
   */
  public static int sort(int[] data, int target) {
    int ret = -1;
    int min = 1;
    int max = data.length -1;

    System.out.println("max:" + max);

    while (min < max) {
      int mid = (min + max) / 2;

      System.out.println("mid:" + mid + ",data[mid]:" + data[mid]);

      if (data[mid] == target) {
        return mid + 1;
      } else if (target < data[mid]) {
        max = mid;
        System.out.println(data[mid]);
        System.out.println("max:" + max);
      } else {
        min = mid + 1;
      System.out.println("min:" + min);
      }
    }
    return ret;
  }
  /**
   * main
   */
  public static void main(String[] args) {
    int[] data = {
      0,6, 14, 23, 67, 79, 89, 121,79
    };

    System.out.println(sort(data, 79));
  }
}