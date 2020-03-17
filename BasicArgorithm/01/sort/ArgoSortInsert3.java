/**
 * 挿入ソート(昇順)
 * 2020/01/27
 */
public class ArgoSortInsert3 {
	public static int[] sort(int[] data) {
		int n = -1;
		int[] m = {
			-1, -1, -1, -1
		};

		for (int element : data) {
      System.out.println("【element:" + element + "】");
			System.out.println("n:" + n);
			int i = 0;
			while (i <= n && m[i] < element) {
				i++;
			}
			for (int e : m) {
				System.out.print(e + " ");
			}
			System.out.println();
			System.out.println(element + "を" + (i + 1) + "番目に挿入する");
			int j = n;
			while (j >= i) {
				m[j + 1] = m[j];
				j--;
			}
			m[i] = element;
			n++;
		}
		return m;
	}
	/**
	 * main
	 */
	public static void main(String[] args) {
		int[] data = {
			14, 67, 23, 6
		};
		for (int element : sort(data)) {
			System.out.print(element + " ");
		}
	}
}