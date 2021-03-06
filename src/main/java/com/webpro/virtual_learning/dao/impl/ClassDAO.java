package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.IClassDAO;
import com.webpro.virtual_learning.entity.ClassEntity;
import com.webpro.virtual_learning.entity.UserEntity;
import org.springframework.beans.BeanUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO extends BaseDAO<ClassEntity> implements IClassDAO{
    @Override
    public List<ClassEntity> findAll() {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        Query q = em.createQuery("SELECT c FROM ClassEntity c");
        List<ClassEntity> classEntities = new ArrayList<>();
        try {
            classEntities = q.getResultList();
        } catch (NoResultException e) {
            classEntities = new ArrayList<>();
        }

        em.close();
        return classEntities;
    }

    @Override
    public ClassEntity save(ClassEntity entity) {
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
    public ClassEntity update(ClassEntity entity) {
        EntityManager em  = getEntityManagerFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            ClassEntity classEntity = this.findById(entity.getId());
            BeanUtils.copyProperties(entity, classEntity, getNullPropertyNames(entity));
            em.merge(classEntity);
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
    public ClassEntity findById(Long id) {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        Query q = em.createQuery("SELECT c FROM ClassEntity c WHERE c.id = :id");
        q.setParameter("id", id);
        ClassEntity classEntity = null;
        try {
            classEntity = (ClassEntity)q.getSingleResult();
        } catch (NoResultException e) {
            classEntity = null;
        }

        em.close();
        return classEntity;
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

    @Override
    public List<ClassEntity> findAllByName(String name) {
        EntityManager em = this.getEntityManagerFactory().createEntityManager();
        Query q = em.createQuery("SELECT c FROM ClassEntity c WHERE c.name like %" + name + "%");
        List<ClassEntity> classEntities = new ArrayList<>();
        try {
            classEntities = q.getResultList();
        } catch (NoResultException e) {
            classEntities = new ArrayList<>();
        }

        em.close();
        return classEntities;
    }
}
