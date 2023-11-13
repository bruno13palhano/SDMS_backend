package com.bruno13palhano.data;

public interface Repository<T> {
    void insert(T data);
    void update(T data);
    void deleteById(Long id);
    Iterable<T> getAll();
}
