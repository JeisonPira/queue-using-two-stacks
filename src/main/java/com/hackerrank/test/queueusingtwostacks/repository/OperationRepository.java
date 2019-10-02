package com.hackerrank.test.queueusingtwostacks.repository;

import com.hackerrank.test.queueusingtwostacks.repository.entity.OperationsDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperationRepository extends JpaRepository<OperationsDAO, Long> {

    @Query(value = "SELECT * FROM Operations o WHERE o.inputdao_id = ?1", nativeQuery = true)
    List<OperationsDAO> findByIdInput(long id);
}
