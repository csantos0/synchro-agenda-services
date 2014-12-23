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
 * Address.java Criado em Sep 21, 2014
 * 
 * @author Ciro S. Santos
 * @version 1.0
 */
@Entity
@Table(name = "tb_address")
@XmlRootElement
@SuppressWarnings("serial")
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "SYN_SEQ_ADDRESS", sequenceName = "SYN_SEQ_ADDRESS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SYN_SEQ_ADDRESS")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number_id")
    private Integer number;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    @Column(name = "zipcode")
    private String zipcode;

    public String getCity() {
	return city;
    }

    public String getDistrict() {
	return district;
    }

    public Long getId() {
	return id;
    }

    public Integer getNumber() {
	return number;
    }

    public String getStreet() {
	return street;
    }

    public String getZipcode() {
	return zipcode;
    }

    public void setCity(final String city) {
	this.city = city;
    }

    public void setDistrict(final String district) {
	this.district = district;
    }

    public void setId(final Long id) {
	this.id = id;
    }

    public void setNumber(final Integer number) {
	this.number = number;
    }

    public void setStreet(final String street) {
	this.street = street;
    }

    public void setZipcode(final String zipcode) {
	this.zipcode = zipcode;
    }

    @Override
    public String toString() {
	return "Address [id=" + id + ", street=" + street + ", number=" + number + ", district=" + district + ", city=" + city
		+ ", zipcode=" + zipcode + "]";
    }
}
