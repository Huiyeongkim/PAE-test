package com.pae.server.concern.dto.response;

public record ConcernRespDto(
        String title, String content, String baseStatus, Long memberId
) {
    /***
     * DTO 에서는 record를 사용하고자 합니다. 모르는 분들은 record 학습을 먼저 하고 진행해주세요!
     */
}
