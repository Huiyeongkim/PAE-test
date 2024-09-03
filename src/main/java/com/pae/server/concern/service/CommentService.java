package com.pae.server.concern.service;

import com.pae.server.concern.dto.request.CommentReqDto;
import com.pae.server.concern.dto.response.CommentRespDto;

import java.util.List;

public interface CommentService  {
    CommentRespDto createComment(CommentReqDto commentRequestDto);
    CommentRespDto getComment(Long id);
    void deleteComment(Long id);
    List<CommentRespDto> getAllCommentsForBoard(Long boardId);

}
