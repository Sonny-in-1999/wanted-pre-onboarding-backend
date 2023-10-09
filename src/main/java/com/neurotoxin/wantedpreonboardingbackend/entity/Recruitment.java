package com.neurotoxin.wantedpreonboardingbackend.entity;


import com.neurotoxin.wantedpreonboardingbackend.dto.request.PostRequest;
import com.neurotoxin.wantedpreonboardingbackend.dto.response.PostDetailResponse;
import com.neurotoxin.wantedpreonboardingbackend.dto.response.PostResponse;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@Entity
public class Recruitment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String nation;

    private String region;

    private String position;

    private Integer compensation;

    private String contents;

    private String stack;


    public void changeInfo(PostRequest request) {
        this.companyName = request.getCompanyName();
        this.nation = request.getNation();
        this.region = request.getRegion();
        this.position = request.getPosition();
        this.compensation = request.getCompensation();
        this.contents = request.getContents();
        this.stack = request.getStack();
    }

    public PostResponse convertToResponse() {
        return PostResponse.builder()
                .id(this.id)
                .companyName(this.companyName)
                .nation(this.nation)
                .region(this.region)
                .position(this.position)
                .compensation(this.compensation)
                .contents(this.contents)
                .stack(this.stack)
                .build();
    }

    public PostDetailResponse convertToDetailResponse() {
        return PostDetailResponse.builder()
                .id(this.id)
                .companyName(this.companyName)
                .nation(this.nation)
                .region(this.region)
                .position(this.position)
                .compensation(this.compensation)
                .contents(this.contents)
                .stack(this.stack)
                .otherRecruitments(new ArrayList<>())
                .build();
    }
}
