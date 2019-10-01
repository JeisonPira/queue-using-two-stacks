package com.hackerrank.test.queueusingtwostacks.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestsDO {

    private int numberOperations;
    private List<OperationDO> operations;
    private String result;
}
