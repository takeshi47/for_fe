/**
 * Hash Chain
 * 2020/03/15
 */
public class ArgSearchHashChain {

  public static final int hash = 5;

  public static final int[] data = {
    110, 111, 112, 223, 324, 440, 450, 427, 541, -1
  };

  public static final int[] pointers = {
    5, 8, 7, 0, 0, 6, 0, 0, 0, 0
  };

  public static int search(int target) {
    int n = target % hash;
    int flg = 0;
    int i = 1;

    do {

      System.out.println("探索ループ" + i++ + "回目");

      System.out.println("n:" + n);
      System.out.println("data[" + n + "]:" + data[n] + ", target:" + target);

      if (data[n] == target) {
        return n;
      } else {
        n = pointers[n];
      }
    } while (n != 0 && flg == 0);

    return flg;
  }

  public static void main(String[] args) {
    System.out.println(search(541));
  }
}