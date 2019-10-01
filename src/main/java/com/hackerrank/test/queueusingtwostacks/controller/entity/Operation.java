package com.hackerrank.test.queueusingtwostacks.controller.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Operation {

    private int codeOperation;
    private int value;
}
