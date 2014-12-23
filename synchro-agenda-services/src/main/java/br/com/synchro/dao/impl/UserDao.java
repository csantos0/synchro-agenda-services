package br.com.synchro.dao.impl;

import br.com.synchro.dao.GenericDao;
import br.com.synchro.domain.User;
import br.com.synchro.exception.DaoException;

/**
 * 
 * UserDao.java
 * Criado em Sep 20, 2014
 * @author Ciro S. Santos
 * @version 1.0
 */
public interface UserDao extends GenericDao<User, Integer>{

	public User findUserByUsername(String username) throws DaoException;
}
