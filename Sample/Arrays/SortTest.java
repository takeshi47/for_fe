import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class SortTest {
  public static void main(String[] args) {

    // /*
    //  *昇順で並び替え
    //  */
    // int[] arrays = {10 , 30, 5, 2, 11, 90};

    // System.out.println("before sort:" );
    // for (int i : arrays) {
    //   System.out.println(i);
    // }

    // Arrays.sort(arrays);

    // System.out.println("after sort_asc:" );
    // for (int i : arrays) {
    //   System.out.println(i);
    // }


    //  *降順で並び替え
    //  *
    //  *降順並び替えはCollectionクラスを使用するため、
    //  *プリミティブ型ではなくクラス型で宣言する

    // Integer[] arraysInteger = {10 , 30, 5, 2, 11, 90};
    // Arrays.sort(arraysInteger,
    //             Collections.reverseOrder());
    // //asList()で配列をListのように扱うことが出来る
    // System.out.println("after sort_desc:"
    //                    + Arrays.asList(arraysInteger));
    /*
     *ComparatorでListをソートする場合
     */
    ArrayList<Integer> arrayListInteger = new ArrayList<>();

    arrayListInteger.add(10);
    arrayListInteger.add(30);
    arrayListInteger.add(5);
    arrayListInteger.add(2);
    arrayListInteger.add(11);
    arrayListInteger.add(90);

    System.out.println("before Compare_sort:"
                       + arrayListInteger);

    //Comparatorを定義しsort()の第二引数に設定
    Collections.sort(
      arrayListInteger,
    new Comparator<Integer>() {
      @Override
      public int compare(Integer int1, Integer int2) {
        return int2 - int1;
      }
    });

    //print
    System.out.println("after Compatre_sort:"
                       + arrayListInteger);

  }
}