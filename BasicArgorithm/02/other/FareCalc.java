/**
 * 運賃計算
 * 2020/02/14
 */
public class FareCalc {
	//距離区分テーブル
	static final int[] distance = {
		10, 20, 40, 80, 160, 99999
	};
	//距離区分ごとの距離分の料金テーブル
	static final int[] price = {
		150, 30, 20, 15, 10
	};
	//距離区分ごとの料金を固定にしたときの料金テーブル
	static final int[] fixedFee = {
		250, 150, 200, 300, 400, 0
	};

	/**
	 * [calc description]
	 * @param rideDistance [description]
	 */
	public static void calc(int rideDistance) {
		int total = price[0];   //合計料金を基本料金で初期化

		//基本料金範囲より長く乗車した時
		if (distance[0] < rideDistance) {
			//区分ごとの料金を計算する
			int i = 1;
			for (i = 1; distance[i] < rideDistance; i++) {
				total += (distance[i] - distance[i - 1]) * price[i];
			}
      System.out.println("i:" + i);
			//端数距離分の料金を計算する
			if (i < price.length) {
				total += (rideDistance - distance[i - 1]) * price[i];
			} else {
        total += (rideDistance - distance[i - 1]) * price[i - 1];
      }
		}
		System.out.println("【従量】乗車距離:" + rideDistance + "kmの料金は、" + total + "円です");
	}

  public static void fixedFeeCalc(int rideDistance) {
    int total = 0;
    int i = -1;

    //区分毎の固定料金を加算する。
    do {
      i++;
      total += fixedFee[i];
    } while (distance[i] < rideDistance);

    if (i < distance.length) {
      System.out.println("【固定】乗車距離:" + rideDistance + "kmの運賃は" + total + "円です");
    }
  }

	public static void main(String[] args) {
    calc(150);
    calc(170);
    calc(180);
		calc(190);

    fixedFeeCalc(140);
	}
}