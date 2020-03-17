/**
 * 再帰を使った2分探索方
 * 2020/01/31 作成
 */
public class ArgoSearchBinaryReturn {

	public static final int[] data = {
		1, 2, 3, 4, 14, 23, 47, 67, 79, 89
	};
	public static int countEnter;
	public static int countExit;

	public static int search(int target, int low, int high) {
		int ret = -1;
		System.out.println("[enter] low:" + low + ", high:" + high);

		if (low <= high) {
			int mid = (high + low) / 2;

      System.out.println("mid:"+ mid + ", data[mid]:" + data[mid]);

			if (data[mid] == target) {
				ret = mid;
			} else {
				if (data[mid] > target) {
					ret = search(target, low, mid - 1);
				} else {
					ret = search(target, mid + 1, high);
				}
			}
		} else {
      ret = -1;
    }
    System.out.println("[exit]  low:" + low + ", high:" + high);
		return ret;
	}

	/**
	 * [main
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(search(47, 0, data.length));
	}
}