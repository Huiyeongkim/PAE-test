package com.pae.server.board.repository;

import java.util.Optional;

public interface BoardRepository {
    Optional<Object> findByBoardId(Long id);
}
