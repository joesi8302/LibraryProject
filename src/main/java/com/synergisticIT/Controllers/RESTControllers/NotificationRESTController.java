package com.synergisticIT.Controllers.RESTControllers;

import com.synergisticIT.Domain.Notification;
import com.synergisticIT.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationRESTController {

    @Autowired
    NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification){
        Notification savedNotification = notificationService.addNotification(notification);

        return new ResponseEntity<>(savedNotification, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Integer id){
        Notification notification = notificationService.getNotificationById(id);
        if(notification != null){
            return new ResponseEntity<>(notification, HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications(){
        List<Notification> notificationList =  notificationService.getAllNotifications();
        return new ResponseEntity<>(notificationList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirlines(@PathVariable Integer id){
        Notification notification = notificationService.getNotificationById(id);
        if(notification != null){
            notificationService.deleteNotification(id);
            return new ResponseEntity<>("Notification deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Notification of id " + id+ " was not found", HttpStatus.NOT_FOUND);
        }
    }
}
