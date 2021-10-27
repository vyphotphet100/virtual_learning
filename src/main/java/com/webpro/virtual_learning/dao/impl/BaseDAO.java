package com.webpro.virtual_learning.dao.impl;
import com.webpro.virtual_learning.dao.IBaseDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseDAO<T> implements IBaseDAO<T> {
    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("virtual_learning");
}
