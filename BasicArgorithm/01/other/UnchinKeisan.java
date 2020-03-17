/**
 * 運賃計算をするアルゴリズム
 * 2020/01/27 作成
 */
public class UnchinKeisan {
	//距離区分のテーブル
	static final int[] distance = {
		10, 20, 40, 80, 160, 99999
	};
	//距離区分毎の料金テーブル
	static final int[] price = {
		150, 30, 20, 15, 10
	};
	//距離区分ごとの料金を固定にしたときの料金テーブル
	static final int[] fixedFee = {
		250, 150, 200, 300, 400, 0
	};
	/**
	* 運賃を計算する
	 * calc()
	 * @param rideDistance 乗車距離
	 */
	public static void calc(int rideDistance) {
		int total = price[0];
		if (distance[0] < rideDistance) {
			int i = 1;
			//区分ごとの料金を計算するループ
			for (i = 1; distance[i] < rideDistance; i++ ) {
				total += (distance[i] - distance[i - 1]) * price[i];
			}
			//区分の端数分の距離の料金を計算する
			if (i < distance.length) {
				total += (rideDistance - distance[i - 1]) * price[i];
				System.out.println("乗車距離:" + rideDistance + "kmの料金は" + total + "円です。");
			} else {
				System.out.println("error!");
			}
		}
	}
	/**
	 * 区間ごとの料金が固定料金の場合の計算をする。
	 * fixedFeeCalc()
	 * @param rideDistance 乗車距離
	 */
	public static void fixedFeeCalc(int rideDistance) {
		int total = 0;
		int i = -1;
		//区分ごとの固定料金を加算する
		do {
			i++;
			total += fixedFee[i];
			System.out.println("total:" + total);
		} while (distance[i] < rideDistance);
		//表示
		if (i < distance.length) {
			System.out.println("乗車距離:" + rideDistance + "kmの運賃は" + total + "円です。");
		}
	}

	/**
	 * main
	 */
	public static void main(String[] args) {
		int i = 45;
		calc(i);
		fixedFeeCalc(i);
	}
}