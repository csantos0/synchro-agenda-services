package br.com.synchro.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * User.java Criado em Sep 24, 2014
 * 
 * @author Ciro S. Santos
 * @version 1.0
 */
@Entity
@Table(name = "tb_user")
@XmlRootElement
@SuppressWarnings("serial")
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "SYN_SEQ_USER", sequenceName = "SYN_SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SYN_SEQ_USER")
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Integer getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public String getPassword() {
	return password;
    }

    public String getSurname() {
	return surname;
    }

    public String getUsername() {
	return username;
    }

    public void setId(final Integer id) {
	this.id = id;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public void setPassword(final String password) {
	this.password = password;
    }

    public void setSurname(final String surname) {
	this.surname = surname;
    }

    public void setUsername(final String username) {
	this.username = username;
    }

    @Override
    public String toString() {
	return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password
		+ "]";
    }
}
