package com.hackerrank.test.queueusingtwostacks.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OperationDO {

    private int codeOperation;
    private int value;
}
