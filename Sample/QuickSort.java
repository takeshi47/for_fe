public class QuickSort {
  //配列arrayのleftからrightまでの間のデータ列をクイックソートする
  static void quickSort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    //配列arrayの真ん中の要素
    int p = array[(left + right) / 2];
    int l = left , r = right, tmp;

    System.out.println("p=" + p);

    while (l <= r) {
      while (array[l] < p) {
        System.out.print("array[l]=" + array[l] + ",");
        l++;
      }
      while (array[r] > p) {
        System.out.print("array[r]" + array[r] + ",");
        r--;
      }
      if (l <= r) {
        tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
        l++;
        r--;
      }
    }
    quickSort(array, left, r);
    quickSort(array, l, right);
  }

  // 配列内のデータ列を表示する
  static void print_data(int[] d) {
    System.out.println();
    for (int i = 0; i < d.length; i++)
      System.out.print(d[i] + ",");
    System.out.println();
  }
  public static void main(String[] args) {
    int[] array = {5, 10, 3, 7, 8, 1, 9, 2};
    print_data(array);
    quickSort(array, 0, array.length - 1);
    print_data(array);
  }
}