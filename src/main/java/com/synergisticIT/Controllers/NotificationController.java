package com.synergisticIT.Controllers;

import com.synergisticIT.Domain.Notification;
import com.synergisticIT.Service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping("notificationForm")
    public String notificationForm(Model model){
        System.out.println("Notification page Reached");
        getModel(model);

        return "notificationForm";
    }

    @RequestMapping("saveNotification")
    public String saveNotification(@Valid @ModelAttribute("notification") Notification notification, BindingResult result, Model model){

        if(result.hasErrors()){
            getModel(model);
            return "notificationForm";
        }

        notificationService.addNotification(notification);

        return "redirect:notificationForm";
    }

    @RequestMapping("deleteNotification")
    public String deleteNotification(BindingResult result, Model model, Notification notification){
        if(result.hasErrors()){
            return "airlinesForm";
        }
        notificationService.deleteNotification(notification.getNotificationId());

        return "redirect:notificationForm";
    }



    public Model getModel(Model model){
        return model;
    }
}
