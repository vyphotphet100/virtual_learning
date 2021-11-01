package com.webpro.virtual_learning.dao.impl;
import com.webpro.virtual_learning.dao.IRoleDAO;
import com.webpro.virtual_learning.entity.RoleEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends BaseDAO<RoleEntity> implements IRoleDAO{
    @Override
    public List<RoleEntity> findAll() {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        Query q = em.createQuery("SELECT r FROM RoleEntity r");
        List<RoleEntity> roleEntities = new ArrayList<>();
        try {
            roleEntities = q.getResultList();
        } catch (NoResultException e) {
            roleEntities = new ArrayList<>();
        }

        em.close();
        return roleEntities;
    }

    @Override
    public RoleEntity save(RoleEntity entity) {
        EntityManager em  = getEntityManagerFactory().createEntityManager();
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
        return this.findById(entity.getId());
    }

    @Override
    public RoleEntity update(RoleEntity entity) {
        EntityManager em  = getEntityManagerFactory().createEntityManager();
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
        return this.findById(entity.getId());
    }

    @Override
    public RoleEntity findById(Long id) {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        Query q = em.createQuery("SELECT r FROM RoleEntity r WHERE r.id = :id");
        q.setParameter("id", id);
        RoleEntity roleEntity = null;
        try {
            roleEntity = (RoleEntity) q.getSingleResult();
        } catch (NoResultException e) {
            roleEntity = null;
        }

        em.close();
        return roleEntity;
    }

    @Override
    public void delete(Long id) {
        EntityManager em  = getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(this.findById(id)));
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
