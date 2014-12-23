package br.com.synchro.service;

import br.com.synchro.domain.User;
import br.com.synchro.exception.ServiceException;

/**
 * 
 * UserService.java
 * Criado em Sep 24, 2014
 * @author Ciro S. Santos
 * @version 1.0
 */
public interface UserService {

	public User findUserByUsername(String username) throws ServiceException;
	
	public String persist(User entity) throws ServiceException;
}
