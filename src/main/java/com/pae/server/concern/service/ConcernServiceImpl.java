package com.pae.server.concern.service;

import com.pae.server.common.enums.BaseStatus;
import com.pae.server.concern.converter.ConcernConverter;
import com.pae.server.concern.domain.ConcernBoard;
import com.pae.server.concern.dto.request.ConcernReqDto;
import com.pae.server.concern.dto.response.ConcernRespDto;
import com.pae.server.concern.repository.ConcernRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConcernServiceImpl implements ConcernService {
    @Autowired
    private ConcernRepository concernRepository;

    @Autowired
    private ConcernConverter concernConverter;

    @Override
    public ConcernRespDto createConcernBoard(ConcernReqDto concernBoardRequestDto) {
        ConcernBoard concernBoard = concernConverter.toEntity(concernBoardRequestDto);
        ConcernBoard savedBoard = concernRepository.save(concernBoard);
        return concernConverter.toResponseDto(savedBoard);
    }

    @Override
    public ConcernRespDto getConcernBoard(Long id) {
        return concernRepository.findById(id)
                .map(concernConverter::toResponseDto)
                .orElseThrow(() -> new RuntimeException("ConcernBoard not found"));
    }

    @Override
    public ConcernRespDto updateConcernBoard(Long id, ConcernReqDto concernBoardRequestDto) {
        ConcernBoard concernBoard = concernRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ConcernBoard not found"));
        concernBoard.update(concernBoardRequestDto.title(), concernBoardRequestDto.content(), BaseStatus.valueOf(concernBoardRequestDto.baseStatus()));
        ConcernBoard updatedBoard = concernRepository.save(concernBoard);
        return concernConverter.toResponseDto(updatedBoard);
    }

    @Override
    public void deleteConcernBoard(Long id) {
        concernRepository.deleteById(id);
    }

    @Override
    public List<ConcernRespDto> getAllConcernBoards() {
        return concernRepository.findAll().stream()
                .map(concernConverter::toResponseDto)
                .collect(Collectors.toList());
    }
}