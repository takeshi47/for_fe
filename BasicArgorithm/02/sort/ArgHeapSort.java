/**
 * HeapSort
 * 2020/02/27
 */
public class ArgHeapSort {

  static int[] data = {
    86, 12, 91, 7, 45, 1, 55, 72, 69, 72
  };

  /**
   * [heapSort]
   *
   * @param int num
   */
  public static void heapSort(int num) {

    initHeap(num);

    for (int i = num; i > 0; i--) {
      swap(0, i);
      makeHeap(0, i - 1);
    }
  }

  /**
   * [makeHeap
   * @param int top
   * @param int last
   */
  public static void makeHeap(int top, int last) {
    int l = top * 2;
    int r = l + 1;

    if (r <= last) {                //右の子があり、
      if (data[l] > data[r]) {      //左の子より右の子が大きく、
        if (data[top] > data[r]) {  //右の子が根より大きい時
          swap(top, r);             //右の子と根の値を交換する
          makeHeap(r, last);
        }
      } else {
        if (data[l] < data[top]) {  //左の子が根より大きい時
          swap(top, l);             //左の子と根の値を交換する
          makeHeap(l, last);
        }
      }
    } else {
      if (l <= last) {                //左の子のみ存在し、
        if (data[l] < data[top]) {    //左の子が根より大きい時、
          swap(l, top);               //左の子と根の値を交換する
          makeHeap(l, last);
        }
      }
    }
  }

  /**
   * [swap ]
   * @param int x []
   * @param int y []
   */
  public static void swap(int x, int y) {
    int tmp = data[x];
    data[x] = data[y];
    data[y] = tmp;
  }

  /**
   * [initHeap ]
   * @param int last []
   */
  public static void initHeap(int last) {
    for (int i = last / 2; i >= 0; i--) {
      makeHeap(i, last);
    }
  }

  public static void main(String[] args) {

    for (int element : data) System.out.print(element + ", ");

    System.out.println();

    heapSort(data.length - 1);

    for (int element : data) System.out.print(element + ", ");
  }
}
