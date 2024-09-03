package com.pae.server.concern.repository;

import com.pae.server.concern.domain.Comment;
import com.pae.server.concern.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Comment> findByBoardId(Long boardId);

}