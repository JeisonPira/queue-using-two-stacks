package com.hackerrank.test.queueusingtwostacks.services.mapper;

import com.hackerrank.test.queueusingtwostacks.domain.InputDO;
import com.hackerrank.test.queueusingtwostacks.factory.MockFactory;
import com.hackerrank.test.queueusingtwostacks.repository.entity.InputDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputDAOToInputDOMapperTest {

    private InputDAOToInputDOMapper inputDAOToInputDOMapper = new InputDAOToInputDOMapper();

    @Test
    void map() {
        InputDAO inputDAO = MockFactory.generateInputDAO();
        InputDO inputDO = inputDAOToInputDOMapper.map(inputDAO);
        Assertions.assertTrue(inputDO instanceof InputDO);
        Assertions.assertEquals(inputDAO.getNumberOperations(), inputDO.getNumberOperations());
    }
}