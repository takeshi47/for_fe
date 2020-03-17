import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class SortStringTest {
  public static void main(String[] args) {

    String[] strings = { "melon", "orange", "apple"};

    Arrays.sort(strings);

    System.out.println(strings);
    System.out.println(Arrays.asList(strings));

    ArrayList<String> arraysString = new ArrayList<>();

    arraysString.add("melon");
    arraysString.add("orange");
    arraysString.add("apple");

    Collections.sort(arraysString);

    System.out.println(arraysString);
  }
}