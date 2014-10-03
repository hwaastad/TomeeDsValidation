/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.repository;

import java.util.List;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.waastad.tomeedsvalidation.entity.Customer;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Repository
public abstract class CustomerRepository extends AbstractEntityRepository<Customer, Long> {
    
    @Query(named = Customer.FIND_BY_NAME)
    public abstract List<Customer> findByName(@QueryParam("name") String name);
    
    public void saveJpa(Customer customer) {
        this.entityManager().persist(customer);
    }
    
}
