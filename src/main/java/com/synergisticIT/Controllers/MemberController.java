package com.synergisticIT.Controllers;

import com.synergisticIT.Domain.Member;
import com.synergisticIT.Service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @RequestMapping("memberForm")
    public String memberForm(Model model){
        System.out.println("Member page Reached");
        getModel(model);

        return "memberForm";
    }

    @RequestMapping("saveMember")
    public String saveMember(@Valid @ModelAttribute("member") Member member, BindingResult result, Model model){

        if(result.hasErrors()){
            getModel(model);
            return "memberForm";
        }

        memberService.registerMember(member);

        return "redirect:memberForm";
    }

    @RequestMapping("deleteMember")
    public String deleteMember(BindingResult result, Model model, Member member){
        if(result.hasErrors()){
            return "airlinesForm";
        }
        memberService.deleteMember(member.getUserId());

        return "redirect:memberForm";
    }



    public Model getModel(Model model){
        return model;
    }
}
