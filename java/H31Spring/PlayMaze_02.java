/**
 * H31 Spring
 * 2020/03/28
 */

import java.util.ArrayList;
import java.util.List;

class Maze {

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
   */
  public Maze(String mazeData, int width) {
    this.mazeData = mazeData;
    this.width = width;
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
    return new Location(index % width, index / width);
  }
}

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
  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
