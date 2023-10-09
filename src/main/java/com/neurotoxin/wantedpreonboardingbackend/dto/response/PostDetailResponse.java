package com.neurotoxin.wantedpreonboardingbackend.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PostDetailResponse {

    private Long id;

    private String companyName;

    private String nation;

    private String region;

    private String position;

    private Integer compensation;

    private String contents;

    private String stack;

    private List<Long> otherRecruitments;
}
