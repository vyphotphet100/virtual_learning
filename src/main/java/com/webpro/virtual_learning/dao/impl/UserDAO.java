package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.IUserDAO;
import com.webpro.virtual_learning.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends BaseDAO<UserEntity> implements IUserDAO {

    @Override
    public List<UserEntity> findAll() {
        EntityManager em = this.emf.createEntityManager();
        Query q = em.createQuery("SELECT u FROM UserEntity u");
        List<UserEntity> userEntities = new ArrayList<>();
        try {
            userEntities = q.getResultList();
        } catch (NoResultException e) {
            userEntities = new ArrayList<>();
        }

        em.close();
        return userEntities;
    }

    @Override
    public UserEntity save(UserEntity entity) {
        EntityManager em  = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return null;
        } finally {
            em.close();
        }
        return this.findById(entity.getUsername());
    }

    @Override
    public UserEntity update(UserEntity entity) {
        EntityManager em  = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(entity);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return null;
        } finally {
            em.close();
        }
        return this.findById(entity.getUsername());
    }

    @Override
    public UserEntity findById(String username) {
        EntityManager em = this.emf.createEntityManager();
        Query q = em.createQuery("SELECT u FROM UserEntity u WHERE u.username = :username");
        q.setParameter("username", username);
        UserEntity userEntity = null;
        try {
            userEntity = (UserEntity)q.getSingleResult();
        } catch (NoResultException e) {
            userEntity = null;
        }

        em.close();
        return userEntity;
    }

    @Override
    public void delete(String username) {
        EntityManager em  = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(this.findById(username)));
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
