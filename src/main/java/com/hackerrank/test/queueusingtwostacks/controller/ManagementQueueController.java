package com.hackerrank.test.queueusingtwostacks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/management-queue")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ManagementQueueController {

    @PostMapping(value = "/do-operations", produces = {"application/json"})
    public ResponseEntity doOperationsInQueue(@RequestBody String x) {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
