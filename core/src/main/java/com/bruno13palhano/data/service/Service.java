package com.bruno13palhano.data.service;

import java.util.List;

public interface Service<T> {
    void insert(T model);
    void update(T model);
    void delete(Long id);
    List<T> getAll();
}
