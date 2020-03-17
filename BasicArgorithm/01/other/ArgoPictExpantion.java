/**
 * 画像を拡大する
 * 2020/01/28 作成
 */
public class ArgoPictExpantion {
	/**
	 * [exepansion
	 * @param  data
	 * @param  magX
	 * @param  magY
	 * @return
	 */
	public static String[][] exepansion(String[][] data, int magX, int magY) {
		String[][] exeData = new String[data.length * 2][data.length * 2];
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
	 * main
	 */
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
		String[][] exeData = exepansion(data, 2, 2);

		for (int i = 0; i < exeData.length; i++) {
			for (String element : exeData[i]) {
				System.out.print(element);
			}
			System.out.println();
		}
	}
}


