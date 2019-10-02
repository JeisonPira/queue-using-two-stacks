package com.hackerrank.test.queueusingtwostacks.controller;

import com.hackerrank.test.queueusingtwostacks.controller.entity.InputQueue;
import com.hackerrank.test.queueusingtwostacks.domain.InputDO;
import com.hackerrank.test.queueusingtwostacks.exception.TechnicalException;
import com.hackerrank.test.queueusingtwostacks.services.ManagementQueueService;
import com.hackerrank.test.queueusingtwostacks.utils.MessageError;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/management-queue")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ManagementQueueController {

    private final ManagementQueueService managementQueueServiceImpl;

    @PostMapping(value = "/do-operations", produces = {"application/json"})
    public ResponseEntity doOperationsInQueue(@RequestBody InputQueue inputQueue) {
        String result = "-";
        try {
            InputDO inputDO = managementQueueServiceImpl.saveInputOperations(inputQueue);
            result = managementQueueServiceImpl.doOperationsQueue(inputQueue);
            inputDO.setResult(result.replace("\n", " "));
            managementQueueServiceImpl.saveOutputOperations(inputDO);
        } catch (TechnicalException e) {
            return new ResponseEntity<>(MessageError.DATA_ERROR, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
