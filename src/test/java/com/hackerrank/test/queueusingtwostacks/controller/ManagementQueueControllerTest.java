package com.hackerrank.test.queueusingtwostacks.controller;

import com.hackerrank.test.queueusingtwostacks.controller.entity.InputQueue;
import com.hackerrank.test.queueusingtwostacks.domain.InputDO;
import com.hackerrank.test.queueusingtwostacks.exception.TechnicalException;
import com.hackerrank.test.queueusingtwostacks.factory.MockFactory;
import com.hackerrank.test.queueusingtwostacks.services.ManagementQueueService;
import com.hackerrank.test.queueusingtwostacks.utils.MessageError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class ManagementQueueControllerTest {

    @Mock
    private ManagementQueueService managementQueueServiceImpl;
    private ManagementQueueController managementQueueController;

    @BeforeEach
    void setUp() {
        managementQueueController = new ManagementQueueController(managementQueueServiceImpl);
    }

    @Test
    void doOperationsInQueue() throws TechnicalException {
        InputQueue inputQueue = MockFactory.generateOperations();
        InputDO inputDO = MockFactory.generateInputDO();
        Mockito.when(managementQueueServiceImpl.saveInputOperations(inputQueue)).thenReturn(inputDO);
        Mockito.when(managementQueueServiceImpl.doOperationsQueue(inputQueue)).thenReturn("14\n14");

        ResponseEntity<String> responseEntity = managementQueueController.doOperationsInQueue(inputQueue);
        String response = responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals("14\n14", response);
    }

    @Test
    void doOperationsInQueueFailed() throws TechnicalException {
        InputQueue inputQueue = MockFactory.generateOperationsFailed();
        InputDO inputDO = MockFactory.generateInputDO();
        Mockito.when(managementQueueServiceImpl.saveInputOperations(inputQueue)).thenThrow(new TechnicalException(""));

        ResponseEntity<String> responseEntity = managementQueueController.doOperationsInQueue(inputQueue);
        String response = responseEntity.getBody();
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        Assertions.assertEquals(MessageError.DATA_ERROR, response);
    }
}