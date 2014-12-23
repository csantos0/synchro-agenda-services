package br.com.synchro.dao.impl;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.synchro.dao.GenericJpaDao;
import br.com.synchro.domain.User;
import br.com.synchro.enums.EnumHqlQuery;
import br.com.synchro.exception.DaoException;
import br.com.synchro.util.StringUtil;

/**
 * 
 * UserDaoImpl.java
 * Criado em Sep 20, 2014
 * @author Ciro S. Santos
 * @version 1.0
 */
@Repository
public class UserDaoImpl extends GenericJpaDao<User, Integer> implements UserDao{

	@Override
	public User findUserByUsername(String username) throws DaoException{
		try{
			String hql = EnumHqlQuery.USER_LOGIN_QUERY.getQuery();
			Query query = this.entityManager.createQuery(hql);	
			query.setParameter("username", username);
			return (User) query.getSingleResult();				
		}catch(PersistenceException ex){
			return null;
		}catch(Exception ex){
			throw new DaoException(this.getClass().getName() + ".findUserByUsername(String username)", ex.getMessage(), StringUtil.getStackTrace(ex));
		}
	}
}
