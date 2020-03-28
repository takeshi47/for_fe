/**
 * H30 Spring arg
 * 2020/03/24
 */
public class H30Spring {

  public static int[] makeHeap(int[] data,int[] heap, int hnum) {

    int k;
    for (int i = 0; i < hnum; i++) {
      heap[i] = data[i];
      k = i;

      while (k > 0) {

        if (heap[k] > heap[parent(k)]){      //TODO:a

          swap(heap, k, lChild(k));    //TODO:b
          k = parent(k);
        } else {
          break;
        }
      }
    }
  }

  public static int[] heap(int[] heap, int i, int j){
    int tmp = heap[i];
    heap[i] = heap[j];
    heap[j] = tmp;
  }

  public static int lChild(int i) {return 2 * i + 1;}

  public static int rChild(int i) {return 2 * i + 2;}

  public static int parent(int i) {return (i - 1) / 2;}

  public static void main(String[] args) {

  }
}