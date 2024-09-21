package com.pae.server.board.repository;

import com.pae.server.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MyPageRepository extends JpaRepository<Board, Long> {
}
