package com.pae.server.like.dto.response;

import lombok.Builder;

@Builder
public record CreateLikeResDto(Long id, String title, String contents, Integer viewCount, Long likeId) {
}