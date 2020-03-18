/**
 * R1 java test
 * 2020/03/17
 */
package src;

import java.util.List;

public interface NotificationListner {
  void onNotificationReceived(List<String> messageList);
}