package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.ISubjectDAO;
import com.webpro.virtual_learning.entity.SubjectEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO extends BaseDAO<SubjectEntity> implements ISubjectDAO {
    @Override
    public List<SubjectEntity> findAll() {
        EntityManager em = this.emf.createEntityManager();
        Query q = em.createQuery("SELECT s FROM SubjectEntity s");
        List<SubjectEntity> subjectEntities = new ArrayList<>();
        try {
            subjectEntities = q.getResultList();
        } catch (NoResultException e) {
            subjectEntities = new ArrayList<>();
        }

        em.close();
        return subjectEntities;
    }

    @Override
    public SubjectEntity save(SubjectEntity entity) {
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
    public SubjectEntity update(SubjectEntity entity) {
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
    public SubjectEntity findById(Long id) {
        EntityManager em = this.emf.createEntityManager();
        Query q = em.createQuery("SELECT s FROM SubjectEntity s WHERE s.id = :id");
        q.setParameter("id", id);
        SubjectEntity subjectEntity = null;
        try {
            subjectEntity = (SubjectEntity)q.getSingleResult();
        } catch (NoResultException e) {
            subjectEntity = null;
        }

        em.close();
        return subjectEntity;
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
