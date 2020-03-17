/*
 *    段階的に変化する値のペアをテーブルとして表現する抽象クラス
 */
abstract class TierTable {

  final double[][] pairs; //段階的に変化するペアの値

  TierTable(double... tiers) {
    // tiersの長さが奇数のとき例外を投げる
    if (tiers.length % 2 == 1) {
      throw new IllegalArgumentException("不正な長さ:" + tiers.length);
    }
    //引数tiersの半分の数の2次元配列を作る
    double[][] a = new double[tiers.length / 2][];

    //配列に値を代入する
    for (int i = 0; i < tiers.length ; i += 2) {
      a[i / 2] = new double[] {tiers[i], tiers[i + 1]};
    }
    this.pairs = a; //pairsをaで初期化する
  }
  abstract double map(double amount);
}

/*
 *  料金単価のテーブルを表すクラス
 */
class TieredRateTable extends TierTable {
  TieredRateTable(double... tiers) {
    super(tiers);   //親クラスのコンストラクタにtiersを渡す
  }
  //電力量料金を計算する
  double map(double amount) {
    double charge = 0;    //料金
    for (int i = 0; i < pairs.length ; i++ ) {
      //配列の数よりカウンタが小さく、引数amountがpairs[][0]より大きいとき
      if (i + 1 < pairs.length && amount > pairs[i + 1][0]) {
        //使用量が段階を越えた時、区切りから区切りまでの料金を加算する
        charge += (pairs[i + 1][0] - pairs[i][0]) * pairs[i][1];
      } else {
        //使用量が段階を越えた端数分の料金を加算する
        charge += (amount - pairs[i][0]) * pairs[i][1];
        break;
      }
    }
    return charge;
  }
}

/*
 *  料金プランを表すクラス
 */
class RatePlan {
  private final String name;            //プラン名
  private final double basicCharge;     //基本料金
  private final TierTable pricingTiers; //料金単価

  RatePlan(String name, double basicCharge, TierTable pricingTiers) {
    this.name = name;
    this.basicCharge = basicCharge;
    this.pricingTiers = pricingTiers;
  }

  String getName() {return name;}

  int getPrice(double amount) {
    return (int)(basicCharge + pricingTiers.map(amount));
  }
}

/*
 *  割引率を求めるクラス
 */
class DiscountTable extends TierTable {
  DiscountTable(double... tiers) {
    super(tiers);
  }

  double map(double amount) {
    for (int i = pairs.length - 1 ; i >= 0; i--) {
      if (amount >= pairs[i][0]) {
        return pairs[i][1];
      }
    }
    throw new IllegalArgumentException("amount = " + amount);
  }
}

/*
 *  割引きプランを表すクラス
 */
class DiscountPlan extends RatePlan {
  private final TierTable discountTiers;

  DiscountPlan(String name, double basicCharge,
               TierTable pricingTiers, TierTable discountTiers) {
    super(name, basicCharge, pricingTiers);
    this.discountTiers = discountTiers;
  }

  //割引後の料金を計算する
  int getPrice(double amount) {
    int price = super.getPrice(amount);

    //for debug
    System.out.println("割引前料金は、" + price + "円");
    System.out.println("割引率は" + discountTiers.map(price)*100+"%");
    return (int)(price * (1.0 - discountTiers.map(price)));
  }
}

/*
 *  メイン
 */
public class Main {
  public static void main(String[] args) {
    //RatePlanインスタンスを取得
    RatePlan planA = new RatePlan("プランA", 1123.30,
                                  new TieredRateTable(0, 19.62, 120, 26.10, 300, 30.12));
    RatePlan planB = new RatePlan("プランB", 1040.10,
                                  new TieredRateTable(0, 18.17, 120, 24.17, 300, 27.77));

    //DiscountPlanのインスタンスを取得
    DiscountPlan discountPlanA = new DiscountPlan("割引A", 1123.30,
        new TieredRateTable(0, 19.62, 120, 26.10, 300, 30.12),
        new DiscountTable(5000, 0.01, 7999, 0.03, 8000, 0.05));
    DiscountPlan discountPlanB = new DiscountPlan("割引B", 1040.10,
        new TieredRateTable(0, 18.17, 120, 24.17, 300, 27.77),
        new DiscountTable(5000, 0.01, 7999, 0.03, 8000, 0.05));

    double amount = 543.0;
    System.out.printf("【電力量が%.1fのとき】\n", amount);

    //通常料金を計算し表示する
    System.out.println("プランAの料金は" + planA.getPrice(amount));
    System.out.println("プランBの料金は" + planB.getPrice(amount));
    int d = planA.getPrice(amount) - planB.getPrice(amount);
    //差額を計算する
    if (d < 0) {
      System.out.printf("%sが%d円安い%n",
                        planA.getName(), -d);
    } else if ( d > 0) {
      System.out.printf("%sが%d円安い%n",
                        planB.getName(), d);
    } else {
      System.out.println("両プランで同額");
    }

    //割引料金を計算し表示する
    System.out.println("【割引きプランの料金】");
    int discountA = discountPlanA.getPrice(amount);
    int discountB = discountPlanB.getPrice(amount);
    System.out.println("割引時のプランAの料金は" + discountA);
    System.out.println("割引時のプランBの料金は" + discountB);
    //差額を計算する
    int d2 = discountA - discountB;
    if (d2 < 0) {
      System.out.printf("%sが%d円安い%n",
                        planA.getName(), -d2);
    } else if ( d2 > 0) {
      System.out.printf("%sが%d円安い%n",
                        planB.getName(), d2);
    } else {
      System.out.println("両プランで同額");
    }
  }
}
