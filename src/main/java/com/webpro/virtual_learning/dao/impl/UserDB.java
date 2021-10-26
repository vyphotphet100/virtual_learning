package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.entity.RoleEntity;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.utils.DBUtil;
import com.webpro.virtual_learning.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDB {
    public static UserEntity getUserById() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("virtual_learning");
        EntityManager em = emf.createEntityManager();
        try {
            UserEntity user = em.find(UserEntity.class, "user1");
            return null;
        } finally {
            em.close();
        }
    }

    public static UserEntity getUserById2() {
        Transaction transaction = null;
        RoleEntity user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            user = session.get(RoleEntity.class, 1L);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
}
