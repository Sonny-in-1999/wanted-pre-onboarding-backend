package com.neurotoxin.wantedpreonboardingbackend.repository;

import com.neurotoxin.wantedpreonboardingbackend.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
