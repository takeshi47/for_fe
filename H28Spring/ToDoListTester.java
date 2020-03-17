import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

/*
 *  ToDoを表すクラス
 */
class ToDo {
  //ToDoの重要度を示す列挙
  public enum Priority {LOW, MIDDLE, HIGH}
  //ToDoの状態を示す列挙
  public enum State {NOT_YET_STARTED, STARTED, DONE}

  //8桁または12桁の数字からなる文字列と一致する正規表現
  private static final String DEADLINE_PATTERN =
    "\\d{8}|\\d{12}";

  private final String id;  //ToDoを識別するID
  private String subject;   //ToDoの主題
  private String deadLine;  //ToDoの期限
  private Priority priority;         //ToDoの優先順位
  private State state;      //ToDoの状態

  private ToDo(String subject , String deadLine, Priority priority, String id, State state) {
    //指定された日時に誤りがあれば例外を投げる
    if (!deadLine.matches(DEADLINE_PATTERN)) {
      throw new IllegalArgumentException();
    }
    this.subject = subject;
    this.deadLine = deadLine;
    this.priority = priority;
    this.id = id;
    this.state = state;
  }

  public ToDo(String subject, String deadLine,
              Priority priority) {
    this(subject, deadLine, priority,
         //randomUUID()で一意なidを取得しString型にする。
         UUID.randomUUID().toString(),
         //ToDoの状態をNOT_YET_STARTED
         State.NOT_YET_STARTED);
  }

  public ToDo(ToDo todo) {
    this(todo.subject, todo.deadLine, todo.priority,
         todo.id, todo.state);
  }

  //setter & getter
  public String getSubject() {return subject;}
  public String getDeadLine() {return deadLine;}
  public Priority getPriority() {return priority;}
  public State getState() {return state;}
  public String getId() {return id;}
  public void setState(State state) {this.state = state;}
  public void setDeadLine(String deadLine) {this.deadLine = deadLine;}
  public void setPriority(Priority priority) {this.priority = priority;}
  public int hashCode() {return id.hashCode();}
  public boolean equals(Object o) {
    return o instanceof ToDo && ((ToDo)o).id.equals(id);
  }

  public String toString() {
    return String.format("主題:%s、期限:%s、優先度:%s、状態:%s", subject, deadLine, priority, state);
  }
}

/*
 *  ToDoリストを表すクラス
 */
class ToDoList {
  private List<ToDo> todoList = new ArrayList<ToDo>();

  /*
   *ToDoを追加する
   */
  public void add(ToDo todo) {
    if (!todoList.contains(todo)) {
      //ArrayListにToDoを加える
      todoList.add(new ToDo(todo));
    }
  }

  /*
   *ToDoを更新する
   */
  public void update(ToDo todo) {
    //与えられたToDoの配列番号を取得する
    int index = todoList.indexOf(todo);
    //リストにないToDoが指定されたときは何もしない
    if (index != -1) {
      todoList.set(index, todo);
    }
  }

  /*
   *指定された条件のすべてと一致するToDoを返すメソッド
   */
  public List<ToDo> select(Condition... conditions) {
    List<ToDo> result = new ArrayList<ToDo>();
    for (ToDo todo : todoList ) {
      boolean selected = true;
      for (Condition condition : conditions) {
        selected = condition.test(todo);
        if (!selected)break;
      }
      //すべてのconditionに設定された条件に合致したときのみ、
      //結果用List<>に加えて、戻り値として返す。
      if (selected) {
        result.add(new ToDo(todo));
      }
    }
    return result;
  }

  /*
   *for debug
   */
  // public boolean test(Condition condition,ToDo todo){

  // }
}

/*
 *  ToDo選択時の条件を表すクラスが実装するクラス
 */
interface Condition {
  boolean test(ToDo todo);
}

/*
 *  テスト用
 */
public class ToDoListTester {
  public static void main(String[] args) {
    ToDoList list = new ToDoList();

    list.add(new ToDo("メール送信", "201604181500", ToDo.Priority.HIGH));
    list.add(new ToDo("ホテル予約", "20160420", ToDo.Priority.LOW));
    list.add(new ToDo("チケット購入", "20160430", ToDo.Priority.MIDDLE));
    list.add(new ToDo("報告書作成", "20160428", ToDo.Priority.HIGH));
    list.add(new ToDo("会議室予約", "201605301200", ToDo.Priority.HIGH));
    list.add(new ToDo("PC購入", "20160531", ToDo.Priority.HIGH));

    //条件を適用して検索し、該当したものの情報を更新する
    for (ToDo todo : list.select() ) {
      todo.setState(ToDo.State.STARTED);
      list.update(todo);
    }

    //無名クラスを宣言しインターフェイスを実装し検索条件をせっていする
    Condition condition1 = new Condition() {
      @Override
      public boolean test(ToDo todo) {
        return todo.getDeadLine().compareTo("20160530") < 0;
      }
    };
    Condition condition2 = new Condition() {
      @Override
      public boolean test(ToDo todo) {
        return todo.getPriority().equals(ToDo. Priority.HIGH);
      }
    };
    Condition condition3 = new Condition() {
      @Override
      public boolean test(ToDo todo) {
        return todo.getSubject().matches("PC.*");
      }
    };

    //検索条件を適用し、該当したものを表示する。
    for (ToDo todo : list.select(condition1) ) {
      System.out.println(todo);
    }

    System.out.println("\"Condition3 before update\"");
    for (ToDo todo : list.select(condition3)) {
      System.out.println(todo);
    }

    System.out.println("\"Condition3 after update\"");
    for (ToDo todo : list.select(condition3) ) {
      todo.setState(ToDo.State.NOT_YET_STARTED);
      todo.setDeadLine("20200229");
      todo.setPriority(ToDo.Priority.LOW);
      //update
      list.update(todo);
      System.out.println(todo);
      System.out.println("HashCode" + todo.hashCode());
    }
  }
}