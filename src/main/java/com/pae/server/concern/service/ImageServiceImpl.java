package com.pae.server.concern.service;

import com.pae.server.concern.converter.ImageConverter;
import com.pae.server.concern.domain.Image;
import com.pae.server.concern.dto.request.ImageReqDto;
import com.pae.server.concern.dto.response.ImageRespDto;
import com.pae.server.concern.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageConverter imageConverter;

    @Override
    public ImageRespDto createImage(ImageReqDto imageRequestDto) {
        Image image = imageConverter.toEntity(imageRequestDto);
        Image savedImage = imageRepository.save(image);
        return imageConverter.toResponseDto(savedImage);
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public List<ImageRespDto> getAllImagesForBoard(Long boardId) {
        return imageRepository.findById(boardId).stream()
                .map(imageConverter::toResponseDto)
                .collect(Collectors.toList());
    }
}
