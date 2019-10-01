package com.hackerrank.test.queueusingtwostacks.services;

import com.hackerrank.test.queueusingtwostacks.domain.TestsDO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProofsService {

    List<TestsDO> getOperations(int limit, int page);
}
