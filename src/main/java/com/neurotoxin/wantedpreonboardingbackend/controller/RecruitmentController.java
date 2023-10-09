package com.neurotoxin.wantedpreonboardingbackend.controller;

import com.neurotoxin.wantedpreonboardingbackend.dto.Result;
import com.neurotoxin.wantedpreonboardingbackend.dto.request.PostRequest;
import com.neurotoxin.wantedpreonboardingbackend.dto.response.PostDetailResponse;
import com.neurotoxin.wantedpreonboardingbackend.dto.response.PostResponse;
import com.neurotoxin.wantedpreonboardingbackend.service.RecruitmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @PostMapping("/posts")
    public Result addPost(@RequestBody PostRequest request) {
        PostResponse postResponse = recruitmentService.addPost(request);
        return new Result(postResponse);
    }

    @GetMapping("/posts/{id}")
    public Result getPostDetail(@PathVariable Long id) {
        PostDetailResponse postDetail = recruitmentService.getPostDetail(id);
        return new Result(postDetail);
    }

    @GetMapping("/posts/company")
    public Result getPostsByCompanyName(@RequestParam String search) {
        List<PostResponse> posts = recruitmentService.getPostsByCompanyName(search);
        return new Result(posts);
    }

    @GetMapping("/posts/position")
    public Result getPostsByPosition(@RequestParam String search) {
        List<PostResponse> posts = recruitmentService.getPostsByPosition(search);
        return new Result(posts);
    }

    @PatchMapping("/posts/{id}")
    public Result updatePost(@PathVariable Long id, @RequestBody PostRequest request) {
        PostResponse postResponse = recruitmentService.updatePost(id, request);
        return new Result(postResponse);
    }

    @DeleteMapping("/posts/{id}")
    public Result deletePost(@PathVariable Long id) {
        recruitmentService.deletePost(id);
        return new Result(HttpStatus.OK);
    }
}

