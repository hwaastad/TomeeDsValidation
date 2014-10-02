/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.entity;

import javax.inject.Inject;
import org.apache.openejb.junit.jee.EJBContainerRule;
import org.apache.openejb.junit.jee.InjectRule;
import org.apache.openejb.junit.jee.config.PropertyFile;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.waastad.tomeedsvalidation.repository.CustomerRepository;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@PropertyFile("test-lab-hsql.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerTest {

    @ClassRule
    public static final EJBContainerRule CONTAINER_RULE = new EJBContainerRule();
    @Rule
    public final InjectRule injectRule = new InjectRule(this, CONTAINER_RULE);

    @Inject
    private CustomerRepository customerRepository;

    public CustomerTest() {
    }

    @Test
    public void testSomeMethod() {
        Customer c = new Customer("name");
        customerRepository.save(c);
    }

}
