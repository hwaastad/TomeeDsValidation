/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.producer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.apache.deltaspike.data.api.EntityManagerResolver;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
public class CrmEntityManagerResolver implements EntityManagerResolver {

    @Inject
    private EntityManager em;

    @Override
    public EntityManager resolveEntityManager() {
        return em;
    }

}
