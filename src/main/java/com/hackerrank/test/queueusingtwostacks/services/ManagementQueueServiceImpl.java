package com.hackerrank.test.queueusingtwostacks.services;

import com.hackerrank.test.queueusingtwostacks.controller.entity.InputQueue;
import com.hackerrank.test.queueusingtwostacks.domain.InputDO;
import com.hackerrank.test.queueusingtwostacks.exception.TechnicalException;
import com.hackerrank.test.queueusingtwostacks.repository.InputRepository;
import com.hackerrank.test.queueusingtwostacks.repository.OperationRepository;
import com.hackerrank.test.queueusingtwostacks.repository.entity.InputDAO;
import com.hackerrank.test.queueusingtwostacks.repository.entity.OperationsDAO;
import com.hackerrank.test.queueusingtwostacks.services.mapper.Mapper;
import com.hackerrank.test.queueusingtwostacks.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
@RequiredArgsConstructor
public class ManagementQueueServiceImpl implements ManagementQueueService {

    private final InputRepository inputRepository;
    private final OperationRepository operationRepository;
    private final Mapper inputDAOToInputDOMapper;

    public InputDO saveInputOperations(InputQueue inputQueue) throws TechnicalException {
        InputDAO inputDAO = saveInputDao(inputQueue.getNumberOperations());
        if (Utils.validOperations(inputQueue.getOperations())) {
            for (String operation : inputQueue.getOperations()) {
                String[] values = operation.split("\\s+");
                saveOperationsDao(inputDAO, values);
            }
        }
        return (InputDO) inputDAOToInputDOMapper.map(inputDAO);
    }

    @Override
    public String doOperationsQueue(InputQueue inputQueue) {
        String result = "";
        Stack<Integer> stack = new Stack<>();
        for (String operation : inputQueue.getOperations()) {
            String[] values = operation.split("\\s+");
            int operationInt = Integer.parseInt(values[0]);
            if (operationInt == 1) {
                stack.push(Integer.parseInt(values[1]));
            } else if (operationInt == 2) {
                stack.remove(0);
            } else if (operationInt == 3) {
                result += stack.get(0) + "\n";
            }
        }
        return result;
    }

    @Override
    public long saveOutputOperations(InputDO inputDO) {

        InputDAO inputDAO = new InputDAO();
        inputDAO.setId(inputDO.getId());
        inputDAO.setNumberOperations(inputDO.getNumberOperations());
        inputDAO.setResult(inputDO.getResult());
        InputDAO inputDAO1 = inputRepository.save(inputDAO);
        return inputDAO1.getId();
    }

    private void saveOperationsDao(InputDAO inputDAO, String[] values) {
        OperationsDAO operationsDAO = new OperationsDAO();
        operationsDAO.setInputDAO(inputDAO);
        operationsDAO.setCodeOperation(Integer.parseInt(values[0]));
        operationsDAO.setOperationValue(values.length > 1 ? Integer.parseInt(values[1]) : 0);
        operationRepository.save(operationsDAO);
    }

    private InputDAO saveInputDao(int numberOperations) {

        InputDAO inputDAO = new InputDAO();
        inputDAO.setNumberOperations(numberOperations);

        return inputRepository.save(inputDAO);
    }

}
