package com.webpro.virtual_learning.service;

import java.util.List;

public interface IBaseService<D, E> {
    List<E> findAll();
    E save(D dto);
    E update(D dto);
}
