package com.webpro.virtual_learning.lowerdao;

import java.util.List;

public interface IBaseLowerDAO<T> {
    List<T> query(String sql, Class tClass);
    Object insert(String sql, Object... params);
    void delete(String sql, Object... params);
}
