package com.hackerrank.test.queueusingtwostacks.factory;

import com.hackerrank.test.queueusingtwostacks.controller.entity.InputQueue;
import com.hackerrank.test.queueusingtwostacks.domain.InputDO;
import com.hackerrank.test.queueusingtwostacks.repository.entity.InputDAO;

import java.util.Arrays;

public class MockFactory {

    public static InputQueue generateOperations() {
        return InputQueue.builder()
                .numberOperations(10)
                .operations(Arrays.asList("1 42", "2", "1 14", "3", "1 28", "3", "1 60", "1 78", "2", "2"))
                .build();
    }

    public static InputQueue generateOperationsFailed() {
        return InputQueue.builder()
                .numberOperations(1)
                .operations(Arrays.asList("1 A", "2"))
                .build();
    }

    public static InputDO generateInputDO() {
        return InputDO.builder()
                .id(1)
                .numberOperations(10)
                .result("14\n14")
                .build();
    }

    public static InputDAO generateInputDAO() {
        InputDAO inputDAO = new InputDAO();
        inputDAO.setId(1);
        inputDAO.setNumberOperations(10);
        inputDAO.setResult("14\n14\n");
        return inputDAO;
    }

}
