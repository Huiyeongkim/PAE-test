package com.pae.server.concern.service;

import com.pae.server.concern.converter.CommentConverter;
import com.pae.server.concern.domain.Comment;
import com.pae.server.concern.dto.request.CommentReqDto;
import com.pae.server.concern.dto.response.CommentRespDto;
import com.pae.server.concern.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentConverter commentConverter;

    @Override
    public CommentRespDto createComment(CommentReqDto commentRequestDto) {
        Comment comment = commentConverter.toEntity(commentRequestDto);
        Comment savedComment = commentRepository.save(comment);
        return commentConverter.toResponseDto(savedComment);
    }

    @Override
    public CommentRespDto getComment(Long id) {
        return commentRepository.findById(id)
                .map(commentConverter::toResponseDto)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentRespDto> getAllCommentsForBoard(Long boardId) {
        return commentRepository.findByBoardId(boardId).stream()
                .map(commentConverter::toResponseDto)
                .collect(Collectors.toList());
    }
}