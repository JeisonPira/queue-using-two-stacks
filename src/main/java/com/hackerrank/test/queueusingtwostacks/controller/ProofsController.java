package com.hackerrank.test.queueusingtwostacks.controller;

import com.hackerrank.test.queueusingtwostacks.controller.entity.Tests;
import com.hackerrank.test.queueusingtwostacks.controller.mapper.TestDOToTest;
import com.hackerrank.test.queueusingtwostacks.domain.TestsDO;
import com.hackerrank.test.queueusingtwostacks.services.ProofsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proofs")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class ProofsController {

    private final ProofsService proofsService;
    private final TestDOToTest testDOToTest;

    @GetMapping
    public ResponseEntity getOperations(@RequestParam("limit") int limit, @RequestParam("page") int page) {
        List<TestsDO> testsDOList = proofsService.getProofs(limit, page);

        List<Tests> testsList = testsDOList.stream()
                .map(testDOToTest::map)
                .collect(Collectors.toList());

        return new ResponseEntity<>(testsList, HttpStatus.OK);
    }
}
