/**
 * move string
 * 2020/03/14
 */
public class ArgMoveString {

  /**
   * [strInsert]
   * @param a
   * @param aLength
   * @param b
   * @param bLength
   * @param position
   */
  public static void strInsert(String[] a, int aSize, String[] b, int bSize, int position) {

    //bofore insert
    //挿入される配列からあふれる文字があるかを調べる
    if (position < aSize + 1) {     //もともと入っている文字列の中に挿入する時

      System.out.print("挿入位置:" + (position + 1) + " < ");
      System.out.print("aSize:" + aSize + ", ");
      System.out.println("なのでもともとの文字列aの途中に文字列bを挿入する\n");

      int y = min((a.length - 1) - bSize, aSize);
      System.out.println("挿入される文字数:aSize = " + aSize);
      System.out.println("挿入する文字数　:bSize = " + bSize);

      //挿入する文字数分、挿入箇所から後ろを後ろに移動させる
      for (int x = y; x >= position; x--) {
        System.out.println("position:" + position + ", x:" + x);
        System.out.println("bSize + x:" + (bSize + x));
        System.out.println("a[x]:" + a[x] + "=> a[bsize + x]:" + a[bSize + x]);
        System.out.println();

        a[bSize + x] = a[x];
        a[x] = "@";
      }

      for (String str : a) System.out.print(str + ",");
      System.out.println();

    } else if (position > aSize) {   //挿入位置が既存文字数に等しいときは何もしない
      //既存文字列の最後尾と挿入位置の間に空白(@)を挿入する
      for (int x = (aSize + 1) - 1; x < position; x++) {
        a[x] = "@";
      }

      for (String str : a) System.out.print(str + ",");
      System.out.println();
    }

    //挿入処理
    //挿入位置 + 挿入文字数 と 既存配列の大きさを比較し、
    //小さい方を設定する
    int y = min((position + bSize), a.length);

    //挿入ループ
    for (int i = position; i < y; i++) {
      a[i] = b[i - position];
    }
  }

  /**
   * [min ]
   * @param  x []
   * @param  y []
   * @return min
   */
  public static int min(int x, int y) {
    if (x < y) return x;
    return y;
  }

  public static void main(String[] args) {

    String[] a = {
      "a", "b", "c", "@", "@",  "@", "@", "@", "@", "@"
    };
    int ax = 3;
    String[] b = {
      "1", "2", "3", "4", "4", "4", "4", "4"
    };
    int bx = b.length;
    int px = 2;

    System.out.println("配列の大きさ:" + a.length + ", 文字列の長さ:" + ax);
    for (String element : a)  System.out.print(element + ",");
    System.out.println();
    System.out.println("挿入する文字列の長さ:" + b.length + ", 挿入する位置:" + px);

    strInsert(a, ax , b, bx, px - 1);

    for (String element : a)  System.out.print(element + ",");

  }
}