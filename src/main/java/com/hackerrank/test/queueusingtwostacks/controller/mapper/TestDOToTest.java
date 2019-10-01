package com.hackerrank.test.queueusingtwostacks.controller.mapper;

import com.hackerrank.test.queueusingtwostacks.controller.entity.Operation;
import com.hackerrank.test.queueusingtwostacks.controller.entity.Tests;
import com.hackerrank.test.queueusingtwostacks.domain.OperationDO;
import com.hackerrank.test.queueusingtwostacks.domain.TestsDO;
import com.hackerrank.test.queueusingtwostacks.services.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("testDOToTest")
public class TestDOToTest implements Mapper<TestsDO, Tests> {

    @Override
    public Tests map(TestsDO testsDO) {

        List<OperationDO> operationDOList = testsDO.getOperations();
        List<Operation> operations = operationDOList.stream()
                .map(item -> this.OperationDOToOperation(item))
                .collect(Collectors.toList());

        return Tests.builder()
                .numberOperations(testsDO.getNumberOperations())
                .operations(operations)
                .result(testsDO.getResult())
                .build();
    }

    private Operation OperationDOToOperation(OperationDO operationDO) {
        return Operation.builder()
                .codeOperation(operationDO.getCodeOperation())
                .value(operationDO.getValue())
                .build();
    }
}
