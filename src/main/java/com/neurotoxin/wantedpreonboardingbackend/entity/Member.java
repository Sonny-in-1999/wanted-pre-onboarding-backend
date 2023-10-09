package com.neurotoxin.wantedpreonboardingbackend.entity;


import com.neurotoxin.wantedpreonboardingbackend.dto.response.MemberApplyResponse;
import com.neurotoxin.wantedpreonboardingbackend.dto.response.MemberResponse;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String stack;

    private Long recruitmentId;

    private Boolean canApply;

    public MemberResponse convertToResponse() {
        return MemberResponse.builder()
                .id(this.id)
                .name(this.name)
                .age(this.age)
                .stack(this.stack)
                .build();
    }

    public MemberApplyResponse convertToApplyResponse() {
        return MemberApplyResponse.builder()
                .memberId(this.id)
                .recruitmentId(this.recruitmentId)
                .build();
    }

    public void applyRecruitment(Long recruitmentId) {
        this.recruitmentId = recruitmentId;
        this.canApply = false;
    }
}
