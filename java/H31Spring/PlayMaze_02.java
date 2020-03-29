/**
 * H31 Spring
<<<<<<< HEAD
 * 2020/03/23
=======
 * 2020/03/28
>>>>>>> 03d5445... a
 */

import java.util.ArrayList;
import java.util.List;

class Maze {

<<<<<<< HEAD
  private final String mazeData;
  private final int width;
  private final Location startLocation;

  /**
   * [Maze()]
   * @return ()]
=======
  /**
   * @value String mazeData
   */
  private final String mazeData;
  /**
   * @value int maze's width
   */
  private final int width;
  /**
   * @value start locate
   */
  private final Location startLocation;

  /**
   * maze()
>>>>>>> 03d5445... a
   */
  public Maze(String mazeData, int width) {
    this.mazeData = mazeData;
    this.width = width;
<<<<<<< HEAD
    startLocation = locationOf('S');
  }

  public Location getStartLocation() {return startLocation;}

  public boolean isGoal(Location loc) {
    //TODO:a
    return mazeData.charAt(loc.y * width + loc.x) == 'G';
  }

  public boolean isBlank(Location loc) {
    //TODO:a
    return mazeData.charAt(loc.y * width + loc.x) != '*';
  }

  private Location locationOf(char c) {
    int index = mazeData.indexOf(c);

    //TODO:b
=======
    //スタート地点のx、y座標を設定する。
    startLocation = locationOf('S');
  }

  /**
   * [getStartLocation ]
   * @return start location
   */
  public Location getStartLocation() {return startLocation;}

  /**
   * [isGoal ]
   * @param Location loc
   * @return is goal
   */
  public boolean isGoal(Location loc) {
    //引数のlocの持つx,y座標がゴールかどうかを判定する。
    return mazeData.charAt(loc.y * width + loc.x) == 'G';
  }

  /**
   * [isBlank ]
   * @param Location loc
   * @return is blank
   */
  public boolean isBlank(Location loc) {
    //引数のlocの持つ座標が通路かどうか判定する。
    return mazeData.charAt(loc.y * width + loc.x) != '*';
  }
  /**
   * [locationOf ]
   * @param  c []
   * @return   []
   */
  private Location locationOf(char c) {

    /**
     * @value int
     */
    int index = mazeData.indexOf(c);

    //引数のに指定した種類の座標を持つインスタンスを返す
    //ex.)Goal,Start,*
>>>>>>> 03d5445... a
    return new Location(index % width, index / width);
  }
}

<<<<<<< HEAD
/**
 *
 */
class Piece {

  private final Maze maze;
  private Location location;
  private Direction direction = Direction.NORTH;
  private final List<Direction> history = new ArrayList<>();

  public Piece(Maze maze) {
    this.maze = maze;
    location = maze.getStartLocation();
  }

  public void turnLeft() {direction = direction.left();}

  public void turnRight() {direction = direction.right();}

  public boolean tryStepForward() {
    //TODO:c
    Location nextLocation = new Location(location.x + direction.dx, location.y + direction.dy);

    if (maze.isBlank(nextLocation)) {
      location = nextLocation;
      history.add(direction);
      return true;
    }
    return false;
  }

  public boolean isAtGoal() {return maze.isGoal(location);}

  public List<Direction> getHistory() {return new ArrayList<>(history);}
}

enum Direction {
  NORTH(0, -1), EAST(1, 0), SOUTH(0, 1), WEST(-1, 0);

  public int dx, dy;

  private Direction (int dx, int dy) {
    this.dx = dx;
    this.dy = dy;
  }

  //クラスメソッドvalues()は、この列挙で定義している列挙定数を、
  //定義順に格納した配列を返す。
  //メソッドordinal()は、この列挙定数の定義順(先頭は0)を返す。
  public Direction left() {return values()[(ordinal() + 3) % 4];}  //TODO:d

  public Direction right() {return values()[(ordinal() + 1) % 4];}
}

class Location {
  public final int x, y;

=======
class Location {

  /**
   * @value int x, y
   */
  public final int x, y;

  /**
   * [Location]
   * @param int x
   * @param int y
   * @return
   */
>>>>>>> 03d5445... a
  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
<<<<<<< HEAD

public class PlayMaze {
  public static void main(String... args) {
    Maze maze = new Maze("*******" +
                         "*..*..*" +
                         "*S**.**" +
                         "*.....*" +
                         "*****.*" +
                         "*G....*" +
                         "*******", 7);

    Piece piece = new Piece(maze);
    while (!piece.isAtGoal()) {
      piece.turnLeft();
      while (!piece.tryStepForward()) {
        piece.turnRight();
      }
    }
    List<Direction> history = piece.getHistory();

    for (int i = 1; i < history.size(); i++) {//TODO:e
      if(history.get(i - 1) == history.get(i).left().left()) {
        history.remove(i - 1);//TODO:f
        history.remove(i - 1);//TODO:f
        i = i < 2 ? 0 : i -2;
      }
    }


    System.out.println(history);
  }
}
=======
>>>>>>> 03d5445... a
