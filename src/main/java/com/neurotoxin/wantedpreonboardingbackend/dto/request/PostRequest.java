package com.neurotoxin.wantedpreonboardingbackend.dto.request;


import com.neurotoxin.wantedpreonboardingbackend.entity.Recruitment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostRequest {

    private String companyName;

    private String nation;

    private String region;

    private String contents;

    private String position;

    private Integer compensation;

    private String stack;


    public Recruitment convertToEntity() {
        return Recruitment.builder()
                .companyName(this.companyName)
                .nation(this.nation)
                .region(this.region)
                .contents(this.contents)
                .position(this.position)
                .compensation(this.compensation)
                .stack(this.stack)
                .build();
    }
}
