package com.springbootapplication.services;

import java.util.Collection;

public interface CRUDService<T> {
    T getById(Long id);
    Collection<T> getAll();
    void create(T item);
    void update(Long id, T item);
    void delete(Long id);
}
