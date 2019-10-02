package com.hackerrank.test.queueusingtwostacks.services;

import com.hackerrank.test.queueusingtwostacks.controller.entity.InputQueue;
import com.hackerrank.test.queueusingtwostacks.domain.InputDO;
import com.hackerrank.test.queueusingtwostacks.exception.TechnicalException;

public interface ManagementQueueService {
    InputDO saveInputOperations(InputQueue inputQueue) throws TechnicalException;

    String doOperationsQueue(InputQueue inputQueue);

    long saveOutputOperations(InputDO inputDO);
}
