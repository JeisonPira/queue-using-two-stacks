package com.hackerrank.test.queueusingtwostacks.services.mapper;

import com.hackerrank.test.queueusingtwostacks.domain.OperationDO;
import com.hackerrank.test.queueusingtwostacks.repository.entity.OperationsDAO;
import org.springframework.stereotype.Service;

@Service("operationDAOToOperationDOMapper")
public class OperationDAOToOperationDOMapper implements Mapper<OperationsDAO, OperationDO> {
    @Override
    public OperationDO map(OperationsDAO operationsDAO) {
        return OperationDO.builder()
                .codeOperation(operationsDAO.getCodeOperation())
                .value(operationsDAO.getOperationValue())
                .build();
    }
}
