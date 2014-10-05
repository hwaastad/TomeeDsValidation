/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.tomeedsvalidation.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import org.waastad.tomeedsvalidation.entity.validation.UniqueName;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Customer.FIND_BY_NAME, query = "SELECT t FROM Customer t WHERE t.name=:name"),
    @NamedQuery(name = Customer.FIND_ALL, query = "SELECT t FROM Customer t")
})
public class Customer implements Serializable {

    public static final String FIND_BY_NAME = "Customer.FindByName";
    public static final String FIND_ALL = "Customer.FindAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "name", nullable = false, length = 255, unique = true)
    @UniqueName
    private String name;

    @JoinTable(name = "customer_person", joinColumns = {
        @JoinColumn(name = "customerId", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "personId", referencedColumnName = "id")})
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<Person> personCollection;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.waastad.tomeedsvalidation.entity.Customer[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Person> getPersonCollection() {
        if (personCollection == null) {
            personCollection = new ArrayList<>();
        }
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

}
