/**
 * QuickSort
 * 2020/02/24
 */
public class ArgQuickSort {

	public static void sort(int[] data, int min, int max) {
		//基準値の要素数を設定
		int j = findPivot(data, min, max);

		if (j > -1) {			//基準値の要素数が設定出来た時
			int pivot = data[j];		//基準となる値を設定する

			//基準値を元に値を入れ替え、新たな基準値を設定する
			int k = arrange(data, min , max ,pivot);
			int l = k -	1;

			//更新された基準値を元に再帰処理お行う
			sort(data, min, l);
			sort(data, k, max);
		}
	}

	/**
	 * [findPivot]
	 * find pivot and retrun it.
	 * @param  data int[]
	 * @param  min  int
	 * @param  max  int
	 * @return pivot
	 */
	public static int findPivot(int[] data, int min, int max) {

		int pivot = data[min];		//基準値として返す値
		int k = min + 1;
		int ret = -1;							//対象の配列の中身が同一の時「-1」を返す。
		boolean found = false;		//基準値が見つかったかどうか

		//data[min]と異なる値が見つかるまで調べる
		while (k <= max && !found) {
			if (data[k] == pivot) {
				k++;
			} else {
				found = true;
				//異なる値が見つかった時、
				//大きい方の値の入っている要素番号を返す
				if (data[k] > pivot) {
					ret = k;
				} else {
					ret = min;
				}
			}
		}
		return ret;
	}

	/**
	 * [arrange ]
	 * @param data  int[]
	 * @param min   int
	 * @param max   int
	 * @param pivot
	 */
	public static int arrange(int[] data, int min, int max, int pivot) {
		int l = min;
		int r = max;

		//data[l]がpivotより小さい間lを1ずつ増やし、
		//data[r]がpivotより大きい間rを1ずつ増やしながら
		//data[l]とdata[r]を交換していくと、
		//pivotより左がpivotより小さく、右が大きいものだけになる
		while (l < r) {
			int tmp = data[l];
			data[l] = data[r];
			data[r] = tmp;

			while (data[l] >= pivot) l++;
			while (data[r] < pivot) r--;
		}

		return l;
	}

	/**
	 * main()
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = {
			14, 6, 9, 7, 23, 47, 1, 5, 9
		};

		for (int element: data) System.out.print(element + ",");
		System.out.println();
		sort(data, 0, data.length -1);
			for (int element: data) System.out.print(element + ",");
	}
}