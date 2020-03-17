/**
 * merge sort
 * 2020/03/12
 */
public class ArgSortMerge {

  public static void sort(int[] input) {
    int spanSize = 2, spanIdx = 0, writeIdx = 0,
        size = input.length, aIdx = 0, bIdx = 0;
    int[] output = input;
    int[] tmp = new int[output.length / 2];
    boolean aYet, bYet;

    while (spanSize <= size) {

      spanIdx = 0;
      writeIdx = 0;

      while (spanIdx < size) {

        aIdx = spanIdx;
        bIdx = aIdx + (spanSize / 2);

        for (int i = aIdx - spanIdx; i < bIdx - aIdx; i++) {
          tmp[i] = output[i + spanIdx];
        }

        aYet = true;
        bYet = true;

        while (aYet == true || bYet == true) {

          System.out.println(bIdx);
          System.out.println(bYet);
          if (bYet == false || (aYet == true && bYet == true &&
               tmp[aIdx - spanIdx] <= output[bIdx])) {

            output[writeIdx] = tmp[aIdx - spanIdx];
            aIdx++;

            if (aIdx >= spanIdx + spanSize / 2) {
              aYet = false;
            }
          } else {

            output[writeIdx] = output[bIdx];
            bIdx++;

            if (bIdx >= spanIdx + spanSize) {
              bYet = false;
            }
          }
          writeIdx++;
        }
        spanIdx += spanSize;
      }
      spanSize *= 2;
    }
  }

  /**
   * [main description]
   * @param args [description]
   */
  public static void main(String[] args) {


    int[] data = {
      47, 33, 68, 55, 74, 89, 55, 10,
      47, 33, 68, 55, 74, 89, 55, 10
    };

    for (int element : data) System.out.print(element + ",");
    System.out.println();
    sort(data);
    for (int element : data) System.out.print(element + ",");
  }
}