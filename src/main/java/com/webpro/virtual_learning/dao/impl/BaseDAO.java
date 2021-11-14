package com.webpro.virtual_learning.dao.impl;

import com.webpro.virtual_learning.dao.IBaseDAO;
import com.webpro.virtual_learning.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public abstract class BaseDAO<T> implements IBaseDAO<T> {
    private EntityManagerFactory emf;
    private ResourceBundle db = ResourceBundle.getBundle("db");

    protected EntityManagerFactory getEntityManagerFactory() {
        if (emf != null)
            return emf;

        try {
            Configuration configuration = new Configuration();

            Properties settings = new Properties();
            settings.put(Environment.DRIVER, db.getString("driverName"));
            settings.put(Environment.URL, db.getString("url"));
            settings.put(Environment.USER, db.getString("username"));
            settings.put(Environment.PASS, db.getString("password"));
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

            //settings.put(Environment.SHOW_SQL, "true");
            //settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            settings.put(Environment.HBM2DDL_AUTO, "none");

            configuration.setProperties(settings);
            configuration.addAnnotatedClass(ClassEntity.class);
            configuration.addAnnotatedClass(LessonEntity.class);
            configuration.addAnnotatedClass(QuestionEntity.class);
            configuration.addAnnotatedClass(RoleEntity.class);
            configuration.addAnnotatedClass(SubjectEntity.class);
            configuration.addAnnotatedClass(UserEntity.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate Java Config serviceRegistry created");
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            emf = sessionFactory.openSession().getEntityManagerFactory();
            return emf;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
