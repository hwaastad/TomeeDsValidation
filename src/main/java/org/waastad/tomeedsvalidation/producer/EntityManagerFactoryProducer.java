/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
public class EntityManagerFactoryProducer {

    @Produces
    @ApplicationScoped
    public EntityManagerFactory createEntityManagerFactory() {
        System.out.println("Producing EMF......");
        return Persistence.createEntityManagerFactory("ValidationPU");
    }
    
    public void close(@Disposes EntityManagerFactory entityManagerFactory){
        System.out.println("Disposing EMF......");
        entityManagerFactory.close();
    }
    
}
