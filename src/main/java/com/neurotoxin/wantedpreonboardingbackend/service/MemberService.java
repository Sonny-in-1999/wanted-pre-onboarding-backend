package com.neurotoxin.wantedpreonboardingbackend.service;

import com.neurotoxin.wantedpreonboardingbackend.dto.request.MemberRequest;
import com.neurotoxin.wantedpreonboardingbackend.dto.response.MemberApplyResponse;
import com.neurotoxin.wantedpreonboardingbackend.dto.response.MemberResponse;
import com.neurotoxin.wantedpreonboardingbackend.entity.Member;
import com.neurotoxin.wantedpreonboardingbackend.entity.Recruitment;
import com.neurotoxin.wantedpreonboardingbackend.repository.MemberRepository;
import com.neurotoxin.wantedpreonboardingbackend.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final RecruitmentRepository recruitmentRepository;

    @Transactional
    public MemberResponse addMember(MemberRequest request) {
        Member member = request.convertToEntity();
        Member newMember = memberRepository.save(member);
        return newMember.convertToResponse();
    }

    @Transactional
    public MemberApplyResponse applyRecruitment(Long memberId, Long recruitmentId) {
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Recruitment> recruitment = recruitmentRepository.findById(recruitmentId);
        if (member.isPresent() && recruitment.isPresent()) {
            member.get().applyRecruitment(recruitmentId);
            return member.get().convertToApplyResponse();
        } else {
            throw new IllegalArgumentException("존재하지 않는 공고입니다.");
        }
    }
}
