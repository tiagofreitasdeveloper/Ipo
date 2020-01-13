package com.softure.rendavariavel.Ipo.domain.rules;

@FunctionalInterface
public interface CheckRule<T> {

    Boolean check(T t);
}
