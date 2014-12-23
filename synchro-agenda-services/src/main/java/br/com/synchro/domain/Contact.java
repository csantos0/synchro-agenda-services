package br.com.synchro.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * Contact.java Criado em Sep 21, 2014
 * 
 * @author Ciro S. Santos
 * @version 1.0
 */
@Entity
@Table(name = "tb_contact")
@XmlRootElement
@SuppressWarnings("serial")
public class Contact implements Serializable {

    @Id
    @SequenceGenerator(name = "SYN_SEQ_CONTACT", sequenceName = "SYN_SEQ_CONTACT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SYN_SEQ_CONTACT")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name = "addressid")
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private User user;

    public Address getAddress() {
	return address;
    }

    public String getEmail() {
	return email;
    }

    public Long getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public String getPhone() {
	return phone;
    }

    public String getSurname() {
	return surname;
    }

    @JsonProperty("user")
    public User getUser() {
	return user;
    }

    public void setAddress(final Address address) {
	this.address = address;
    }

    public void setEmail(final String email) {
	this.email = email;
    }

    public void setId(final Long id) {
	this.id = id;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public void setPhone(final String phone) {
	this.phone = phone;
    }

    public void setSurname(final String surname) {
	this.surname = surname;
    }

    public void setUser(final User user) {
	this.user = user;
    }

    @Override
    public String toString() {
	return "Contact [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone
		+ ", address=" + address + ", user=" + user + "]";
    }

}
