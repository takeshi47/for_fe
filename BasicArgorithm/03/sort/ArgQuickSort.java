/**
 * Quick Sort
 * 2020/03/16
 */
public class ArgQuickSort {

  /**
   * [sort()]
   * @param data []
   * @param min  []
   * @param max  []
   */
  public static void sort(int[] data, int min, int max) {
    //基準にする要素の要素番号を設定
    int j = findPivot(data, min, max);

    if (j > -1) {  //要素番号が設定されている時
      //基準値を設定する
      int pivot = data[j];

      //基準値を元に値を入れ替え、新たな基準値を設定する
      int k = arrange(data, min, max, pivot);
      int l = k - 1;

      //更新された基準値を元に再帰処理をおこなう
      sort(data, min, l);
      sort(data, k, max);
    }
  }

  /**
   * [findPivot()
   * @param  data
   * @param  min
   * @param  max
   * @return
   */
  public static int findPivot(int[] data, int min, int max) {

    int pivot = data[min];   //data[min]をpivotに格納し保持する
    int k = min + 1;         //minの次の要素番号
    int ret = -1;            //戻り値として返す値をエラー時の「-1」で初期化
    boolean found = false;

    //data[min]と異なる値を探す
    while (k <= max && !found) {
      if (data[k] == pivot) {
        k++;
      } else {  //値が見つかった時
        found = true;
        //大きい方の要素の要素番号を返す
        if (data[k] > pivot) {
          ret = k;
        } else {
          ret = min;
        }
      }
    }
    return ret;
  }

  /**
   * [arrange()
   * @param  data
   * @param  min
   * @param  max
   * @return
   */
  public static int arrange(int[] data, int min, int max, int pivot) {
    int l = min;
    int r = max;

    //data[l]がpivotより小さい間、lを1ずつ増やし、
    //data[r]がpivotより大きい間、rを１ずつ減らしながら、
    //data[l]とdata[r]を交換していく
    while (l < r) {
      int tmp = data[l];
      data[l] = data[r];
      data[r] = tmp;

      while (data[l] < pivot) l++;
      while (data[r] >= pivot) r--;
    }

    //交換し終わった時点のlの値を返す
    return l;
  }

  /**
   * [main description]
   * @param args [description]
   */
  public static void main(String[] args) {

    int[] data = {
      14, 6, 9, 7, 23, 47, 1, 5, 9
    };

    for (int element : data) System.out.print(element + ",");
    System.out.println();
    sort(data, 0, data.length - 1);
    for (int element : data) System.out.print(element + ",");
  }
}