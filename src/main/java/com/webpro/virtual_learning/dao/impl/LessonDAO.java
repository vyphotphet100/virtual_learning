package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.ILessonDAO;
import com.webpro.virtual_learning.entity.LessonEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class LessonDAO extends BaseDAO<LessonEntity> implements ILessonDAO {
    @Override
    public List<LessonEntity> findAll() {
        EntityManager em = this.emf.createEntityManager();
        Query q = em.createQuery("SELECT l FROM LessonEntity l");
        List<LessonEntity> lessonEntities = new ArrayList<>();
        try {
            lessonEntities = new ArrayList<>();
        } catch (NoResultException e) {
            lessonEntities = new ArrayList<>();
        }

        em.close();
        return lessonEntities;
    }

    @Override
    public LessonEntity save(LessonEntity entity) {
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
        return this.findById(entity.getId());
    }

    @Override
    public LessonEntity update(LessonEntity entity) {
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
        return this.findById(entity.getId());
    }

    @Override
    public LessonEntity findById(Long id) {
        EntityManager em = this.emf.createEntityManager();
        Query q = em.createQuery("SELECT l FROM LessonEntity l WHERE l.id = :id");
        q.setParameter("id", id);
        LessonEntity lessonEntity = null;
        try {
            lessonEntity = (LessonEntity)q.getSingleResult();
        } catch (NoResultException e) {
            lessonEntity = null;
        }

        em.close();
        return lessonEntity;
    }

    @Override
    public void delete(Long id) {
        EntityManager em  = emf.createEntityManager();
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
