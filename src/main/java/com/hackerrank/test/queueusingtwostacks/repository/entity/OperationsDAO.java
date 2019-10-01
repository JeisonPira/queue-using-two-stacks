package com.hackerrank.test.queueusingtwostacks.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "operations")
public class OperationsDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn
    private InputDAO inputDAO;

    @Column(name = "code_operation")
    private int codeOperation;

    @Column(name = "operation_value")
    private int operationValue;

}
