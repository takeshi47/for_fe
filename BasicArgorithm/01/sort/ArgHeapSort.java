/**
 * HeapSort
 * 2020/02/18
 */
public class ArgHeapSort {

  //大域変数として扱う
  public static int[] data = {
    86, 12, 91, 7, 45, 1, 55, 72, 69, 72
  };

  /**
   * [heapSort ]
   * @param num []
   */
  public static void heapSort(int num) {
    //最初のヒープを作成
    initHeap(num);

    //並べ替えをする
    for (int i = num; i > 0; i--) {
      swap(0, i);
      makeHeap(0 , i - 1);
    }
  }

  /**
   * [makeHeap ]
   * @param top
   * @param last []
   */
  public static void makeHeap(int top, int last) {
    int l = top * 2;
    int r = l + 1;

    if (r <= last) {
      if (data[l] < data[r]) {
        if (data[top] < data[r]) {  //部分の根より右の子の方が大きい
          swap(top, r);             //部分の根と右の値を交換する
          makeHeap(r, last);        //右の子を根として部分木を作る
        }
      } else {
        if (data[top] < data[l]) { //部分根より左の子のほうが大きい
          swap(top, l);
          makeHeap(l, last);
        }
      }
    } else {
      if (l <= last) {              //子が左にしかない時
        if (data[l] > data[top]) {  //根より左の子の方が大きい
          swap(top, l);
          makeHeap(l, last);
        }
      }
    }
  }

  /**
   * [swap ]
   * @param  x []
   * @param  y []
   * @return   []
   */
  public static void swap(int x, int y) {
    int tmp = data[x];
    data[x] = data[y];
    data[y] = tmp;
  }

  /**
   * [initHeap ]
   * @param last []
   */
  public static void initHeap(int last) {
    for (int i = last / 2; i >= 0; i--) {
      makeHeap(i, last);
    }
  }

  public static void main(String[] args) {
    initHeap(data.length - 1);

    for (int element : data) System.out.print(element + ", ");

    System.out.println();

    heapSort(data.length - 1);
    for (int element : data) System.out.print(element + ", ");
  }
}