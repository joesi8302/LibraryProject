package com.synergisticIT.Repositories;

import com.synergisticIT.Domain.Librarian;
import com.synergisticIT.Domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Page<Member> findAll(Pageable pageable);
}
