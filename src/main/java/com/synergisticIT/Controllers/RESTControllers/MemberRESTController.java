package com.synergisticIT.Controllers.RESTControllers;


import com.synergisticIT.Domain.Member;
import com.synergisticIT.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberRESTController {

    @Autowired
    MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member){
        Member savedMember = memberService.registerMember(member);

        return new ResponseEntity<>(savedMember, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Integer id){
        Member member = memberService.getMemberById(id);
        if(member != null){
            return new ResponseEntity<>(member, HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers(){
        List<Member> memberList =  memberService.getAllMembers();
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirlines(@PathVariable Integer id){
        Member member = memberService.getMemberById(id);
        if(member != null){
            memberService.deleteMember(id);
            return new ResponseEntity<>("Member deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Member of id " + id+ " was not found", HttpStatus.NOT_FOUND);
        }
    }
}
