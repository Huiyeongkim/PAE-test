package com.pae.server.concern.service;

import com.pae.server.concern.dto.request.ConcernReqDto;
import com.pae.server.concern.dto.response.ConcernRespDto;

import java.util.List;

public interface ConcernService {
    ConcernRespDto createConcernBoard(ConcernReqDto concernBoardRequestDto);
    ConcernRespDto getConcernBoard(Long id);
    ConcernRespDto updateConcernBoard(Long id, ConcernReqDto concernBoardRequestDto);
    void deleteConcernBoard(Long id);
    List<ConcernRespDto> getAllConcernBoards();
}