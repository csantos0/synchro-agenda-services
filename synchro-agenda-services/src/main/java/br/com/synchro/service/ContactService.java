package br.com.synchro.service;

import java.util.List;

import br.com.synchro.domain.Contact;
import br.com.synchro.domain.dto.ContactDTO;
import br.com.synchro.exception.ServiceException;

/**
 * 
 * ContactService.java
 * Criado em Sep 21, 2014
 * @author Ciro S. Santos
 * @version 1.0
 */
public interface ContactService {

	public String persist(Contact entity) throws ServiceException;

	public String update(Contact entity) throws ServiceException;

	public String delete(String id) throws ServiceException;

	public Contact loadById(String id) throws ServiceException;

	public List<ContactDTO> loadAll() throws ServiceException;	
	
	public List<ContactDTO> findContactsByUsername(String username) throws ServiceException;
	
	public List<ContactDTO> searchByName(String name, String username) throws ServiceException;
}
