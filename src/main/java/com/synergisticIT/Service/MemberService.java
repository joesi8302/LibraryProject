package com.synergisticIT.Service;

import com.synergisticIT.Domain.Member;

import java.util.List;

public interface MemberService {
    Member registerMember(Member member);
    Member getMemberById(Integer memberId);
    List<Member> getAllMembers();
    void deleteMember(Integer memberId);

}
