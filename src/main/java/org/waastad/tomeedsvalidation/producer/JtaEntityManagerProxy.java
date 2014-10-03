/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.producer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.persistence.EntityManager;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
public class JtaEntityManagerProxy implements InvocationHandler {

    private EntityManager obj;

    public static Object newInstance(EntityManager obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class<?>[]{EntityManager.class}, new JtaEntityManagerProxy(obj));
    }

    private JtaEntityManagerProxy(EntityManager obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        Object result;
        try {
            obj.joinTransaction();
            result = m.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (IllegalAccessException | IllegalArgumentException e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage(), e);
        } finally {
        }
        return result;
    }

}
