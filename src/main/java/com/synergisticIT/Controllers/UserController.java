package com.synergisticIT.Controllers;

import com.synergisticIT.Domain.User;
import com.synergisticIT.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("userForm")
    public String userForm(Model model){
        System.out.println("User page Reached");
        getModel(model);

        return "userForm";
    }

    @RequestMapping("saveUser")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){

        if(result.hasErrors()){
            getModel(model);
            return "userForm";
        }

        userService.createUser(user);

        return "redirect:userForm";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(BindingResult result, Model model, User user){
        if(result.hasErrors()){
            return "airlinesForm";
        }
        userService.deleteUser(user.getUserId());

        return "redirect:userForm";
    }



    public Model getModel(Model model){
        return model;
    }
}
