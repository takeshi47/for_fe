/**
 * 2020/01/22 作成
 * 基数変換を行うアルゴリズム
 */
public class RadixConversion {
	public static void main(String[] args) {
		//基数変換する数字を用意する
		int n = 80;
		double d = 0.625;

		int[] radix = conversion(n);
		for (int i = 0; i < radix.length; i++) {
			System.out.print(radix[i]);
		}

		System.out.println();

		radix = conversion(d);
		System.out.print("0.");
		for (int i = 0; i < radix.length; i++) {
			System.out.print(radix[i]);
		}
	}

	/**
	 * 整数を基数変換する。
	 * @param  n int 変換する数字
	 * @return 基数変換の結果を格納した配列
	 */
	public static int[] conversion(int n) {
		int[] radix = {0, 0, 0, 0, 0, 0, 0 , 0};

		System.out.println("整数ｎ:" + n + "を基数変換する。");

		for (int i = radix.length - 1; i >= 0; i--) {
			radix[i] = n % 2;
			n = n / 2;
		}
		return radix;
	}
	/**
	 * 少数を基数変換する。
	 * @param  d double 変換する少数
	 * @return 変換結果を格納した配列
	 */
	public static int[] conversion(double d) {
		int[] radix = {0, 0, 0, 0, 0, 0, 0, 0};

		System.out.println("少数d:" + d + "を基数変換する");

		for (int i = 0; i < radix.length; i++) {
			radix[i] = (int)(d * 2);
			d = d * 2 - radix[i];
		}
		return radix;
	}
}
