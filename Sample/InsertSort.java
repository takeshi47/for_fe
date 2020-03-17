public class InsertSort {
  /*
   *    InsertSert
   */
  public static void sort(int[] array) {
    for (int i = 1; i < array.length ; i++ ) {
      //2つ目の要素とindexを保存しておく
      int tmp = array[i];
      int j ;
      System.out.println( "i:" + i);
      System.out.println("tmp:" + tmp);
      //ｔｍｐより小さい要素を配列番号の小さい方へ挿入していく
      for (j = i; j > 0 && tmp < array[j - 1] ; j-- ) {
        System.out.printf("j:%d,array[j]:%d,array[j-1]:%d\n", j, array[j], array[j - 1]);
        array[j] = array[j - 1];

        for (int index = 0; index < array.length ; index++ ) {
          System.out.print(array[index] + ",");
        }
        System.out.println();
      }
      array[j] = tmp;
      for (int index = 0; index < array.length ; index++ ) {
        System.out.print(array[index] + ",");
      }
      System.out.println("\n");
    }
  }
  /*
   *    main
   */
  public static void main(String[] args) {
    int[] array = {23, 44, 5, 4, 34, 56, 7};
    sort(array);
    for (int i = 0 ; i < array.length ; i++ ) {
      System.out.print(array[i] + ",");
    }
  }
}