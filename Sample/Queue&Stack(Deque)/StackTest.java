import java.util.ArrayDeque;
import java.util.Deque;

public class StackTest{
  public static void main(String[] args) {

    //String型のDeque(Last In Last Out)を取得する
    Deque<String> deque = new ArrayDeque<>();
    //Dequeに要素を追加する
    deque.push("fu");
    deque.push("ji");
    deque.push("mu");
    deque.push("ra");

    //print
    System.out.println(deque);

    //要素を一つ取り出してDequeから削除する
    System.out.println(deque.pop());

    //ひとつ削除されたことを確認する
    System.out.println(deque);

    //削除せずに要素をひとつ参照する
    System.out.println(deque.peek());

    //削除されてないことを確認する
    System.out.println(deque);
  }
}