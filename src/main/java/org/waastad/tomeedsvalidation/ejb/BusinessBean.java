/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import org.waastad.tomeedsvalidation.entity.Customer;
import org.waastad.tomeedsvalidation.repository.CustomerRepository;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Stateless
public class BusinessBean {

    @Inject
    private CustomerRepository customerRepository;
    
    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

}
