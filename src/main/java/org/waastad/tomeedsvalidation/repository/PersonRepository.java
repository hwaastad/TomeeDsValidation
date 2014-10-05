/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.repository;

import javax.persistence.FlushModeType;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;
import org.waastad.tomeedsvalidation.entity.Person;
import org.waastad.tomeedsvalidation.producer.CrmEntityManagerResolver;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Repository
@EntityManagerConfig(entityManagerResolver = CrmEntityManagerResolver.class, flushMode = FlushModeType.COMMIT)
public abstract class PersonRepository extends AbstractEntityRepository<Person, Long> {

    @Query(named = Person.FIND_BY_NAME, singleResult = SingleResultType.ANY)
    public abstract Person findPersonByName(@QueryParam("name") String name);

    public Person updatePersonJpa(Person person) {
        return this.entityManager().merge(person);
    }
}
