import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

/*
 *電卓のキーが押されたときの処理を定義するインターフェイス
 */
interface Key {
  public void operateOn(Stack<Integer> stack);
}

/*
 *数字キーを表す定数DIGI０~DIGI9を定義する列挙型
 */
enum DigitKey implements Key {
  DIGI0, DIGI1, DIGI2, DIGI3, DIGI4,
  DIGI5,  DIGI6, DIGI7, DIGI8, DIGI9;

  //キーを10進数として処理する
  @Override
  public void operateOn(Stack<Integer> stack) {

    //for debug
    System.out.println(
      "【OperateOn】before:stack.peek():"
      + stack.peek());
    System.out.println("ordinal():" + ordinal());
    // stackから値を取り出し（後入れ後出し10をかけ、enumでの順番を加算しStackに戻す。
    stack.push(stack.pop() * 10 + ordinal());
    System.out.println(
      "【OperateOn】after:stack.peek():"
      + stack.peek());
  }
}

/*
 *各演算キーを定義する
 */
enum OperationKey implements Key {
  ADD, SUBSTRACT, MULTIPLY, DIVIDE, EQUAL, CLEAR;

  //各演算キーに対する演算を行う
  @Override
  public void operateOn(Stack<Integer> stack) {
    if (this == EQUAL || this == CLEAR) {
      return;
    }
    int val2 = stack.pop();
    int val1 = stack.pop();
    stack.push(calculate(val1, val2));
  }

  private int calculate (int val1 , int val2) {
    switch (this) {
    case ADD:
      return val1 + val2;
    case SUBSTRACT :
      return val1 - val2;
    case MULTIPLY :
      return val1 * val2;
    case DIVIDE:
      return val1 / val2;
    default:
      throw new AssertionError(toString());
    }
  }
}

/*
 *電卓本体を表す。
 */
class Calculator {
  //後入れ後出しのDequeを定義する
  private final Stack<Integer> stack = new Stack<Integer>();
  private Key pendingKey;

  //コンストラクタ
  public Calculator() {
    stack.push(0);    //stackに0を格納する。
  }

  public void onKeyPressed(Key key) {
    System.out.println(key);

    //押されたキーがDigitKeyかどうかを判断する。
    if (key instanceof DigitKey) {
      if (pendingKey == OperationKey.EQUAL) {
        reset();
      }
      System.out.println("Calculator.onKeyPressed.key:"
                         + key);
      //operateOnメソッドで列挙型をint型にしてスタックに入れ直す
      key.operateOn(stack);
      System.out.println(stack.peek() + " OnKeyPressed");
    } else if (key == OperationKey.CLEAR) {
      reset();
      System.out.println(stack.peek());
    } else {
      try {
        if (pendingKey != null) {
          //pendingKeyに演算子が入っていれば該当する計算を行う。
          pendingKey.operateOn(stack);
        }
        System.out.println(stack.peek());
        // pendingkeyがnullなら演算子をだいにゅうする
        pendingKey = key;
        if (key != OperationKey.EQUAL) {
          //イコールのみが押されたときはスタックに0を入れる
          stack.push(0);
        }
      } catch (ArithmeticException e) {
        System.out.println("ERROR");
        reset();
      }
    }
  }

  private void reset() {
    stack.clear();      //stackを空にして
    stack.push(0);      //0を追加する
    pendingKey = null;
  }
}

/*
 *動作確認用クラス
 */
public class CalculatorTest {
  public static void main(String[] args) {

    //Character型のキー、Key型の要素を持つmapを取得する。
    Map<Character , Key> map =
      new HashMap<Character, Key>();
    //文字と列挙OperationKeyの定数の対応をmapに格納する。
    //enum OperationKeyの要素をすべて取り出し拡張for文で回す。
    for (OperationKey key : OperationKey.values()) {
      //そのキーのenumにおける順番をordinal()で取得し、
      //「+-*/=C」の中の該当する順番のものをキーにしてmapに格納する
      //for debug
      System.out.println("key.ordinal():" + key.ordinal());
      System.out.println(
        "\"+-*/=C\".charAt(key.ordinal()):" +
        "+-*/=C".charAt(key.ordinal()));
      System.out.println("OperationKey:" + key);

      map.put("+-*/=C".charAt(key.ordinal()), key);
    }

    //enum DigitKeyの要素をすべて取り出し拡張for文で回す
    for (DigitKey key : DigitKey.values() ) {
      //DigitKeyのenumにおける順番を取得し、
      //”0123456789”の中から該当するものをキーとしてmapに格納する。
      //for debug
      System.out.println(
        "\"0123456789\".charAt(key.ordinal()):" +
        "0123456789".charAt(key.ordinal()));
      System.out.println("DigitKey:" + key);
      // 数字と列挙DigitalKeyの定数の対応をmapに格納する
      map.put("0123456789".charAt(key.ordinal()), key);
    }

    Calculator calc = new Calculator();
    String chars = args[0];

    //charsの各文字をキーの定数に変換し、
    //メソッドonKeyPressedを呼び出す
    for (int i = 0; i < chars.length() ; i++ ) {
      calc.onKeyPressed(map.get(chars.charAt(i)));
    }
  }
}