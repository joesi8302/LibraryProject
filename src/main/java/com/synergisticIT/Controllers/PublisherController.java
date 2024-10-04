package com.synergisticIT.Controllers;

import com.synergisticIT.Domain.Publisher;
import com.synergisticIT.Service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @RequestMapping("publisherForm")
    public String publisherForm(Model model){
        System.out.println("Publisher page Reached");
        getModel(model);

        return "publisherForm";
    }

    @RequestMapping("savePublisher")
    public String savePublisher(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult result, Model model){

        if(result.hasErrors()){
            getModel(model);
            return "publisherForm";
        }

        publisherService.addPublisher(publisher);

        return "redirect:publisherForm";
    }

    @RequestMapping("deletePublisher")
    public String deletePublisher(BindingResult result, Model model, Publisher publisher){
        if(result.hasErrors()){
            return "airlinesForm";
        }
        publisherService.deletePublisher(publisher.getPublisherId());

        return "redirect:publisherForm";
    }



    public Model getModel(Model model){
        return model;
    }
}
