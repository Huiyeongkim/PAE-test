package com.pae.server.concern.converter;

import com.pae.server.concern.domain.Comment;
import com.pae.server.concern.dto.request.CommentReqDto;
import com.pae.server.concern.dto.response.CommentRespDto;
import com.pae.server.concern.repository.ConcernRepository;
import com.pae.server.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    @Autowired
    private ConcernRepository concernRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Comment toEntity(CommentReqDto dto) {
        return new Comment(
                concernRepository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Board not found")),
                memberRepository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Member not found")),
                dto.comment()
        );
    }

    public CommentRespDto toResponseDto(Comment entity) {
        return new CommentRespDto(
                entity.getId(),
                entity.getComment()
        );
    }
}
