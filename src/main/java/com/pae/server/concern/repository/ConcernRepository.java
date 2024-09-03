package com.pae.server.concern.repository;

import com.pae.server.concern.domain.ConcernBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcernRepository extends JpaRepository<ConcernBoard, Long> {
}
