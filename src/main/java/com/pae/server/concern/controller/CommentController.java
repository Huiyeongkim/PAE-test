package com.pae.server.concern.controller;

import com.pae.server.concern.dto.request.CommentReqDto;
import com.pae.server.concern.dto.response.CommentRespDto;
import com.pae.server.concern.service.CommentService;
import com.pae.server.concern.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    // 생성
    @PostMapping
    public ResponseEntity<CommentRespDto> createComment(@RequestBody CommentReqDto commentRequestDto) {
        return ResponseEntity.ok(commentService.createComment(commentRequestDto));
    }

    //조회
    @GetMapping("/{id}")
    public ResponseEntity<CommentRespDto> getComment(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getComment(id));
    }

    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}