/**
 * 選択ソートを行う
 * 2020/01/27 作成
 */
public class ArgoSortSelection {
  /**
   * sort()
   * @param data 並べ替える配列
   */
	public static void sort(int[] data) {
    //配列の中から最大値を順番に見つけ並べ替える
		for (int i = data.length -1; i > 0; i--) {
      int max = i;
      for (int j = i - 1; j >= 0 ;j-- ) {
        if (data[max] < data[j]) {
          max = j;
        }
      }
      int tmp = data[i];
      data[i] = data[max];
      data[max] = tmp;
		}
	}

  public static void main(String[] args) {
    int[] data = {
      14, 67, 23, 6
    };
    sort(data);

    for (int element: data ) {
      System.out.print(element + ":");
    }
  }
}