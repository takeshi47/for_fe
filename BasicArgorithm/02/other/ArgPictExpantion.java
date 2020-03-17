/**
 * ArgPictExpantion
 * 2020/02/29
 */
public class ArgPictExpantion {

  /**
   * [expantion description]
   * @param String[][] data
   * @param int magX
   * @param int magY
   * @return
   */
  public static String[][] expantion(String[][] data, int magX, int magY) {
    String[][] exeData = new String[data.length * magX][data.length * magY];

    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data.length; j++) {

        for (int x = 0; x < magX; x++) {
          for (int y = 0; y < magY; y++) {
            int s = i * magX + x;
            int t = j * magY + y;

            exeData[s][t] = data[i][j];
          }
        }
      }
    }
    return exeData;
  }

  public static void main(String[] args) {
    String[][] data = {
      {"@", "@", "@", "@", "@"},
      {" ", " ", "@", " ", " "},
      {" ", " ", "@", " ", " "},
      {" ", " ", "@", " ", " "},
      {" ", " ", "@", " ", " "}
    };

    for (int i = 0; i < data.length; i++) {
      for (String element : data[i]) {
        System.out.print(element);
      }
      System.out.println();
    }
    String[][] exeData = expantion(data, 4, 4);

    for (int i = 0; i < exeData.length; i++) {
      for (String element : exeData[i]) {
        System.out.print(element);
      }
      System.out.println();
    }
  }
}
