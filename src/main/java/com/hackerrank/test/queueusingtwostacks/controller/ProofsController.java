package com.hackerrank.test.queueusingtwostacks.controller;

import com.hackerrank.test.queueusingtwostacks.controller.entity.Operations;
import com.hackerrank.test.queueusingtwostacks.services.ProofsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proofs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class ProofsController {

    private final ProofsService proofsService;

    @GetMapping
    public ResponseEntity getOperations() {
        return null;
    }
}
