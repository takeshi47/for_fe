/**
 * H28Spring
 * 2020/03/13
 */
public class ArgMemo {

  /**
   * @var int memoCnt
   */
  private int memoCnt = 0;

  /**
   * @var int memoMax
   */
  private int memoMax = 5;

  /**
   * @var int dataLen
   */
  private int dataLen = 0;

  /**
   * @var int dataMax
   */
  private int dataMax = 25;

  /**
   * @var int[] memo
   */
  private int[] memo = new int[memoMax];

  /**
   * @var string[] data
   */
  private String[] data = new String[dataMax];

  /**
   * [resetMemo ]
   */
  public void resetMemo() {
    this.memoCnt = 0;
    this.dataLen = 0;
  }

  /**
   * [addMemo ]
   * @param textLen []
   * @param text    []
   */
  public void addMemo(int textLen, String[] text) {

    this.memo[memoCnt] = dataLen;   //メモのポインタを更新する
    this.memoCnt++;                     //メモの個数を更新する
    this.data[this.dataLen] = String.valueOf(textLen); //追加する文字の長さを格納する
    this.dataLen++;                     //合計文字数を更新する

    //文字列を格納するループ
    for (int i = 0; i < textLen; i++) {
      data[dataLen + i] = text[i];
    }

    dataLen += textLen;                 //合計文字数を更新する

    // output
    System.out.println("addMemo");
    System.out.print("追加する文字数:" + textLen + ", 追加する文字列:");
    for (String str : text) System.out.print(str + " ");
    this.print(this.data);
  }

  /**
   * [deleteMemo ]
   * @param  int pos
   */
  public void deleteMemo(int pos) {

    System.out.println("【delete memo】");
    System.out.println((pos + 1) + "番目のメモを削除する");
    System.out.println("削除前件数:" + memoCnt);
    for (int i = pos + 1; i < memoCnt; i++) {

      //指定した件数より後ろにあるポインタを前にずらす
      memo[i - 1] = memo[i];
    }
    //合計件数を更新する
    memoCnt--;
    System.out.println("削除後件数:" + memoCnt);
    for (int element : memo) System.out.print(element + ",");
    System.out.println();
  }

  public void changeMemo(int pos, int textLen, String[] text) {

    System.out.println("[changeMemo]");

    memo[pos] = dataLen;      //ポインタを更新
    data[dataLen] = String.valueOf(textLen);  //追加する文字数をを登録する
    dataLen ++;               //格納してる文字数を更新する

    for (int i = 0; i < textLen; i++) {
      data[dataLen + i] = text[i];
    }
    dataLen += textLen;
    this.print(this.data);
    this.print(this.memo);
  }

  /**
   * [moveMemo ]
   * @param fromPos []
   * @param toPos   []
   */
  public void moveMemo(int fromPos, int toPos) {

    System.out.println("【move memo】");
    System.out.print("before pointer: ");
    this.print(this.memo);

    int m = memo[fromPos];
    if (fromPos < toPos) {
      //要素を後ろに移動する時、移動前の位置より後ろの要素を前にずらす
      for (int i = fromPos; i <= toPos; i++) {
        memo[i] = memo[i + 1];
      }
    } else if (fromPos > toPos) {

      System.out.println("fromPos:" + fromPos + ", toPos:" + toPos);
      //要素を前に移動する場合、移動前の位置より前の要素を後ろにずらす
      for (int i = fromPos; i >= toPos + 1; i--) {
        memo[i] = memo[i - 1];
      }
    }

    memo[toPos] = m;      //ポインタを更新する
    System.out.print("after pointer: ");
    this.print(this.memo);
    this.print(this.data);
  }

  public void clearGarbage() {

    int d;
    String[] tmp = new String[this.data.length];

    this.dataLen = 0;
    if (memoCnt == 0) return; //メモの件数が0の時

    for (int m = 0; m < memoCnt; m++) {
      d = memo[m];      //m番目のポインタを一時保存
      System.out.println("dataLen : " + dataLen);
      System.out.println(m + "番目の文字列は・・・" + "d:" + d + "の位置にある");
      System.out.println(m + "番目の文字列の長さは・・・" + "data[d]:" + data[d] + "文字");

      System.out.println(m + "番目の文字列へのポインタをdataLen:" + dataLen + "で更新する");
      memo[m] = dataLen;

      //TODO:try-cathch書く
      for (int i = 0; i <= Integer.parseInt(data[d]); i++) {

        System.out.println(d + "の位置にある文字数と文字列を一時的に保持する。\ndata[d + " + i + "]: " + data[d + i]);
        tmp[dataLen] = data[d + i];
        dataLen ++;
        // System.out.println("dataLen:" + dataLen);
      }
    }

    System.out.print("tmp[]:");
    for (String str : tmp) System.out.print(str + ",");
    System.out.println();

    for (d = 0; d < dataLen; d++) {
      data[d] = tmp[d];
    }

    print(data);
    print(memo);

    System.out.println("1番目の文字へのポインタはmemo[1]:" +memo[1]);
    System.out.println("2番目の文字へのポインタはmemo[2]:" +memo[2]);
    System.out.println("格納してる文字数の合計は" +dataLen);
  }


  /**
   * [print memo]
   */
  public void print(String[] data) {
    for (String str : data) System.out.print(str + " ");
    System.out.println("\n");
  }

  /**
   * [print pointer]
   */
  public void print(int[] data) {
    System.out.print("print pointer : ");
    for (int str : data) System.out.print(str + " ");
    System.out.println("\n");
  }

  /**
   * [main description]
   * @param args [description]
   */
  public static void main(String[] args) {

    ArgMemo argMemo = new ArgMemo();
    argMemo.resetMemo();

    String[] text = {"a", "o", "k", "i"};
    String[] text2 = {"i" , "m", "a", "i"};
    String[] text3 = {"u" , "n", "o"};
    String[] text4 = {"e" , "n", "d", "o"};
    String[] text5 = {"a" , "b", "e"};

    argMemo.addMemo(text.length, text);
    argMemo.addMemo(text2.length, text2);
    argMemo.addMemo(text3.length, text3);
    argMemo.addMemo(text4.length, text4);

    argMemo.print(argMemo.memo);

    argMemo.deleteMemo(0);

    argMemo.print(argMemo.memo);

    argMemo.changeMemo(2, text5.length, text5);

    argMemo.moveMemo(2, 0);

    argMemo.clearGarbage();
  }
}