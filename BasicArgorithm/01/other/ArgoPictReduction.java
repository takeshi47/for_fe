/**
 * 画像を縮小する
 * 2020/01/29 作成
 */
public class ArgoPictReduction {
  /**
     * [exepansion
     * @param  data
     * @param  magX
     * @param  magY
     * @return
     */
  public static String[][] expansion(String[][] data, int magX, int magY) {
    String[][] exeData = new String[data.length * 2][data[0].length * 2];
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {

        for (int x = 0; x < magX; x++) {
          for (int y = 0; y < magY; y++) {
            int s = i * 2  + x;
            int t = j * 2  + y;

            exeData[s][t] = data[i][j];
          }
        }
      }
    }
    return exeData;
  }
  /**
   * [reduction
   * @param  data
   * @return
   */
  public static String[][] reduction(String[][] data) {
    int x = data.length / 2;
    int y = data[0].length / 2;
    String[][] reducData = new String[y][x];

    for (int i = 0; i < data.length; i += 2) {
      for (int j = 0; j < data[i].length; j += 2) {
        reducData[i / 2][j / 2] = data[i][j];
      }
    }

    return reducData;
  }

  /**
   * main
   */
  public static void main(String[] args) {
    String[][] data = {
      {" ", " ", " ", "@", " ", " "},
      {"@", "@", "@", "@", "@", "@"},
      {" ", " ", " ", "@", " ", " "},
      {" ", " ", "@", " ", "@", " "},
      {" ", "@", " ", " ", "@", " "},
      {"@", " ", " ", " ", " ", "@"}
    };

    for (String str[] : data) {
      for (String str2 : str) {
        System.out.print(str2);
      }
      System.out.println();
    }

    for (String str[] : expansion(data, 2, 2)) {
      for (String str2 : str) {
        System.out.print(str2);
      }
      System.out.println();
    }

    for (String str[] : reduction(expansion(data, 2, 2))) {
      for (String str2 : str) {
        System.out.print(str2);
      }
      System.out.println();
    }
  }
}