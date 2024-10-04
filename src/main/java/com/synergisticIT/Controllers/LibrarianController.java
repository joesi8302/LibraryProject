package com.synergisticIT.Controllers;

import com.synergisticIT.Domain.Librarian;
import com.synergisticIT.Service.LibrarianService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibrarianController {

    @Autowired
    LibrarianService librarianService;

    @RequestMapping("librarianForm")
    public String librarianForm(Model model){
        System.out.println("Librarian page Reached");
        getModel(model);

        return "librarianForm";
    }

    @RequestMapping("saveLibrarian")
    public String saveLibrarian(@Valid @ModelAttribute("librarian") Librarian librarian, BindingResult result, Model model){

        if(result.hasErrors()){
            getModel(model);
            return "librarianForm";
        }

        librarianService.createLibrarian(librarian);

        return "redirect:librarianForm";
    }

    @RequestMapping("deleteLibrarian")
    public String deleteLibrarian(BindingResult result, Model model, Librarian librarian){
        if(result.hasErrors()){
            return "airlinesForm";
        }
        librarianService.deleteLibrarian(librarian.getUserId());

        return "redirect:librarianForm";
    }



    public Model getModel(Model model){
        return model;
    }
}
