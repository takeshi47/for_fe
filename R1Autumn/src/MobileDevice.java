/**
 * Mobile Device
 * 2020/03/17
 */
package src;

import src.NotificationListner;

public final class MobileDevice {
  private final String name;
  private final NotificationListner listener;

  public MobileDevice(String name, NotificationListener listener) {
    this.name = name;
    this.listener = listener;
  }
}