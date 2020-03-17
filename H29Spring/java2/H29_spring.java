/**
 * @H29 spring 2回目
 * @01/17
 */

/**
 * 段階的に変化する値のペアをテーブルとして表現する抽象クラス
 */
abstract class TierTable {
	//数字をペアで保持した入れるを保持する配列
	final double[][] pairs;

	//コンストラクタ
	TierTable (double... tiers) {
		if (tiers.length % 2 == 1) {
			throw new IllegalArgumentException("不正な長さ：" + tiers.length);
		}
		//数字をペアで保持するための配列
		double[][] a = new double[tiers.length / 2][];
		//引数で与えられた数字をペアごとに配列に格納する
		for (int i = 0; i < tiers.length; i += 2) {
			//
			a[i / 2] = new double[] {tiers[i], tiers[i + 1]};
		}

		//メンバ変数に配列を保持する
		this.pairs = a;
	}
	/**
	 * map
	 * 与えられた数値を別の数値に変換して返す抽象メソッド
	 *
	 * @param double maount
	 */
	abstract double map(double mount);
}

/**
 * 料金単価を表すテーブル
 */
class TieredRateTable extends TierTable {
	TieredRateTable (double... tiers) {
		super(tiers);     //スーパークラスのコンストラクタを使う
	}

	/**
	 * 料金を計算する
	 * map()
	 *
	 * @param  mount double
	 * @return charge
	 */
	double map (double amount) {
		double charge = 0;
		for (int i = 0; i < pairs.length; i++) {
			if (i + 1 < pairs.length && amount > pairs[i + 1][0]) {
				charge += (pairs[i + 1][0] - pairs[i][0]) * pairs[i][1];
			} else {
				charge += (amount - pairs[i][0]) * pairs[i][1];
			}
		}
		return charge;
	}
}
/**
 * プランを表すクラス
 */
class RatePlan {
	private final String name;        //プラン名
	private final double basicCharge; //基本料金
	private final TierTable princingTiers; //料金単価

	/**
	 * コンストラクタ
	 */
	RatePlan (String name, double basicCharge, TierTable princingTiers) {
		this.name = name;
		this.basicCharge = basicCharge;
		this.princingTiers = princingTiers;
	}

	/**
	 * プラン名を返す
	 * [getName description]
	 * @return name
	 */
	String getName() {return name;}

	/**
	 * 電力料金を整数値で返す
	 * getPrice()
	 * @param  amount 電力量
	 * @return 電力量料金
	 */
	int getPrice(double amount) {
		return (int)(basicCharge + princingTiers.map(amount));
	}
}
/**
 * 割引率を求めるクラス
 */
class DiscountTable extends TierTable {
	/**
	 * コンストラクタ
	 */
	DiscountTable (double... tiers) {
		super(tiers);
	}
  /**
   * map 割引率を少数で返す
   * @param  amount 電気料金
   * @return 割引率
   */
	double map(double amount) {
    for (int i = pairs.length; i >= 0; i--) {
      if (amount >= pairs[i][0]) {
        return pairs[i][1];
      }
    }
    throw new IllegalArgumentException("amount" + amount);
	}
}
/**
 * 割引プランを示すクラス
 */
class DiscountPlan extends RatePlan{
  private final TierTable discountTiers;  //割引率のテーブルを持つインスタンス
  /**
   * コンストラクタ
   */
  DiscountPlan (String name, double basicCharge,
    TierTable princingTiers, TierTable discountTiers) {
    super(name, basicCharge, princingTiers);
    this.discountTiers = discountTiers;
  }

  int getPrice(double amount) {
    int price = super.getPrice(amount);
    return (int)(price * (1.0 - discountTiers.map(price)));
  }
}
/**
 * main
 */
public class H29_spring {
	public static void main(String[] args) {

		//プランAを設定したインスタンスを生成
		RatePlan planA = new RatePlan("プランA", 1123.30,
		                              new TieredRateTable(0, 19.62, 120, 26.10, 300, 30.12));
		//プランBを設定したインスタンスを生成
		RatePlan planB = new RatePlan("プランB", 1040.10,
		                              new TieredRateTable(0, 18.17, 120, 24.17, 300, 27.77));

		//電力量が543.0の場合で検証
		double amount = 543.0;
		int d = planA.getPrice(amount) - planB.getPrice(amount);
		if (d < 0) {
			System.out.printf("%sが%d円安い", planA.getName(), -d);
		} else if (d > 0) {
			System.out.printf("%sが%d円安い", planB.getName(), d);
		} else {
			System.out.println("どっちもおんなじ");
		}
	}
}