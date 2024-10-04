package com.synergisticIT.Service.Implementation;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Domain.Notification;
import com.synergisticIT.Repositories.NotificationRepository;
import com.synergisticIT.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public Notification addNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public void deleteNotification(Integer notificationId) {
        Notification foundNotification = getNotificationById(notificationId);
        if(foundNotification != null){
            notificationRepository.delete(foundNotification);
        }
    }

    @Override
    public void sendNotification(Notification notification) {

    }

    @Override
    public Notification getNotificationById(Integer notificationId) {
        return notificationRepository.findById(notificationId).orElse(null);
    }

    @Override
    public Page<Notification> findAllPaginiated(int page, int size) {
        return notificationRepository.findAll(PageRequest.of(page, size));
    }


}
