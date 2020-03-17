/**
 * 2020/01/22
 * アルゴリズム「ジャンケン」
 */
public class Janken {
	/**
	 * ジャンケンの手を返す
	 * @param  i [description]
	 * @return   [description]
	 */
	public static String hand(int i) {
		String hand;

		switch (i) {
		case 1:
			hand = "グー";
			break;
		case 2:
			hand = "ちょき";
			break;
		case 3:
			hand = "パー";
			break;
		default:
			hand = "エラー";
		}
		return hand;
	}

  /**
   * 勝敗判定
   * @param i [description]
   * @param j [description]
   */
	public static void judge(int i, int j) {
    int x = (i - j + 3) % 3;
    if (x == 0) {
      System.out.println("draw");
    } else {
      if (x == 1) {
        System.out.println("hanako win!");
      } else {
        System.out.println("taro win!");
      }
    }
	}
  /**
   * main「しめじのオイスターソース炒め」は画像がありませんが、画像リンクパーツは3枚並びを設定し、キャプションに「しめじのオイスターソース炒め」を移行していますが宜しいでしょうか。なお、このキャプションはプレビューでは表示されませんでした。
   * @param args [description]
   */
	public static void main(String[] args) {
    judge(1,2);
	}
}