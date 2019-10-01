package com.hackerrank.test.queueusingtwostacks.controller.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Tests {

    private int numberOperations;
    private List<Operation> operations;
    private String result;
}
