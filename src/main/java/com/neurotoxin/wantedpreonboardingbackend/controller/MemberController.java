package com.neurotoxin.wantedpreonboardingbackend.controller;

import com.neurotoxin.wantedpreonboardingbackend.dto.Result;
import com.neurotoxin.wantedpreonboardingbackend.dto.request.MemberRequest;
import com.neurotoxin.wantedpreonboardingbackend.dto.response.MemberApplyResponse;
import com.neurotoxin.wantedpreonboardingbackend.dto.response.MemberResponse;
import com.neurotoxin.wantedpreonboardingbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public Result addMember(@RequestBody MemberRequest request) {
        MemberResponse memberResponse = memberService.addMember(request);
        return new Result(memberResponse);
    }

    @PostMapping("/{memberId}/apply/{recruitmentId}")
    public Result apply(@PathVariable Long memberId, @PathVariable Long recruitmentId) {
        MemberApplyResponse memberApplyResponse = memberService.applyRecruitment(memberId, recruitmentId);
        return new Result(memberApplyResponse);
    }
}
