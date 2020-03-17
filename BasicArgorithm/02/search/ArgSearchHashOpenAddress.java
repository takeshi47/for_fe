/**
 * Hash Search OpenAddress
 * 2020/03/01
 */
public class ArgSearchHashOpenAddress {

  public static int search(int[] data, int target) {
    int n = (target % 10);
    int m = n;
    int flg = 0;

    System.out.println("n:" + n);

    while (flg == 0) {
      if (data[m] == target) {
        flg = m;
      } else {
        if (data[m] == -1) {
          flg = -1;
        } else {
          m++;
          System.out.println("m:" + m);
          if (m == data.length) {
            m = 0;
          } else if (m == n) {
            flg = -1;
          }
        }
      }
    }
    return flg + 1;
  }

  public static void main(String[] args) {
    int[] data = {
      -1, -1, 532, 463, 142, 2, -1, -1, 298, 308,2
    };
    System.out.println(search(data, 2));
  }
}