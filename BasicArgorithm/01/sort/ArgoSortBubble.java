/**
 * バブルソート
 * 2020/01/29 作成
 */
public class ArgoSortBubble {

	public static void sort(int[] data) {

		System.out.println("data.length:" + data.length);
		int x = 0;
		int y = 0;

		for (int i = data.length - 1; i > 0; i--) {
			y++;
			for (int j = 0; j < i; j++) {
				y++;
				System.out.println("y:" + y);
				if (data[j] > data[j + 1]) {
					int tmp = data[j + 1];
					data[j + 1] = data[j];
					data[j] = tmp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] data = {
			12, 13, 16, 1,
			12, 13, 16, 1,
			12, 13,
			12, 13, 16, 1,
			12, 13, 16, 1,
			12, 13, 12, 13, 16, 1,
			12, 13, 16, 1,
			12, 13,
			12, 13, 16, 1,
			12, 13, 16, 1,
			12, 13
		};
		sort(data);
		for (int element : data) System.out.print(element + ",");
	}
}