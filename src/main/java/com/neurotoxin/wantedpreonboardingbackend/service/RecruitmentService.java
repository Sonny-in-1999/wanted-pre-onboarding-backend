package com.neurotoxin.wantedpreonboardingbackend.service;

import com.neurotoxin.wantedpreonboardingbackend.dto.request.PostRequest;
import com.neurotoxin.wantedpreonboardingbackend.dto.response.PostDetailResponse;
import com.neurotoxin.wantedpreonboardingbackend.dto.response.PostResponse;
import com.neurotoxin.wantedpreonboardingbackend.entity.Recruitment;
import com.neurotoxin.wantedpreonboardingbackend.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;


    @Transactional
    public PostResponse addPost(PostRequest request) {
        Recruitment recruitment = request.convertToEntity();
        Recruitment newRecruitment = recruitmentRepository.save(recruitment);
        return newRecruitment.convertToResponse();
    }

    public PostDetailResponse getPostDetail(Long recruitmentId) {
        Recruitment recruitment = validateAndReturnRecruitmentById(recruitmentId);
        Optional<List<Recruitment>> otherRecruitments = recruitmentRepository.findAllByCompanyNameContaining(recruitment.getCompanyName());
        PostDetailResponse response = recruitment.convertToDetailResponse();
        if (otherRecruitments.isPresent()) {
            for (Recruitment otherRecruitment : otherRecruitments.get()) {
                response.getOtherRecruitments().add(otherRecruitment.getId());
            }
        }
        return response;
    }

    public List<PostResponse> getPostsByCompanyName(String companyName) {
        Optional<List<Recruitment>> recruitments = recruitmentRepository.findAllByCompanyNameContaining(companyName);
        if (recruitments.isPresent()) {
            return recruitments.get().stream().map(Recruitment::convertToResponse).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("회사명을 찾을 수 없습니다.");
        }
    }

    public List<PostResponse> getPostsByPosition(String position) {
        Optional<List<Recruitment>> recruitments = recruitmentRepository.findAllByPositionContaining(position);
        if (recruitments.isPresent()) {
            return recruitments.get().stream().map(Recruitment::convertToResponse).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("포지션을 찾을 수 없습니다.");
        }
    }

    @Transactional
    public PostResponse updatePost(Long recruitmentId, PostRequest request) {
        Recruitment recruitment = validateAndReturnRecruitmentById(recruitmentId);
        recruitment.changeInfo(request);
        return recruitment.convertToResponse();
    }

    @Transactional
    public void deletePost(Long recruitmentId) {
        Recruitment recruitment = validateAndReturnRecruitmentById(recruitmentId);
        recruitmentRepository.delete(recruitment);
    }


    private Recruitment validateAndReturnRecruitmentById(Long recruitmentId) {
        return recruitmentRepository.findById(recruitmentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 공고를 찾을 수 없습니다."));
    }
}

