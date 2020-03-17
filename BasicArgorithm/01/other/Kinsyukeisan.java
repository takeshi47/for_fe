/**
 * 金種計算
 */
public class Kinsyukeisan {
	//金種表
	static final int[] kinsyu = {
		10000, 5000, 1000, 500, 100, 50, 10, 5, 1
	};
	//枚数表
	static final int[] mny = {
		0, 0 , 0, 0, 0, 0, 0, 0, 0
	};

	public static void calc(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int money = data[i];
			for (int j = 0; money > 0 ; j++) {
				int m = money / kinsyu[j];
				mny[j] = mny[j] + m;
				money = money - m * kinsyu[j];
			}
		}
	}

	public static void main(String[] args) {
		//給料ファイルのテスト用データ
		final int[] data = {30000, 50000, 45000, 67650};

		calc(data);

		for (int i = 0; i < mny.length; i++) {
			System.out.println(kinsyu[i] + "円札は" + mny[i] + "枚");
		}
	}
}