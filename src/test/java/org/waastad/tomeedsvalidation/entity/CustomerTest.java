/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.entity;

import java.util.concurrent.Callable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.openejb.junit.jee.EJBContainerRule;
import org.apache.openejb.junit.jee.InjectRule;
import org.apache.openejb.junit.jee.config.PropertyFile;
import org.junit.Test;
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
    
    @EJB
    private Caller transactionCaller;
    
    public CustomerTest() {
    }
    
    @Test
    public void testSomeMethod() throws Exception {
        Customer c = new Customer("name");
        Customer c2 = new Customer("name");
        customerRepository.save(c);
        try {
            customerRepository.save(c2);
        } catch (Exception e) {
            System.out.println(ExceptionUtils.getRootCauseMessage(e));
        }      
    }
    
    public static interface Caller {
        
        public <V> V call(Callable<V> callable) throws Exception;
    }
    
    @Stateless
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public static class TransactionITBean implements Caller {
        
        @Override
        public <V> V call(Callable<V> callable) throws Exception {
            return callable.call();
        }
    }
    
}
