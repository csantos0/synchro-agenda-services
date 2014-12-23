package br.com.synchro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.synchro.dao.GenericJpaDao;
import br.com.synchro.domain.Contact;
import br.com.synchro.domain.util.Parameter;
import br.com.synchro.enums.EnumHqlQuery;
import br.com.synchro.exception.DaoException;
import br.com.synchro.util.StringUtil;

/**
 * 
 * ContactDaoImpl.java
 * Criado em Sep 20, 2014
 * @author Ciro S. Santos
 * @version 1.0
 */
@Repository
public class ContactDaoImpl extends GenericJpaDao<Contact, Long> implements ContactDao{
	
	@Override
	@SuppressWarnings("unchecked")	
	public List<Contact> findContactsByUsername(String username) throws DaoException{
		try{
			String hql = EnumHqlQuery.CONTACT_SEARCH_BY_LOGIN.getQuery();
			Query query = this.entityManager.createQuery(hql);	
			query.setParameter("usernameParam", username);
			return query.getResultList();				
		}catch(PersistenceException ex){
			return null;
		}catch(Exception ex){
			throw new DaoException(this.getClass().getName() + ".findContactsByUsername(String username)", ex.getMessage(), StringUtil.getStackTrace(ex));
		}
	}
	
	@Override	
	public List<Contact> searchContactsByName(String name, String username) throws DaoException{
		try{
			String hql = EnumHqlQuery.CONTACT_SEARCH_BY_NAME.getQuery();
			List<Parameter> paramList = new ArrayList<Parameter>();
			paramList.add(new Parameter("usernameParam", username));
			paramList.add(new Parameter("nameParam","%"+name+"%"));			
			return this.executeHqlQuery(hql, paramList);			
		}catch(PersistenceException ex){
			return null;
		}catch(Exception ex){
			throw new DaoException(this.getClass().getName() + ".searchContactsByName(String name)", ex.getMessage(), StringUtil.getStackTrace(ex));
		}
	}

}
