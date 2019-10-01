package com.hackerrank.test.queueusingtwostacks.services;

import com.hackerrank.test.queueusingtwostacks.domain.OperationDO;
import com.hackerrank.test.queueusingtwostacks.domain.TestsDO;
import com.hackerrank.test.queueusingtwostacks.repository.OperationRepository;
import com.hackerrank.test.queueusingtwostacks.repository.entity.InputDAO;
import com.hackerrank.test.queueusingtwostacks.repository.entity.OperationsDAO;
import com.hackerrank.test.queueusingtwostacks.services.mapper.OperationDAOToOperationDOMapper;
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

    private final OperationRepository operationRepository;
    private final OperationDAOToOperationDOMapper operationDAOToOperationDOMapper;

    @Override
    public List<TestsDO> getOperations(int limit, int page) {
        Pageable pageable = PageRequest.of(page, limit);
        List<TestsDO> testsList = new ArrayList<>();
        //List<OperationDO> operationDOList = new ArrayList<>();
        Page<OperationsDAO> operations = operationRepository.findAll(pageable);
        List<InputDAO> ids = operations.stream()
                .map(item -> item.getInputDAO())
                .filter(distinctByKey(InputDAO::getId))
                .collect(Collectors.toList());
        for (InputDAO inputDAO : ids) {
            List<OperationsDAO> operationsDAOList = operations.stream()
                    .filter(item -> inputDAO.getId() == item.getInputDAO().getId())
                    .collect(Collectors.toList());

            List<OperationDO> operationsDOList = operationsDAOList.stream()
                    .map(operationDAOToOperationDOMapper::map)
                    .collect(Collectors.toList());

            testsList.add(TestsDO.builder()
                    .numberOperations(inputDAO.getNumberOperations())
                    .operations(operationsDOList)
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
