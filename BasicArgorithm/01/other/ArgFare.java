/**
 * calc fare
 * 2020/03/15
 */
public class ArgFare {

  /**
   * @value distance table
   */
  private final int[] distance = {
    10, 20, 40, 80, 160, 99999
  };

  /**
   * @value price by distance table
   */
  private final int[] price = {
    150, 30, 20, 15, 10
  };

  /**
   * @value fixed fee
   */
  private final int[] fixedFee = {
    250, 150, 200, 300, 400, 0
  };

  /**
   * [calc ]
   * @param rd []
   */
  public void calc(int rd) {

    int total = price[0];      //合計金額を基本料金で初期化

    if (distance[0] < rd) {

      int i = 1;
      //区分ごとの料金を計算するループ
      for (i = 1; distance[i] < rd; i++) {

        System.out.println("合計金額に{(distance[" + i + "]:" + distance[i] + " - distance[" + (i - 1) + "]:" + distance[i - 1] + ") * price[" + i + "]:" + price[i] + "}を足していく");

        total += (distance[i] - distance[i - 1]) * price[i];
      }
      //区分の端数距離の料金を計算する
      if (i < distance.length) {
        total += (rd - distance[i - 1]) * price[i];
        System.out.println("乗車距離:" + rd + "kmの料金は" + total + "円です。");
      } else {
        System.out.println("error!");
      }

    }
  }

  public void fixedFeeCalc(int rd) {

    int total = 0;
    int i = -1;

    //区分ごとの料金を計算する
    do {
      i++;
      total += fixedFee[i];
      System.out.println("total:" + total);
      System.out.println("distance[i]:" + distance[i] + ", rd:" + rd);
    } while (distance[i] < rd);
  }

  /**
   * main
   * @param args []
   */
  public static void main(String[] args) {

    ArgFare argFare = new ArgFare();

    int distance = 45;
    argFare.calc(distance);
    argFare.fixedFeeCalc(distance);
  }
}