package com.hackerrank.test.queueusingtwostacks.services;

import com.hackerrank.test.queueusingtwostacks.controller.entity.Operations;
import com.hackerrank.test.queueusingtwostacks.exception.TechnicalException;
import com.hackerrank.test.queueusingtwostacks.repository.InputRepository;
import com.hackerrank.test.queueusingtwostacks.repository.OperationRepository;
import com.hackerrank.test.queueusingtwostacks.repository.entity.InputsDao;
import com.hackerrank.test.queueusingtwostacks.repository.entity.OperationsDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ManagementQueueService {

    private final InputRepository inputRepository;
    private final OperationRepository operationRepository;

    public String doOperationsInQueue(Operations operations) throws TechnicalException {
        InputsDao inputsDao = inputRepository.save(
                InputsDao.builder()
                        .numberOperations(operations.getNumberOperations())
                        .build());
        if (validOperations(operations.getOperations())) {
            for (String operation : operations.getOperations()) {
                String[] values = operation.split("\\s+");
                operationRepository.save(
                        OperationsDao.builder()
                                .inputsDao(inputsDao)
                                .codeOperation(Integer.parseInt(values[0]))
                                .operationValue(values.length > 1 ? Integer.parseInt(values[1]) : 0)
                                .build());

            }
        }

        return "";
    }

    private Boolean validOperations(List<String> operations) throws TechnicalException {
        boolean valid = true;
        try {
            for (String operationStn : operations) {
                String[] values = operationStn.split("\\s+");
                int operation = Integer.parseInt(values[0]);
                if (operation == 1) {
                    Integer.parseInt(values[0]);
                    Integer.parseInt(values[1]);
                } else if (operation == 2 || operation == 3) {
                    Integer.parseInt(values[0]);
                } else {
                    valid = false;
                }
            }
        } catch (NumberFormatException ne) {
            throw new TechnicalException(ne.getMessage(), ne.getCause());
        } catch (ArrayIndexOutOfBoundsException ae) {
            throw new TechnicalException(ae.getMessage(), ae.getCause());
        }
        return valid;

    }

}
