package com.pae.server.concern.converter;

import com.pae.server.concern.domain.Image;
import com.pae.server.concern.dto.request.ImageReqDto;
import com.pae.server.concern.dto.response.ImageRespDto;
import com.pae.server.concern.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageConverter {
    @Autowired
    private ImageRepository imageRepository;

    public Image toEntity(ImageReqDto dto) {
        imageRepository.findById(dto.id())
                .orElseThrow(() -> new RuntimeException("Board not found"));
        return new Image(dto.id(), dto.url());
    }

    public ImageRespDto toResponseDto(Image entity) {
        return new ImageRespDto(
                entity.getId(),
                entity.getUrl()
        );
    }
}
