import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest{
  public static void main(String[] args){

    //String型のDeque(First In First Out)を取得する
    Queue<String> queue = new ArrayDeque<>();
    //dequeにデータを追加する.
    queue.add("fu");
    queue.add("ji");
    queue.add("mu");
    queue.add("ra");
    //print
    System.out.println(queue);

    //値を1個取り出して表示（First In First Out）
    System.out.println(queue.poll());

    //リストから値が削除されたことを確認する
    System.out.println(queue);

    //リストから値を取り出さずに参照する
    System.out.println(queue.peek());

    //リストの要素が削除されてないことを確認する。
    System.out.println(queue);
  }
}