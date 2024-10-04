package com.synergisticIT.Controllers;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping("authorForm")
    public String authorForm(Model model){
        System.out.println("Author page Reached");
        getModel(model);

        return "authorForm";
    }

    @RequestMapping("saveAuthor")
    public String saveAuthor(@Valid @ModelAttribute("author") Author author, BindingResult result, Model model){

        if(result.hasErrors()){
            getModel(model);
            return "authorForm";
        }

        authorService.addAuthor(author);

        return "redirect:authorForm";
    }

    @RequestMapping("deleteAuthor")
    public String deleteAuthor(BindingResult result, Model model, Author author){
        if(result.hasErrors()){
            return "airlinesForm";
        }
        authorService.deleteAuthor(author.getAuthorId());

        return "redirect:authorForm";
    }



    public Model getModel(Model model){
        return model;
    }
}
