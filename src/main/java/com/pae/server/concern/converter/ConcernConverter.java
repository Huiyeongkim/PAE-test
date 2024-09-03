package com.pae.server.concern.converter;

import com.pae.server.common.enums.BaseStatus;
import com.pae.server.concern.domain.ConcernBoard;
import com.pae.server.concern.dto.request.ConcernReqDto;
import com.pae.server.concern.dto.response.ConcernRespDto;
import com.pae.server.member.domain.Member;
import com.pae.server.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConcernConverter {

    public ConcernBoard toEntity(ConcernReqDto dto) {
        return new ConcernBoard(dto.title(), dto.content(), BaseStatus.valueOf(dto.baseStatus()));
    }

    public ConcernRespDto toResponseDto(ConcernBoard entity) {
        return new ConcernRespDto(entity.getTitle(), entity.getContent(), entity.getBaseStatus().name(), entity.getViewCount());
    }
}
