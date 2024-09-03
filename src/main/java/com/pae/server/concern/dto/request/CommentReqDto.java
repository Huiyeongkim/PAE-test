package com.pae.server.concern.dto.request;


public record CommentReqDto (Long id, Long parentId, String comment, String path) {

}