package com.synergisticIT.Service;

import com.synergisticIT.Domain.Notification;
import com.synergisticIT.Domain.Publisher;

import java.util.List;

public interface NotificationService {

    Notification addNotification(Notification notification);
    List<Notification> getAllNotifications();
    void deleteNotification(Integer notificationId);
    void sendNotification(Notification notification);
    Notification getNotificationById(Integer notificationId);

}
