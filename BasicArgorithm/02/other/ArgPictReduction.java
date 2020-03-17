/**
 * ArgPictReduction
 * 2020/03/01
 */
public class ArgPictReduction {

  public static String[][] expansion(String[][] data, int magX, int magY) {
    String[][] exeData = new String[data.length * magX][data.length * magY];

    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data.length; j++) {

        for (int x = 0; x < magX; x++) {
          for (int y = 0; y < magY; y++) {

            int s = i * 2 + x;
            int t = j * 2 + y;

            exeData[s][t] = data[i][j];
          }
        }
      }
    }
    return exeData;
  }

  public static String[][] reduction(String[][] data, int magX, int magY) {
    int x = data.length / magX;
    int y = data.length / magY;

    String[][] reducData = new String[x][y];

    for (int i = 0; i < data.length; i += magX) {
      for (int j = 0; j < data.length; j += magY) {
        // System.out.print("i:" + i + ", j:" + j + ", data[i][j]:" + data[i][j] + "\n");
        reducData[i / 2][j / 2] = data[i][j];
      }
    }
    return reducData;
  }

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

    for (String str[] : reduction(expansion(data, 2, 2), 2, 2)) {
      for (String str2 : str) {
        System.out.print(str2);
      }
      System.out.println();
    }
  }
}