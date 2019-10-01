package com.hackerrank.test.queueusingtwostacks.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "inputs")
public class InputDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number_operations")
    private int numberOperations;

    @Column(name = "result")
    private String result;

    @OneToMany(mappedBy = "inputDAO", cascade = CascadeType.ALL)
    private Set<OperationsDAO> operationsDAOSet;
}
