package com.hackerrank.test.queueusingtwostacks.controller.mapper;

import com.hackerrank.test.queueusingtwostacks.controller.entity.Tests;
import com.hackerrank.test.queueusingtwostacks.domain.TestsDO;
import com.hackerrank.test.queueusingtwostacks.services.mapper.Mapper;
import org.springframework.stereotype.Service;

@Service("testDOToTest")
public class TestDOToTest implements Mapper<TestsDO, Tests> {

    @Override
    public Tests map(TestsDO testsDO) {

        return Tests.builder()
                .numberOperations(testsDO.getNumberOperations())
                .operations(testsDO.getOperations())
                .result(testsDO.getResult())
                .build();
    }
}
