package com.hackerrank.test.queueusingtwostacks.controller.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class InputQueue {

    private int numberOperations;
    private List<String> operations;
}
