/**
 * 文字列を操作する
 * 2020/01/28
 */
public class ArgoStringMove {
	/**
	 * min
	 * @param  x
	 * @param  y
	 * @return min
	 */
	public static int min(int x, int y) {
		if (x < y) return x;
		return y;
	}
	/**
	 * strInsert()
	 * @param a  String[] 挿入される文字の配列
	 * @param ax String   挿入される文字数
	 * @param b  String[] 挿入する文字列の配列
	 * @param bx String   挿入する文字数
	 * @param px int      挿入する位置
	 */
	public static void strInsert(String[] a , int ax, String[] b,
	                             int bx, int px) {

		/*
		 * 挿入前の処理
		 */
		if (px < ax + 1) {
			//用意した配列からあふれる文字があるかを調べる
			int y = min((a.length - 1) - bx, ax);
			//あふれを考慮し、挿入する文字数分、後ろに移動させる
			for (int x = y; x >= px; x--) {
				a[x + bx] = a[x];
			}
		} else {
			if (px > ax + 1) {   //px == ax のときは何もしない。
				for (int x = (ax + 1) - 1; x < px; x++) {
					//文字の最後尾から挿入位置の間に空白(@)を入れる
					a[x] = "@";
				}
			}
		}
		/*
		 * 挿入処理
		 */
		int y = min((px + bx), a.length);
		System.out.println("y:" + y);
		for (int x = px; x < y; x++) {
			a[x] = b[x - px];
		}
	}
	/**
	 * main
	 */
	public static void main(String[] args) {
		String[] a = {
			"a", "b", "c", "", "",  "", "", "", "", ""
		};
		int ax = 3;
		String[] b = {
			"1", "2", "3"
		};
		int bx = b.length;
		int px = 6;

		System.out.println("配列の大きさ:" + a.length + ", 文字列の長さ:" + ax);
		for (String element : a)  System.out.print(element + ",");
		System.out.println();
		System.out.println("挿入する文字列の長さ:" + b.length + ", 挿入する位置:" + px);
		strInsert(a, ax , b, bx, px - 1);

		for (String element : a)  System.out.print(element + ",");
	}
}