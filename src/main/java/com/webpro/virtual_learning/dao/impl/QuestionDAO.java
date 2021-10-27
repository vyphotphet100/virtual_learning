package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.IQuestionDAO;
import com.webpro.virtual_learning.entity.QuestionEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO extends BaseDAO<QuestionEntity> implements IQuestionDAO {
    @Override
    public List<QuestionEntity> findAll() {
        EntityManager em = this.emf.createEntityManager();
        Query q = em.createQuery("SELECT q FROM QuestionEntity q");
        List<QuestionEntity> questionEntities = new ArrayList<>();
        try {
            questionEntities = q.getResultList();
        } catch (NoResultException e) {
            questionEntities = new ArrayList<>();
        }

        em.close();
        return questionEntities;
    }

    @Override
    public QuestionEntity save(QuestionEntity entity) {
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
    public QuestionEntity update(QuestionEntity entity) {
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
    public QuestionEntity findById(Long id) {
        EntityManager em = this.emf.createEntityManager();
        Query q = em.createQuery("SELECT q FROM QuestionEntity q WHERE q.id = :id");
        q.setParameter("id", id);
        QuestionEntity questionEntity = null;
        try {
            questionEntity = (QuestionEntity)q.getSingleResult();
        } catch (NoResultException e) {
            questionEntity = null;
        }

        em.close();
        return questionEntity;
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
