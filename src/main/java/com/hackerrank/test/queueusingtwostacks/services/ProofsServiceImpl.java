package com.hackerrank.test.queueusingtwostacks.services;

import com.hackerrank.test.queueusingtwostacks.domain.TestsDO;
import com.hackerrank.test.queueusingtwostacks.repository.InputRepository;
import com.hackerrank.test.queueusingtwostacks.repository.OperationRepository;
import com.hackerrank.test.queueusingtwostacks.repository.entity.InputDAO;
import com.hackerrank.test.queueusingtwostacks.repository.entity.OperationsDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProofsServiceImpl implements ProofsService {

    private final InputRepository inputRepository;
    private final OperationRepository operationRepository;

    @Override
    public List<TestsDO> getProofs(int limit, int page) {
        Pageable pageable = PageRequest.of(page, limit);
        List<TestsDO> testsList = new ArrayList<>();
        //List<OperationDO> operationDOList = new ArrayList<>();
        Page<InputDAO> inputRepositoryAll = inputRepository.findAll(pageable);
        /*List<InputDAO> ids = operations.stream()
                .map(item -> item.getInputDAO())
                .filter(distinctByKey(InputDAO::getId))
                .collect(Collectors.toList());*/
        for (InputDAO inputDAO : inputRepositoryAll) {
            List<OperationsDAO> operationsDAOList = operationRepository.findByIdInput(inputDAO.getId());
            /*List<OperationsDAO> operationsDAOList = operations.stream()
                    .filter(item -> inputDAO.getId() == item.getInputDAO().getId())
                    .collect(Collectors.toList());

            List<OperationDO> operationsDOList = operationsDAOList.stream()
            .map(operationDAOToOperationDOMapper::map)
            .collect(Collectors.toList());*/


            String operations = operationsDAOList.stream()
                    .map(OperationsDAO::toString)
                    .collect(Collectors.joining(" - "));

            testsList.add(TestsDO.builder()
                    .numberOperations(inputDAO.getNumberOperations())
                    .operations(operations)
                    .result(inputDAO.getResult())
                    .build());
        }

        return testsList;
    }

    private <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
