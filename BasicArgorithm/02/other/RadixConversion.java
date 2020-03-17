/**
 * 基数変換
 * 2020/02/14
 */
public class RadixConversion {

	/**
	* 整数を基数変換する
	 * conversion()
	 * @param  n
	 * @return
	 */
	public static void conversion(int n) {
		//変換した結果を格納する配列
		int[] radix = {
			0, 0, 0, 0, 0, 0, 0, 0
		};
		System.out.println("整数n:" + n + "を基数変換する。");

		//基数変換した下一桁から、配列の後ろから格納していく。
		for (int i = radix.length - 1; i >= 0; i--) {
			radix[i] = n % 2;
			n /= 2;
		}
		for (int element : radix) System.out.print(element);
	}

	public static void conversion(double d) {
		//変換結果を格納する配列
		int[] radix = {
			0, 0, 0, 0, 0, 0, 0, 0
		};

		System.out.println("少数d:" + d + "を基数変換する");
		//整数とは反対に、配列の先頭から格納していく
		for (int i = 0; i < radix.length; i++) {
			radix[i] = (int)(d * 2);
			d = d * 2 - radix[i];
		}
    System.out.print("0.");
		for (int element : radix) System.out.print(element);
	}
	/**
	 * [main]
	 * @param args
	 */
	public static void main(String[] args) {

		conversion(9);
		System.out.println();
    conversion(0.5);
	}
}