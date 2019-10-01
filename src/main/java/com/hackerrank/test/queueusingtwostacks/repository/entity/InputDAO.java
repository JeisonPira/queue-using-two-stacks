package com.hackerrank.test.queueusingtwostacks.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "inputs")
public class InputsDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number_operations")
    private int numberOperations;

    @Column(name = "result")
    private String result;

    @OneToMany(mappedBy = "inputsDao", cascade = CascadeType.ALL)
    private Set<OperationsDAO> operationsDAOSet;
}
