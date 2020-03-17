public class BubbleSortTest {

  static void bubbleSort(int[] array) {
    for (int i = array.length -1 ; i > 0; i-- ) {
      for (int j = 0 ; j < i ; j++ ) {
        if (array[j] > array[j + 1]) {
          int tempBox = array[j];
          array[j] = array[j + 1];
          array[j + 1] = tempBox;
          System.out.println(array[j] + ":" + array[j + 1]);
        } else {

        }
      }
    }
  }

  static void print(int[] array) {
    for (int i = 0; i < array.length  ; i++ ) {
      System.out.print(array[i] + ":");
    }
    System.out.println();
  }

  public static void main(String[] args) {

    int[] array = new int[7];

    array[0] = 47;
    array[1] = 79;
    array[2] = 14;
    array[3] = 67;
    array[4] = 23;
    array[5] = 7;
    array[6] = 9;

    print(array);
    bubbleSort(array);
    print(array);
  }
}