/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.entity.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Documented
@Constraint(validatedBy = UniquePersonNameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePersonName {

    String message() default "{org.waastad.tomeedsvalidation.entity.validation.UniquePersonName}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
