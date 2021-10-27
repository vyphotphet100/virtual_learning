package com.webpro.virtual_learning.dao;

import java.util.List;

public interface IBaseDAO<T>{
    List<T> findAll();
    T save(T entity);
    T update(T entity);
}
