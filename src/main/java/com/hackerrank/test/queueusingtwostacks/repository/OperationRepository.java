package com.hackerrank.test.queueusingtwostacks.repository;

import com.hackerrank.test.queueusingtwostacks.repository.entity.OperationsDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<OperationsDAO, Long> {
}
