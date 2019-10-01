package com.hackerrank.test.queueusingtwostacks.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputDO {

    private long id;
    private int numberOperations;
    private String result;
}
