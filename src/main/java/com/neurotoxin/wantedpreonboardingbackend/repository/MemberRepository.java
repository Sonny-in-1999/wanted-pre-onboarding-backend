package com.neurotoxin.wantedpreonboardingbackend.repository;

import com.neurotoxin.wantedpreonboardingbackend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
