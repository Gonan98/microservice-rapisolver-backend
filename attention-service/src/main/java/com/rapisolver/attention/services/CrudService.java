package com.rapisolver.attention.services;

import java.util.List;

public interface CrudService<C, R, ID> {
    R create(C t) throws RuntimeException;
    List<R> getAll() throws RuntimeException;
    R getById(ID id) throws RuntimeException;
    R update(ID id, C t) throws RuntimeException;
    String deleteById(ID id) throws RuntimeException;
}
