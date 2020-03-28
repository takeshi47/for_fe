/**
 * H30 Spring arg
 * 2020/03/24
 */
public class H30Spring {

  public static int[] makeHeap(int[] data, int[] heap, int hnum) {

    int k;
    for (int i = 0; i < hnum; i++) {
      heap[i] = data[i];
      k = i;

      while (k > 0) {

        if (heap[k] > heap[parent(k)]) {     //TODO:a
          swap(heap, k, parent(k));    //TODO:b
          k = parent(k);
          for (int element : heap) System.out.print(element + " ");
          System.out.println();
        } else {
          for (int element : heap) System.out.print(element + " ");
          System.out.println();
          break;
        }
      }
    }
    return heap;
  }

  public static int[] swap(int[] heap, int i, int j) {
    int tmp = heap[i];
    heap[i] = heap[j];
    heap[j] = tmp;

    return heap;
  }

  public static int lChild(int i) {return 2 * i + 1;}

  public static int rChild(int i) {return 2 * i + 2;}

  public static int parent(int i) {return (i - 1) / 2;}

  /**
   * [heapSort ]
   * @param  data
   * @param  heap
   * @param  hnum
   * @return
   */
  public static int[] heapSort(int[] data, int[] heap, int hnum) {

    makeHeap(data, heap, hnum);
    for (int last = hnum - 1; last > 0; last--) {
      swap(heap, 0, last);      //heap[0] と heap[last] の値を交換
      downHeap(heap, last - 1); //heapを再構成
    }

    return heap;
  }

  /**
   * [main description]
   * @param args [description]
   */
  public static int[] downHeap(int[] heap, int hLast) {

    int n = 0;
    int tmp = -1;

    while (lChild(n) <= hLast) {
      tmp = lChild(n);

      if (rChild(n) <= hLast) {
        if (heap[tmp] <= heap[rChild(n)]) {
          tmp = rChild(n);
        }
      }

      if (heap[tmp] > heap[n]) {
        swap(heap, n, tmp);
      } else {
        return heap;
      }
    }
    n = tmp;
    return heap;
  }


  public static void main(String[] args) {

    int[] data =  {60, 15, 45, 30, 5, 50, 20};

    int[] heap = new int[data.length];

    makeHeap(data, heap, data.length);

    for (int element : heap) System.out.print(element + " ");

    System.out.println();
    for (int element : heapSort(data, heap, data.length)) System.out.print(element + " ");
  }
}
