package com.synergisticIT.Controllers;

import com.synergisticIT.Domain.Book;
import com.synergisticIT.Service.BookService;
import com.synergisticIT.Service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("bookForm")
    public String bookForm(Model model){
        System.out.println("Book page Reached");
        getModel(model);

        return "bookForm";
    }

    @RequestMapping("saveBook")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model){

        if(result.hasErrors()){
            getModel(model);
            return "bookForm";
        }

        bookService.addBook(book);

        return "redirect:bookForm";
    }

    @RequestMapping("deleteBook")
    public String deleteBook(BindingResult result, Model model, Book book){
        if(result.hasErrors()){
            return "airlinesForm";
        }
        bookService.deleteBook(book.getBookId());

        return "redirect:bookForm";
    }



    public Model getModel(Model model){
        return model;
    }

}
