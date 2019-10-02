package com.hackerrank.test.queueusingtwostacks.services.mapper;

@FunctionalInterface
public interface Mapper<I, O> {
    O map(I object);
}
