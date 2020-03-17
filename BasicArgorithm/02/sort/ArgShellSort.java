/**
 * ShellSort
 * 2020/02/25
 */
public class ArgShellSort {

  public static void sort(int[] data) {
    //シャルソートの振り分け幅を設定する
    int h = data.length / 4;

    while (h > 0) {

      for (int i = h; i < data.length; i++) {
        int j = i - h;

        System.out.println("h:" + h +  ", i:" + i + ", j:" + j );

        while (j >= 0 && data[j] > data[j + h]) {

          System.out.println("\ndata[j]:" + data[j] + ", data[j + h]:" + data[j + h]);

          for (int element : data) System.out.print(element + " ");
          System.out.println();

          int tmp = data[j];
          data[j] = data[j + h];
          data[j + h] = tmp;

          j -=  h;
        }
      }
      h /= 2;
    }
  }

  public static void main(String[] args) {
    int[] data = {
      8, 7 , 6, 5, 4, 3, 2, 1
    };

    sort(data);
    for (int element : data) System.out.print(element + ", ");
  }
}