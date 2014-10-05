/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.entity.validation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.waastad.tomeedsvalidation.repository.CustomerRepository;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Inject
    private CustomerRepository customerRepository;

    @Override
    public void initialize(UniqueName constraintAnnotation) {
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        return customerRepository.findByName(value) == null;
    }
}
