package com.hackerrank.test.queueusingtwostacks.services.mapper;

import com.hackerrank.test.queueusingtwostacks.domain.InputDO;
import com.hackerrank.test.queueusingtwostacks.repository.entity.InputDAO;
import org.springframework.stereotype.Service;

@Service("inputDAOToInputDOMapper")
public class InputDAOToInputDOMapper implements Mapper<InputDAO, InputDO> {
    @Override
    public InputDO map(InputDAO inputDAO) {
        return InputDO.builder()
                .id(inputDAO.getId())
                .numberOperations(inputDAO.getNumberOperations())
                .result(inputDAO.getResult())
                .build();
    }
}
