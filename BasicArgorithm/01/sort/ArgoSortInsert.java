/**
 * 挿入ソート
 * 2020/01/27 作成
 */
public class ArgoSortInsert {
	/**
	 * sort()
	 * @param data [description]
	 */
	public static void sort(int[] data) {
		for (int i = 1; i < data.length; i++) {
			System.out.println("data[i]:" + data[i]);
			int tmp = data[i];
			int j = i;

			while (j > 0 && tmp < data[j - 1]) {
				System.out.println("j:" + j);
				data[j] = data[j - 1];
				j--;
				for (int element : data) {
					System.out.print(element + " ");
				}
				System.out.println();
			}
			data[j] = tmp;
		}
	}
	/**
	 * main
	 */
	public static void main(String[] args) {
		int[] data = {
			14, 67, 23, 6
		};
		for (int element : data) {
			System.out.print(element + " ");
		}
		System.out.println();
		sort(data);
		for (int element : data) {
			System.out.print(element + " ");
		}
	}
}