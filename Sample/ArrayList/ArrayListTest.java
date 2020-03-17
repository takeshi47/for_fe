import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
  public static void main(String[] args) {

    //ex. List
    List<String> list = new ArrayList<>();

    list.add("fu");
    list.add("ji");
    list.add("mu");
    list.add("ra");

    //拡張for文
    for (String str : list ) {
      System.out.print(str);
    }

    //forEachメソッド
    list.forEach(System.out::print);
  }
}