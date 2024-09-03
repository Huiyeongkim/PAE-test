package com.pae.server.concern.service;

import com.pae.server.concern.dto.request.ImageReqDto;
import com.pae.server.concern.dto.response.ImageRespDto;

import java.util.List;

public interface ImageService {
    ImageRespDto createImage(ImageReqDto imageRequestDto);
    void deleteImage(Long id);
    List<ImageRespDto> getAllImagesForBoard(Long boardId);
}
