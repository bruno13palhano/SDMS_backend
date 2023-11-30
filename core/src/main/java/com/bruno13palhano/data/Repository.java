package com.bruno13palhano.data;

import java.util.List;

public interface Repository<T> {
    void insert(T data);
    void update(T data);
    void deleteById(Long id);
    List<T> getAll();
}
