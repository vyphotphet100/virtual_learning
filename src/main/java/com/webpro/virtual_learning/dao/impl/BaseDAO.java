package com.webpro.virtual_learning.dao.impl;
import com.webpro.virtual_learning.dao.IBaseDAO;
import com.webpro.virtual_learning.lowerdao.IBaseLowerDAO;
import com.webpro.virtual_learning.lowerdao.impl.BaseLowerDAO;

public abstract class BaseDAO<T> implements IBaseDAO<T> {
    IBaseLowerDAO<T> baseLowerDao = new BaseLowerDAO<T>();
}
