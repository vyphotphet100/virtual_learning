package com.webpro.virtual_learning.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("virtual_learning");
    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
