/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.waastad.tomeedsvalidation.entity.Customer;
import org.waastad.tomeedsvalidation.entity.Person;
import org.waastad.tomeedsvalidation.repository.CustomerRepository;
import org.waastad.tomeedsvalidation.repository.PersonRepository;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Stateless
public class BusinessBean {

    @Inject
    private CustomerRepository customerRepository;
    @Inject
    PersonRepository personRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Customer addPersonToCustomer(String customerName, String personName) {
        Person person = personRepository.findPersonByName(personName);
        Customer customer = customerRepository.findByName(customerName);
        customer.addPersonToCustomer(person);
        return customer;
    }
    
    public Person updatePerson(Person person){
        return personRepository.updatePersonJpa(person);
    }

}
