/**
 * Hash Search Open Address
 * 2020/03/15
 */
public class ArgSearchHashOpenAddress {

  /**
   * @value hash
   */
  private static final int hash = 10;

  /**
   * [search description]
   * @param  data   [description]
   * @param  target [description]
   * @return        [description]
   */
  public static int search(int[] data, int target) {

    int n = target % hash;
    int m = n;
    int flg = 0;

    while (flg == 0) {
      if (data[m] == target) {
        flg = m;
      } else {
        if (data[m] == -1) {
          flg = -1;
        } else {
          m++;
          //mが配列の要素数を超えた時、mを0にする
          if (m == data.length) {
            m = 0;
          } else if (m == n) {    //mが配列を一周したとき
            flg = -1;
          }
        }
      }
    }
      return ++flg;
  }

public static void main(String[] args) {
    int[] data = {
      -1, -1, 532, 463, 142, 2, -1, -1, 298, 308,2
    };
    System.out.println(search(data, 2));
  }
}