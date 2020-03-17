/**
 * Quick Sort
 * 2020/02/13
 */
public class ArgQuickSort {

	static	int enter = 0;

	/**
	 * sort()
	 * @param int[] data
	 * @param int min
	 * @param int max
	 */
	public static void sort(int[] data, int min, int max) {
		enter++;
		System.out.print("【enter:" + enter + "】... min:"	 + min + ", max:" + max + " ... ");
		for (int element : data) System.out.print(element + ", ");
		System.out.println();

		int j = findPivot(data, min, max);
		if (j > -1) {
			int pivot = data[j];
			int k = arrange(data, min, max, pivot);
			int l = k - 1;

			sort(data, min, l);
			sort(data, k, max);
		}

		System.out.print("【exit】... min:" + min + ", max:" + max + " ... ");
		for (int element : data) System.out.print(element + ", ");
		System.out.println();
	}
	/**
	 * findPivot()
	 * @param  data int[]
	 * @param  min  int
	 * @param  max  int
	 * @return pivot
	 */
	public static int findPivot(int[] data, int min, int max) {

		int pivot = data[min];
		int k = min + 1;
		int ret = - 1;
		boolean found = false;

		System.out.println("FindPivot ... min:" + min + ", max:" + max + ", pivot:" + pivot);

		//data[min]と異なる値が見つかるまで調べる
		while (k <= max && !found) {
			if (data[k] == pivot) {
				k++;
			} else {
				found = true;
				//値の大きい方の要素番号を戻り値で返す
				if (data[k] > pivot) {
					ret = k;
				} else {
					ret = min;
				}
			}
		}
		System.out.println("FindPivot ... min:" + min + ", max:" + max + ", pivot:" + ret);
		return ret;
	}

	/**
	 * [arrange]
	 * @param  data
	 * @param  min
	 * @param  max
	 * @param  pivot
	 * @return
	 */
	public static int arrange(int[] data, int min, int max, int pivot) {

		int l = min;
		int r = max;

		//data[l]がpivotより小さい間、lを1ずつ増やし、
		//data[r]がpivotより大きい間、rを1ずつ増やしながら
		//data[l]とdata[r]を交換していく
		while (l < r) {

			System.out.println("l:" + l + ", r:" + r);
			System.out.println("data[l]:" + data[l] +  ", data[r]" + data[r]);
			int tmp = data[r];
			data[r] = data[l];
			data[l] = tmp;

			while (data[l] < pivot) l++;
			while (data[r] > pivot) r--;
		}
		return l;
	}
	/**
	 * [main ]
	 * @param args []
	 */
	public static void main(String[] args) {

		int[] data = {
			67, 1, 14, 6, 47, 23, 90, 79
		};

		sort(data, 0, data.length - 1);
	}
}