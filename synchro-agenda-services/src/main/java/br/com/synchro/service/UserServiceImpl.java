package br.com.synchro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.synchro.dao.impl.UserDao;
import br.com.synchro.domain.User;
import br.com.synchro.enums.EnumOutput;
import br.com.synchro.exception.DaoException;
import br.com.synchro.exception.ServiceException;

/**
 * 
 * UserServiceImpl.java
 * Criado em Sep 24, 2014
 * @author Ciro S. Santos
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public String persist(User entity) throws ServiceException {
		try{
			this.userDao.persist(entity);
			return EnumOutput.SUCCESS_ADD.getValue();
		}catch (DaoException ex) {
			throw new ServiceException(ex.getMethodName(), ex.getMessage(), ex.getStack());
		}		
	}

	public User findUserByUsername(String username) throws ServiceException{
		try{
			return this.userDao.findUserByUsername(username);
		}catch (DaoException ex) {
			throw new ServiceException(ex.getMethodName(), ex.getMessage(), ex.getStack());
		}
	}
}
