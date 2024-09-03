package com.pae.server.concern.controller;

import com.pae.server.concern.dto.request.ImageReqDto;
import com.pae.server.concern.dto.response.ImageRespDto;
import com.pae.server.concern.service.ImageService;
import com.pae.server.concern.service.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/information")
public class ImageController {

    @Autowired
    private ImageServiceImpl imageService;

    // 생성
    @PostMapping
    public ResponseEntity<ImageRespDto> createImage(@RequestBody ImageReqDto imageRequestDto) {
        return ResponseEntity.ok(imageService.createImage(imageRequestDto));
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/board/{boardId}")
    public ResponseEntity<List<ImageRespDto>> getAllImagesForBoard(@PathVariable Long boardId) {
        return ResponseEntity.ok(imageService.getAllImagesForBoard(boardId));
    }
}