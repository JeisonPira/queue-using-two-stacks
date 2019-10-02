package com.hackerrank.test.queueusingtwostacks.services;

import com.hackerrank.test.queueusingtwostacks.controller.entity.InputQueue;
import com.hackerrank.test.queueusingtwostacks.domain.InputDO;
import com.hackerrank.test.queueusingtwostacks.exception.TechnicalException;
import com.hackerrank.test.queueusingtwostacks.factory.MockFactory;
import com.hackerrank.test.queueusingtwostacks.repository.InputRepository;
import com.hackerrank.test.queueusingtwostacks.repository.OperationRepository;
import com.hackerrank.test.queueusingtwostacks.repository.entity.InputDAO;
import com.hackerrank.test.queueusingtwostacks.services.mapper.Mapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ManagementQueueServiceImplTest {

    @Mock
    private InputRepository inputRepository;
    @Mock
    private OperationRepository operationRepository;
    @Mock
    private Mapper inputDAOToInputDOMapper;

    private ManagementQueueServiceImpl managementQueueService;

    @BeforeEach
    void setUp() {
        managementQueueService = new ManagementQueueServiceImpl(inputRepository, operationRepository, inputDAOToInputDOMapper);
    }

    @Test
    void saveInputOperations() throws TechnicalException {
        InputQueue inputQueue = MockFactory.generateOperations();
        InputDO inputDOMock = MockFactory.generateInputDO();
        Mockito.when(inputDAOToInputDOMapper.map(Mockito.any())).thenReturn(inputDOMock);

        InputDO inputDO = managementQueueService.saveInputOperations(inputQueue);

        Assertions.assertEquals(inputDOMock.getId(), inputDO.getId());
        Assertions.assertEquals(inputDOMock.getNumberOperations(), inputDO.getNumberOperations());
        Assertions.assertEquals(inputDOMock.getResult(), inputDO.getResult());
    }

    @Test
    void doOperationsQueue() {
        InputQueue inputQueue = MockFactory.generateOperations();
        String result = managementQueueService.doOperationsQueue(inputQueue);
        Assertions.assertEquals(result, "14\n14\n");
    }

    @Test
    void saveOutputOperations() {
        InputDO inputDOMock = MockFactory.generateInputDO();
        InputDAO inputDAOMock = MockFactory.generateInputDAO();
        Mockito.when(inputRepository.save(Mockito.any())).thenReturn(inputDAOMock);
        long id = managementQueueService.saveOutputOperations(inputDOMock);
        Assertions.assertEquals(inputDOMock.getId(), id);
    }
}