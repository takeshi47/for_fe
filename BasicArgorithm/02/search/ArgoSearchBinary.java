/**
 * 二分探索
 * 2020/01/22
 */
public class ArgoSearchBinary {
  public static void main(String[] args) {
    int data[] = {
      10, 30, 40, 60, 80, 90, 110, 140, 170, 190, 210, 260
    };
    System.out.println(search(data, 140));
  }
  /**
   * 二分探索する
   * search()
   * @param  data   int
   * @param  target int
   * @return        探索結果
   */
  public static int search(int[] data, int target) {
    int ret = -1;
    int low = 1;
    int high = data.length;
    int i = 0;

    while (i == 0 && low <= high) {
      //配列の要素番号の中央値を出す
      int mid = (low + high) / 2;
      if (data[mid] == target) {    //配列の中央と検索対象が等しいとき
        return mid;                //その時の中央値を返す。
      } else {
        if (target < data[mid]) {
          high = mid--;
        } else {
          low = mid++;
        }
      }
    }
    return ret ;          //該当しない場合-1を返す。
  }
}