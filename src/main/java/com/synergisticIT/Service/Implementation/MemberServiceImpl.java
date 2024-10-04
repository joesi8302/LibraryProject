package com.synergisticIT.Service.Implementation;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Domain.Member;
import com.synergisticIT.Repositories.MemberRepository;
import com.synergisticIT.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member registerMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getMemberById(Integer memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void deleteMember(Integer memberId) {
        Member foundMember = getMemberById(memberId);
    }

    @Override
    public Page<Member> findAllPaginiated(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page, size));
    }


}
