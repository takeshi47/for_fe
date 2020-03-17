import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class TableSorter {
  private Map<String, Comparator<String>> orderMap = new HashMap<String, Comparator<String>>();

  public void putSortOrder(String key , Comparator<String> order) {
    //for debug
    System.out.println("putSortOrder()内のkey:" + key + ",order:" + order);
    orderMap.put(key, order);
  }

  public void sort(String[][] table,
                   final OrderBy... orderBys) {
    Arrays.sort(table, new Comparator<String[]>() {
      public int compare(String[] s1, String[] s2) {
        for (OrderBy orderBy : orderBys  ) {
          int order = orderMap.get(orderBy.key).
                      compare(s1[orderBy.col],
                              s2[orderBy.col]);

          //for debug
          System.out.println("Array.sort()内のorder:" + orderBy.col);
          if (order != 0) {
            return orderBy.isReversed ? -order : order;
          }
        }
        return 0;
      }
    });
  }
  public static class OrderBy {
    final String key;
    final int col;
    final boolean isReversed;

    public OrderBy(String key, int col) {
      this(key, col, false);
    }

    public OrderBy(String key, int col ,
                   , boolean isReversed) {
      this.key = key;
      this.col = col;
      this.isReversed = isReversed;
    }
  }
}

/*
 *  メイン
 */
public class TableSorterTester {
  public static void main(String[] args) {

    //Test用配列
    String[][] data = new String[][] {
      {"apple", "3", "1,000"},
      {"cherry", "1", "1,000"},
      {"banana", "1", "300"},
      {"banana", "2", "2,000"},
      {"apple", "2", "300"},
    };

    //TableSorterインスタンスを取得
    TableSorter sorter = new TableSorter();

    sorter.putSortOrder("lex", new Comparator<String>() {

      public int compare(String o1, String o2) {
        //for debug
        System.out.println("sorter.putSortOrder() o1:" + o1 + ",o2:" + o2);
        System.out.println(o1.compareTo(o2));
        return o1.compareTo(o2);
      }
    });

    sorter.putSortOrder("num", new Comparator<String>() {
      public int compare(String o1, String o2) {
        return new Integer(o1).compareTo(new Integer(o2));
      }
    });
    /*
     *  ver.1
     */
    sorter.sort(data,
                new TableSorter.OrderBy("lex", 0),
                new TableSorter.OrderBy("num", 1, true));

    /*
     *  ver.2
     */
    // sorter.sort(data, new TableSorter.OrderBy("lex", 2),
    //             new TableSorter.OrderBy("lex", 0));

    /*
     *  ver.3
     */
    // sorter.putSortOrder("numC", new Comparator<String>() {
    //   public int compare(String s1, String s2) {
    //     return new Integer(s1.replace(",","")).
    //     compareTo(new Integer(s2.replace(",","")));
    //   }
    // });
    // sorter.sort(data, new TableSorter.OrderBy("numC",2),
    //   new TableSorter.OrderBy("lex",0));

    //print
    for (String[] row : data) {
      for (String col : row ) {
        System.out.printf("%s", col);
      }
      System.out.println();
    }
  }
}