/**
 * R1 java test
 * 2020/03/17
 */

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NotificationListener
 */
interface NotificationListener {
  void onNotificationReceived(List<String> messageList);
}

/**
 * MobileDevice
  */
final class MobileDevice {
  private final String name;
  private final NotificationListener listener;

  public MobileDevice(String name, NotificationListener listener) {
    this.name = name;
    this.listener = listener;
  }

  /**
   * getListener()
   * @return []
   */
  public NotificationListener getListener() {return listener;}

  /**
   * [getName() ]
   * @return []
   */
  public String getName() {return name;}
}

final class Notifier {
  private static final Notifier INSTANCE = new Notifier();

  private final Object lock = new Object();
  //利用者ごとに携帯端末を管理
  private final Map<String, List<MobileDevice>> userMobileDevices = new HashMap();
  //端末ごとに通知メッセージを管理
  private final Map<MobileDevice, List<String>> messagesToDeliver = new HashMap();

  private volatile boolean active = true;

  public static Notifier getInstance() {return INSTANCE;}

  private Notifier() {}

  /**
   * [register() ]
   * @param user   []
   * @param device []
   */
  public void register(String user, MobileDevice device) {
    synchronized (lock) {
      //userごとの携帯端末(List)を設定する
      List<MobileDevice> devices = userMobileDevices.get(user);
      if (devices == null) {    //端末が登録されてない時
        divices = new ArrayList<>();
        //TODO:
        userMobileDevices.put(user, devices);
      }
      devices.add(device);
    }
  }

  /**
   * send()
   * @param user    []
   * @param message []
   */
  public void send(String user, String message) {
    List<MobileDevice> devices = new ArrayList<>();

    synchronized (lock) {
      if (userMobileDevices.containsKey(user)) {  //(user)の端末が登録されている時
        //端末ごとにメッセージリストを生成
        for (MobileDevice device : userMobileDevices.get(user)) {
          List<String> messageList = messagesToDeliver.get(device);
          if (messageList == null) {  //メッセージリストがない時
            messageList = new ArrayList<>();
            messagesToDeliver.put(device, messageList);
          }
        }
      }
    }

  }
}

public class Tester {
  public static void main(String[] args) {
    System.out.println("aaa");
  }
}

