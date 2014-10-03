/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@ApplicationScoped
public class EntityManagerProducer {

    @Produces
    public EntityManager createEntityManager(EntityManagerFactory entityManagerFactory) {
        System.out.println("Producing entitymanager.....");
        return (EntityManager) JtaEntityManagerProxy.newInstance(entityManagerFactory.createEntityManager());
    }

    public void close(@Disposes EntityManager entityManager) {
        if (entityManager.isOpen()) {
            System.out.println("Disposing entitymanager......");
            entityManager.close();
        }
    }

}
