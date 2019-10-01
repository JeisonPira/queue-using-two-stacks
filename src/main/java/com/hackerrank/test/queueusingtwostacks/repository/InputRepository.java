package com.hackerrank.test.queueusingtwostacks.repository;

import com.hackerrank.test.queueusingtwostacks.repository.entity.InputDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputRepository extends JpaRepository<InputDAO, Long> {

}
