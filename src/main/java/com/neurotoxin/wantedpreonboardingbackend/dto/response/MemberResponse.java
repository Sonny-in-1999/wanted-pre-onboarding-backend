package com.neurotoxin.wantedpreonboardingbackend.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MemberResponse {

    private Long id;

    private String name;

    private Integer age;

    private String stack;
}
