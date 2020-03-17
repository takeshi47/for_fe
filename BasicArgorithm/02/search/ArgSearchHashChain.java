/**
 * Hash Chain
 * 2020/03/01
 */
public class ArgSearchHashChain {

  public static final int[] hash = {
    110, 111, 112, 113, 114, 120, 130 , 117, 331, -1
  };
  public static final int[] point = {
    5 , 8, 7, 0, 0, 6, 0, 0, 0, 0
  };

  public static int search(int target) {
    int d = target;
    int n = d % 5;
    int flg = 0;
    int i = 1;

    do {
      System.out.println("探索ループ" + i++ + "回目");

      System.out.println("n:" + n);
      System.out.println("hash[" + n + "]:" + hash[n] + ", d:" + d);

      if (hash[n] == d) {
        flg = n;
        return flg + 1;
      } else {
        System.out.println("point[" + n + "]:" + point[n]);
        n = point[n];
      }
    } while (n != 0 && flg == 0);
    return flg;
  }

  public static void main(String[] args) {
    System.out.println(search(331));
  }
}