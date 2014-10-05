/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.repository;

import java.util.List;
import javax.persistence.FlushModeType;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.waastad.tomeedsvalidation.entity.Customer;
import org.waastad.tomeedsvalidation.producer.CrmEntityManagerResolver;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Repository
@EntityManagerConfig(entityManagerResolver = CrmEntityManagerResolver.class, flushMode = FlushModeType.COMMIT)
public abstract class CustomerRepository extends AbstractEntityRepository<Customer, Long> {

    @Query(named = Customer.FIND_BY_NAME)
    public abstract List<Customer> findByName(@QueryParam("name") String name);

    @Query(named = Customer.FIND_ALL)
    public abstract List<Customer> getAllCustomers();

    public void saveJpa(Customer customer) {
        this.entityManager().persist(customer);
    }

}
