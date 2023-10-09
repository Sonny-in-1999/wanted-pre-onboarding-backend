package com.neurotoxin.wantedpreonboardingbackend.dto.request;

import com.neurotoxin.wantedpreonboardingbackend.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberRequest {

    private String name;

    private Integer age;

    private String stack;

    public Member convertToEntity() {
        return Member.builder()
                .name(this.name)
                .age(this.age)
                .stack(this.stack)
                .canApply(true)
                .build();
    }
}
