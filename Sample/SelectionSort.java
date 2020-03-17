public class SelectionSort {
  /*
   *  Sort()
   */
  public static void sort(int[] array) {
    for (int i = 0; i < array.length ; i++ ) {
      //indexを保存しておく
      int minIndex = i;
      for (int j = i + 1; j < array.length ; j++ ) {
        //保存した配列番号の要素よりarray[j]が小さい時,
        //配列番号を上書き保存する。
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
        int tmp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = tmp;
      }
    }
  }

  /*
   *    メイン
   */
  public static void main(String[] args) {
    int[] array = {9, 3, 4, 22, 45, 2, 1};
    sort(array);
    for (int i = 0;i<array.length ;i++ ) {
      System.out.println(array[i]);
    }
  }
}