/**
 * ハッシュ探索(オープンアドレス法)
 * 2020/01/28 作成
 */
public class ArgoSearchHashOpenAddress {
	/**
   * search()
   * @param  data
   * @param  target
   * @return
   */
  public static int search(int[] data , int target) {
		int n = (target % 10);
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
  /**
   * main
   */
  public static void main(String[] args) {
    int[] data = {
      2, -1, 532, 463, 142, -1, -1, -1, 298, 308
    };
    System.out.println(search(data, 2));
  }
}