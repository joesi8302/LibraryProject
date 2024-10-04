package com.synergisticIT.Service;

import com.synergisticIT.Domain.Author;
import com.synergisticIT.Domain.Member;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MemberService {
    Member registerMember(Member member);
    Member getMemberById(Integer memberId);
    List<Member> getAllMembers();
    void deleteMember(Integer memberId);

    Page<Member> findAllPaginiated(int page, int size);

}
