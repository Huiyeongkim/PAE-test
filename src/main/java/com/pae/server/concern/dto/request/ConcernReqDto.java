package com.pae.server.concern.dto.request;

public record ConcernReqDto(
        String title, String content, String baseStatus, Long memberId
) {

}
