package com.synergisticIT.Controllers;

import com.synergisticIT.Domain.Transaction;
import com.synergisticIT.Service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping("transactionForm")
    public String transactionForm(Model model){
        System.out.println("Transaction page Reached");
        getModel(model);

        return "transactionForm";
    }

    @RequestMapping("saveTransaction")
    public String saveTransaction(@Valid @ModelAttribute("transaction") Transaction transaction, BindingResult result, Model model){

        if(result.hasErrors()){
            getModel(model);
            return "transactionForm";
        }

        transactionService.addTransaction(transaction);

        return "redirect:transactionForm";
    }

    @RequestMapping("deleteTransaction")
    public String deleteTransaction(BindingResult result, Model model, Transaction transaction){
        if(result.hasErrors()){
            return "airlinesForm";
        }
        transactionService.deleteTransaction(transaction.getTransactionId());

        return "redirect:transactionForm";
    }



    public Model getModel(Model model){
        return model;
    }
}
