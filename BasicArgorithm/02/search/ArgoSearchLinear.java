/**
 * 線形探索
 */
public class ArgoSearchLinear {
  public static void main(String[] args) {
    int[] data = { 30, 60, 70, 80, 90, 20};
    System.out.println(search(data, 20));
  }

  /**
   * search()
   * @param  data   int[] 検索対象の配列
   * @param  target int   検索する数字
   * @return        検索結果
   */
  public static int search(int[] data, int target) {
    int ret = -1;
    for (int i = 0; i < data.length; i++) {
      if (target == data[i]) {
        ret = i + 1;
      }
    }
    return ret;
  }
}