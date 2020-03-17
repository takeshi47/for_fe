/**
 * ハッシュ探索(チェイン法)
 * 2020/01/28 作成
 */
public class ArgoSearchHashChain {

	public static final int[] hash = {
		110, 111, 112, 113, 114, 120, 130 , 117, 331, -1
	};
	public static final int[] point = {
		5 , 8, 7, 0, 0, 6, 0, 0, 0, 0
	};
	public static int search(int target) {
		int d = target;
		int n = (d % 5);
		int flg = 0;
		int i = 1;

		do {
			System.out.println("探索ループ" + i + "回目");
			i++;
			System.out.println("n:" + n);
			System.out.println("hash[n]:" + hash[n] + ", d:" + d);
			if (hash[n] == d) {
				flg = n;
				return flg + 1;
			} else {
				n = point[n];
        System.out.println("point[n]:" + n);
			}
		} while (n != 0 && flg == 0);
		return flg ;
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		System.out.println(search(332));
	}
}