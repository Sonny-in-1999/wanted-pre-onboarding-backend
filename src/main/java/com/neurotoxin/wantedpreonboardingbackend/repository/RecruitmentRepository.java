package com.neurotoxin.wantedpreonboardingbackend.repository;

import com.neurotoxin.wantedpreonboardingbackend.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {

    Optional<List<Recruitment>> findAllByPositionContaining(String position);

    Optional<List<Recruitment>> findAllByCompanyNameContaining(String companyName);
}
