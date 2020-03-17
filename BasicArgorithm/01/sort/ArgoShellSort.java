/**
 * シェルソート
 * 2020/01/31 作成
 */
public class ArgoShellSort {

	public static void sort(int[] data) {
		//シェルソートの振り分け幅を設定する
		int h = data.length / 2;

		while (h > 0) {
			for (int i = h; i < data.length; i++) {
				int j = i - h;
          System.out.print("h:" + h +  ", i:" + i + ", j:" + j + "[");

				while (j >= h && data[j + h] <  data[j]) {

					for (int element : data) System.out.print(element + " ");
					System.out.println("]");

					int tmp = data[j];
					data[j] = data[j + h];
					data[j + h] = tmp;
					// j -= h;
					j -= h;
				}
			}
			System.out.println();
			h /= 2;
		}
	}
	/**
	 * main
	 */
	public static void main(String[] args) {
		// int[] data = {
		//  47, 14, 67, 23, 6, 32, 89, 79
		// };
		int[] data = {
			8, 7, 6, 5, 4, 3 , 2, 1
		};

		sort(data);
		for (int element : data) System.out.print(element + ",");

	}
}