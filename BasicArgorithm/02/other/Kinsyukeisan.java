/**
 * 金種計算
 * 2020/02/14
 */
public class Kinsyukeisan {

	//金種テーブル
	static final int[] kinsyu = {
		10000, 5000, 1000, 500, 100, 50, 10, 5, 1
	};
	//枚数を格納する配列
	static final int[] mny = {
		0, 0, 0, 0, 0, 0, 0, 0, 0
	};

	public static void calc(int[] data) {
		for (int i = 0; i < data.length; i++) {
			int money = data[i];
			for (int j = 0; money > 0; j++) {
				int m = money / kinsyu[j];  //j番目の金種を計算する
				mny[j] += m;
				money = money - m * kinsyu[j];
			}
		}
	}
	/**
	 * [main]
	 * @param args ]
	 */
	public static void main(String[] args) {

    final int[] data = {
      30000, 500, 4560, 23456
    };

    calc(data);

    for (int i = 0; i < mny.length; i++) {
      System.out.println(kinsyu[i] + "円は" + mny[i] + "枚");
    }
	}
}