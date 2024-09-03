package com.pae.server.concern.controller;

import com.pae.server.concern.dto.request.ConcernReqDto;
import com.pae.server.concern.dto.response.ConcernRespDto;
import com.pae.server.concern.service.ConcernServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concern")
public class ConcernController {

    @Autowired
    private ConcernServiceImpl concernService;

    // 생성
    @PostMapping("/{id}")
    public ResponseEntity<ConcernRespDto> createConcernBoard(@RequestBody ConcernReqDto concernBoardRequestDto) {
        return ResponseEntity.ok(concernService.createConcernBoard(concernBoardRequestDto));
    }

    // 조회
    @GetMapping("/{id}")
    public ResponseEntity<ConcernRespDto> getConcernBoard(@PathVariable Long id) {
        return ResponseEntity.ok(concernService.getConcernBoard(id));
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<ConcernRespDto> updateConcernBoard(@PathVariable Long id, @RequestBody ConcernReqDto concernBoardRequestDto) {
        return ResponseEntity.ok(concernService.updateConcernBoard(id, concernBoardRequestDto));
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConcernBoard(@PathVariable Long id) {
        concernService.deleteConcernBoard(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<List<ConcernRespDto>> getAllConcernBoards() {
        return ResponseEntity.ok(concernService.getAllConcernBoards());
    }
}