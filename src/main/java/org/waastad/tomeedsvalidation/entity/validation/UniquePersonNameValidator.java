/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.entity.validation;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.waastad.tomeedsvalidation.repository.PersonRepository;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
public class UniquePersonNameValidator implements ConstraintValidator<UniquePersonName, String> {

    @Inject
    private PersonRepository personRepository;

    @Override
    public void initialize(UniquePersonName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return personRepository.findPersonByName(value) == null;
    }
}
