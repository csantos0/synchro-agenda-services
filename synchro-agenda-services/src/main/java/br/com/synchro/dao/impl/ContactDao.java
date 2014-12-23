package br.com.synchro.dao.impl;

import java.util.List;

import br.com.synchro.dao.GenericDao;
import br.com.synchro.domain.Contact;
import br.com.synchro.exception.DaoException;

/**
 * 
 * ContactDao.java
 * Criado em Sep 20, 2014
 * @author Ciro S. Santos
 * @version 1.0
 */
public interface ContactDao extends GenericDao<Contact, Long>{
	
	public List<Contact> findContactsByUsername(String username) throws DaoException;
	
	public List<Contact> searchContactsByName(String name, String username) throws DaoException;
}
